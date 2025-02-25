package net.destizist.projectzstd.item;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.item.custom.ScytheItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.*;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectZstd.MOD_ID);


    public static final RegistryObject<Item> WOODEN_SCYTHE = ITEMS.register("wooden_scythe",
            () -> new ScytheItem(Tiers.WOOD, 1, -2.4F, 3.0, 1.0F, new Item.Properties()));
    public static final RegistryObject<Item> STONE_SCYTHE = ITEMS.register("stone_scythe",
            () -> new ScytheItem(Tiers.STONE, 1, -2.4F, 3.0, 1.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new ScytheItem(Tiers.IRON, 1, -2.4F, 3.0, 1.0F, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_SCYTHE = ITEMS.register("golden_scythe",
            () -> new ScytheItem(Tiers.GOLD, 1, -2.4F, 3.0, 1.0F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            () -> new ScytheItem(Tiers.DIAMOND, 1, -2.4F, 3.0, 1.0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            () -> new ScytheItem(Tiers.NETHERITE, 1, -2.4F, 3.0, 1.0F, new Item.Properties()));
    public static final RegistryObject<Item> CITROFITE_SCYTHE = ITEMS.register("citrofite_scythe",
            () -> new ScytheItem(ModToolTiers.CITROFITE, 0, -2.4F, 3.0, 0.0F, new Item.Properties()));

public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_CITROFITE= ITEMS.register("raw_citrofite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURE_CITROFITE= ITEMS.register("pure_citrofite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CITROFITE_CHARGE= ITEMS.register("citrofite_charge",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CITROFITE_INGOT= ITEMS.register("citrofite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WITHERED_BONE= ITEMS.register("withered_bone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WITHERED_STEEL_INGOT= ITEMS.register("withered_steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CITROFITE_SWORD = ITEMS.register("citrofite_sword",
            () -> new SwordItem(ModToolTiers.CITROFITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CITROFITE, 4, -2.4f))));
    public static final RegistryObject<Item> CITROFITE_PICKAXE = ITEMS.register("citrofite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CITROFITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CITROFITE, 1, -2.8f))));
    public static final RegistryObject<Item> CITROFITE_SHOVEL = ITEMS.register("citrofite_shovel",
            () -> new ShovelItem(ModToolTiers.CITROFITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CITROFITE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> CITROFITE_AXE = ITEMS.register("citrofite_axe",
            () -> new AxeItem(ModToolTiers.CITROFITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CITROFITE, 7, -3.2f))));
    public static final RegistryObject<Item> CITROFITE_HOE = ITEMS.register("citrofite_hoe",
            () -> new HoeItem(ModToolTiers.CITROFITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CITROFITE, 0, -3.0f))));

    public static final RegistryObject<Item> CITROFITE_HELMET = ITEMS.register("citrofite_helmet",
            () -> new ArmorItem(ModArmorMaterials.CITROFITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(529).stacksTo(1)));
    public static final RegistryObject<Item> CITROFITE_CHESTPLATE = ITEMS.register("citrofite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CITROFITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(769).stacksTo(1)));
    public static final RegistryObject<Item> CITROFITE_LEGGINGS = ITEMS.register("citrofite_leggings",
            () -> new ArmorItem(ModArmorMaterials.CITROFITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(721).stacksTo(1)));
    public static final RegistryObject<Item> CITROFITE_BOOTS = ITEMS.register("citrofite_boots",
            () -> new ArmorItem(ModArmorMaterials.CITROFITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(625).stacksTo(1)));

    public static final RegistryObject<Item> WITHERED_STEEL_HELMET = ITEMS.register("withered_steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.WITHERED_STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(165).stacksTo(1)));
    public static final RegistryObject<Item> WITHERED_STEEL_CHESTPLATE = ITEMS.register("withered_steel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.WITHERED_STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(240).stacksTo(1)));
    public static final RegistryObject<Item> WITHERED_STEEL_LEGGINGS = ITEMS.register("withered_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.WITHERED_STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(225).stacksTo(1)));
    public static final RegistryObject<Item> WITHERED_STEEL_BOOTS = ITEMS.register("withered_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.WITHERED_STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(195).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}