package com.chuchuan.event;

import com.chuchuan.registry.ModBlocks;
import com.chuchuan.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static com.chuchuan.ChuchuanMod.MOD_ID;

/**
 * 刷子交互（设计文档 4、6.5 章）：
 * - 对璞使用刷子：5% 获得玉；刷一次后璞被刷净、方块消失；
 * - 对火药堆使用刷子：获得硫磺×3，火药堆消耗掉。
 * 每次刷拭耗时 5 秒（冷却 100 tick），冷却期间再点击无效。
 */
@EventBusSubscriber(modid = MOD_ID)
public final class BrushEvents {
    /** 刷拭耗时：100 tick = 5 秒，与原版刷扫可疑方块的过程感对齐 */
    private static final int BRUSH_COOLDOWN_TICKS = 100;

    private BrushEvents() {}

    @SubscribeEvent
    public static void onBrushBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (!player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.BRUSH)) {
            return;
        }
        // 上一次刷拭尚未完成，忽略本次点击
        if (player.getCooldowns().isOnCooldown(Items.BRUSH)) {
            return;
        }
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (block == ModBlocks.PU.get()) {
            if (!level.isClientSide()) {
                // 5% 刷出玉；无论是否出玉，璞都被刷净消失
                if (level.getRandom().nextFloat() < 0.05f) {
                    Block.popResource(level, pos, new ItemStack(ModItems.JADE.get()));
                }
                level.destroyBlock(pos, false);
            }
            level.playSound(null, pos, SoundEvents.BRUSH_GENERIC, SoundSource.BLOCKS, 1.0f, 1.0f);
            finishBrushing(player);
            event.setCanceled(true);
        } else if (block == ModBlocks.GUNPOWDER_PILE.get()) {
            if (!level.isClientSide()) {
                level.destroyBlock(pos, false);
                Block.popResource(level, pos, new ItemStack(ModItems.SULFUR.get(), 3));
            }
            level.playSound(null, pos, SoundEvents.BRUSH_SAND_COMPLETED, SoundSource.BLOCKS, 1.0f, 1.0f);
            finishBrushing(player);
            event.setCanceled(true);
        }
    }

    private static void finishBrushing(Player player) {
        if (!player.isCreative()) {
            player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        }
        player.getCooldowns().addCooldown(Items.BRUSH, BRUSH_COOLDOWN_TICKS);
    }
}
