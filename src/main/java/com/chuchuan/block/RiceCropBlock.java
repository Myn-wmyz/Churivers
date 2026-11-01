package com.chuchuan.block;

import com.chuchuan.registry.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

/**
 * 糯米作物：4 个生长阶段（设计文档 4 章——骨粉为四个阶段）。
 * 成熟掉落：必得糯米×1＋糯米种×1；50% 额外糯米×1；25% 额外糯米×2＋种×2（见战利品表）。
 * 实现上复用甜菜作物的 AGE_3 四阶段机制。
 */
public class RiceCropBlock extends BeetrootBlock {
    public RiceCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RICE_SEEDS.get();
    }
}
