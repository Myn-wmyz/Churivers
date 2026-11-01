package com.chuchuan;

import com.chuchuan.registry.ModBlocks;
import com.chuchuan.registry.ModCreativeTabs;
import com.chuchuan.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 楚川 —— 楚文化主题内容 Mod。
 * 阶段 1：基础材料层（玉石体系、植物、食物、粉末、乐器）。
 */
@Mod(ChuchuanMod.MOD_ID)
public final class ChuchuanMod {
    public static final String MOD_ID = "chuchuan";
    public static final Logger LOGGER = LoggerFactory.getLogger("楚川/Chuchuan");

    public ChuchuanMod(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);
        LOGGER.info("楚川：阶段1 基础材料层已加载");
    }
}
