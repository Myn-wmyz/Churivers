package com.chuchuan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.chuchuan.ChuchuanMod.MOD_ID;

/**
 * "楚川" 创造模式物品栏。
 */
public final class ModCreativeTabs {
    private ModCreativeTabs() {}

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHUCHUAN_TAB =
            CREATIVE_TABS.register("chuchuan_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.chuchuan"))
                    .icon(() -> ModItems.JADE.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        // 玉石体系
                        output.accept(ModItems.JADE.get());
                        output.accept(ModItems.XIA.get());
                        output.accept(ModItems.JUE.get());
                        output.accept(ModItems.CUI_JADE.get());
                        output.accept(ModItems.LIANG_JADE.get());
                        output.accept(ModItems.ER.get());
                        output.accept(ModItems.MING_JADE.get());
                        output.accept(ModItems.XIAN_JADE.get());
                        output.accept(ModItems.YUYU_ALLOY_INGOT.get());
                        output.accept(ModBlocks.PU.get());
                        // 植物与产物
                        output.accept(ModBlocks.ORCHID.get());
                        output.accept(ModItems.LAN_LEAF.get());
                        output.accept(ModItems.GUI_FLOWER.get());
                        output.accept(ModItems.GUI_LEAF.get());
                        output.accept(ModItems.GUI_SAPLING.get());
                        output.accept(ModBlocks.PEPPER_BUSH.get());
                        output.accept(ModItems.PEPPER.get());
                        output.accept(ModItems.JIAO_NI.get());
                        output.accept(ModBlocks.ANGELICA.get());
                        output.accept(ModItems.BAMBOO_LEAF.get());
                        output.accept(ModBlocks.XINYI.get());
                        output.accept(ModBlocks.MULIAN.get());
                        output.accept(ModBlocks.DURUO.get());
                        output.accept(ModBlocks.MIWU.get());
                        output.accept(ModBlocks.DI.get());
                        output.accept(ModBlocks.HUICAO.get());
                        output.accept(ModItems.RICE_SEEDS.get());
                        output.accept(ModItems.GLUTINOUS_RICE.get());
                        // 酿造原料
                        output.accept(ModItems.QU.get());
                        output.accept(ModItems.HUA_QU.get());
                        output.accept(ModItems.GUI_QU.get());
                        // 粽子
                        output.accept(ModItems.ZONGZI_RAW_RICE.get());
                        output.accept(ModItems.ZONGZI_COOKED_RICE.get());
                        output.accept(ModItems.ZONGZI_RAW_MEAT.get());
                        output.accept(ModItems.ZONGZI_COOKED_MEAT.get());
                        // 粉末
                        output.accept(ModBlocks.GUNPOWDER_PILE.get());
                        output.accept(ModItems.DRIPSTONE_POWDER.get());
                        output.accept(ModItems.SULFUR.get());
                        output.accept(ModItems.HANSHISAN.get());
                        // 配饰与乐器
                        output.accept(ModItems.PEIYU.get());
                        output.accept(ModItems.DONGXIAO.get());
                    })
                    .build());
}
