package com.chuchuan.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.chuchuan.ChuchuanMod.MOD_ID;

/**
 * 阶段 1 物品注册。
 * 数值来源：《楚川Mod设计文档》v0.3 第四、六章。
 */
public final class ModItems {
    private ModItems() {}

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    // ---------- 玉石体系（设计文档 4 章） ----------
    public static final DeferredItem<Item> JADE = ITEMS.registerSimpleItem("jade");
    public static final DeferredItem<Item> XIA = ITEMS.registerSimpleItem("xia");
    public static final DeferredItem<Item> JUE = ITEMS.registerSimpleItem("jue");
    public static final DeferredItem<Item> CUI_JADE = ITEMS.registerSimpleItem("cui_jade");
    public static final DeferredItem<Item> LIANG_JADE = ITEMS.registerSimpleItem("liang_jade");
    public static final DeferredItem<Item> ER = ITEMS.registerSimpleItem("er");
    /** 命玉：使用后最命 +5（死亡后重置）——使用逻辑在声望/数据阶段实现 */
    public static final DeferredItem<Item> MING_JADE = ITEMS.registerSimpleItem("ming_jade");
    /** 弦玉：使用后甲 +1（死亡后保留）——使用逻辑在声望/数据阶段实现 */
    public static final DeferredItem<Item> XIAN_JADE = ITEMS.registerSimpleItem("xian_jade");
    public static final DeferredItem<Item> YUYU_ALLOY_INGOT = ITEMS.registerSimpleItem("yuyu_alloy_ingot");

    // ---------- 方块物品（DeferredRegister.Blocks 不自动注册 BlockItem，必须手动补） ----------
    public static final DeferredItem<BlockItem> PU_ITEM = ITEMS.registerSimpleBlockItem("pu", ModBlocks.PU, new Item.Properties());
    public static final DeferredItem<BlockItem> GUNPOWDER_PILE_ITEM = ITEMS.registerSimpleBlockItem("gunpowder_pile", ModBlocks.GUNPOWDER_PILE, new Item.Properties());
    public static final DeferredItem<BlockItem> ORCHID_ITEM = ITEMS.registerSimpleBlockItem("orchid", ModBlocks.ORCHID, new Item.Properties());
    public static final DeferredItem<BlockItem> PEPPER_BUSH_ITEM = ITEMS.registerSimpleBlockItem("pepper_bush", ModBlocks.PEPPER_BUSH, new Item.Properties());
    /** 白芷：可直接食用的芳香植物（饱食1、饱和1；设计文档 4 章） */
    public static final DeferredItem<BlockItem> ANGELICA_ITEM = ITEMS.registerSimpleBlockItem("angelica", ModBlocks.ANGELICA,
            new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.5f) // 饱食1 饱和1
                    .build()));
    public static final DeferredItem<BlockItem> XINYI_ITEM = ITEMS.registerSimpleBlockItem("xinyi", ModBlocks.XINYI, new Item.Properties());
    public static final DeferredItem<BlockItem> MULIAN_ITEM = ITEMS.registerSimpleBlockItem("mulian", ModBlocks.MULIAN, new Item.Properties());
    public static final DeferredItem<BlockItem> DURUO_ITEM = ITEMS.registerSimpleBlockItem("duruo", ModBlocks.DURUO, new Item.Properties());
    public static final DeferredItem<BlockItem> MIWU_ITEM = ITEMS.registerSimpleBlockItem("miwu", ModBlocks.MIWU, new Item.Properties());
    public static final DeferredItem<BlockItem> DI_ITEM = ITEMS.registerSimpleBlockItem("di", ModBlocks.DI, new Item.Properties());
    public static final DeferredItem<BlockItem> HUICAO_ITEM = ITEMS.registerSimpleBlockItem("huicao", ModBlocks.HUICAO, new Item.Properties());

    // ---------- 植物产物 ----------
    public static final DeferredItem<Item> LAN_LEAF = ITEMS.registerSimpleItem("lan_leaf");
    public static final DeferredItem<Item> GUI_FLOWER = ITEMS.registerSimpleItem("gui_flower");
    public static final DeferredItem<Item> GUI_LEAF = ITEMS.registerSimpleItem("gui_leaf");
    public static final DeferredItem<Item> BAMBOO_LEAF = ITEMS.registerSimpleItem("bamboo_leaf");
    public static final DeferredItem<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(5.0f) // 饱食1 饱和10
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1000, 0), 1.0f) // 反胃 50s
                    .build())));
    public static final DeferredItem<Item> JIAO_NI = ITEMS.registerSimpleItem("jiao_ni");
    public static final DeferredItem<Item> GLUTINOUS_RICE = ITEMS.registerSimpleItem("glutinous_rice");
    public static final DeferredItem<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            () -> new BlockItem(ModBlocks.RICE_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> GUI_SAPLING = ITEMS.registerSimpleItem("gui_sapling");

    // ---------- 酿造原料（饮品本体在阶段2 酿造系统实现） ----------
    public static final DeferredItem<Item> QU = ITEMS.registerSimpleItem("qu");
    public static final DeferredItem<Item> HUA_QU = ITEMS.registerSimpleItem("hua_qu");
    public static final DeferredItem<Item> GUI_QU = ITEMS.registerSimpleItem("gui_qu");

    // ---------- 粽子（设计文档 6.3 章） ----------
    public static final DeferredItem<Item> ZONGZI_RAW_RICE = ITEMS.register("zongzi_raw_rice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.25f).build()))); // 饱食4 饱和2
    public static final DeferredItem<Item> ZONGZI_COOKED_RICE = ITEMS.register("zongzi_cooked_rice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8).saturationModifier(0.25f).build()))); // 饱食8 饱和4
    public static final DeferredItem<Item> ZONGZI_RAW_MEAT = ITEMS.register("zongzi_raw_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5).saturationModifier(0.2f).build()))); // 饱食5 饱和2
    public static final DeferredItem<Item> ZONGZI_COOKED_MEAT = ITEMS.register("zongzi_cooked_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(12).saturationModifier(0.4167f).build()))); // 饱食12 饱和10

    // ---------- 可食用粉末（设计文档 6.5 章） ----------
    public static final DeferredItem<Item> DRIPSTONE_POWDER = ITEMS.register("dripstone_powder",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.1f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1.0f) // 缓慢Ⅰ 30s
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1), 1.0f) // 抗性Ⅱ 30s
                    .build())));
    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.1f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1), 1.0f) // 速度Ⅱ 15s
                    .build())));
    public static final DeferredItem<Item> HANSHISAN = ITEMS.register("hanshisan",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0f) // 速度Ⅱ 3min
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0f) // 急迫Ⅱ 3min
                    .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 3600, 0), 1.0f) // 饱和 3min
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0), 1.0f) // 抗性Ⅰ 3min
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 0), 1.0f) // 力量Ⅰ 3min
                    .effect(() -> new MobEffectInstance(MobEffects.WITHER, 6000, 2), 0.01f) // 1% 凋零Ⅲ 5min
                    .build())));

    // ---------- 配饰与乐器 ----------
    public static final DeferredItem<Item> PEIYU = ITEMS.registerSimpleItem("peiyu");
    public static final DeferredItem<Item> DONGXIAO = ITEMS.registerSimpleItem("dongxiao");
}
