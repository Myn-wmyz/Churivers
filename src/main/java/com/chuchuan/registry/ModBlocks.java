package com.chuchuan.registry;

import com.chuchuan.block.RiceCropBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.chuchuan.ChuchuanMod.MOD_ID;

/**
 * 阶段 1 方块注册：可刷璞、火药堆、植物与糯米作物。
 */
public final class ModBlocks {
    private ModBlocks() {}

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    /** 璞：对其使用刷子，5% 获得玉（设计文档 4 章） */
    public static final DeferredBlock<Block> PU = BLOCKS.registerSimpleBlock("pu",
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE));

    /** 火药堆：对其使用刷子，获得硫磺×3（设计文档 6.5 章） */
    public static final DeferredBlock<Block> GUNPOWDER_PILE = BLOCKS.registerSimpleBlock("gunpowder_pile",
            BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).sound(SoundType.SAND));

    // ---------- 植物（设计文档 4 章；破坏掉落的产物见 data/chuchuan/loot_table） ----------
    public static final DeferredBlock<FlowerBlock> ORCHID = BLOCKS.registerBlock("orchid",
            props -> new FlowerBlock(MobEffects.SATURATION, 6.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> PEPPER_BUSH = BLOCKS.registerBlock("pepper_bush",
            props -> new FlowerBlock(MobEffects.CONFUSION, 8.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> ANGELICA = BLOCKS.registerBlock("angelica",
            props -> new FlowerBlock(MobEffects.REGENERATION, 4.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> XINYI = BLOCKS.registerBlock("xinyi",
            props -> new FlowerBlock(MobEffects.HEAL, 1.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> MULIAN = BLOCKS.registerBlock("mulian",
            props -> new FlowerBlock(MobEffects.DAMAGE_BOOST, 6.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> DURUO = BLOCKS.registerBlock("duruo",
            props -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 6.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> MIWU = BLOCKS.registerBlock("miwu",
            props -> new FlowerBlock(MobEffects.NIGHT_VISION, 6.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> DI = BLOCKS.registerBlock("di",
            props -> new FlowerBlock(MobEffects.JUMP, 6.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));
    public static final DeferredBlock<FlowerBlock> HUICAO = BLOCKS.registerBlock("huicao",
            props -> new FlowerBlock(MobEffects.WATER_BREATHING, 6.0f, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));

    /** 糯米作物：7 游戏日成熟，骨粉可催熟（4 个阶段），掉落见战利品表 */
    public static final DeferredBlock<RiceCropBlock> RICE_CROP = BLOCKS.registerBlock("rice_crop",
            RiceCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
}
