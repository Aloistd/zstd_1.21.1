package net.destizist.projectzstd.item;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectZstd.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ZSTD_ITEMS_TAB = CREATIVE_MODE_TABS.register("zstd_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CITROFITE_INGOT.get()))
                    .title(Component.translatable("creativetab.projectzstd.zstd_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.NETHERITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_NETHERITE_ORE.get());

                        output.accept(ModItems.NETHERITE_NUGGET.get());

                        output.accept(ModBlocks.CITROFITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());

                        output.accept(ModItems.RAW_CITROFITE.get());
                        output.accept(ModItems.PURE_CITROFITE.get());
                        output.accept(ModItems.CITROFITE_CHARGE.get());
                        output.accept(ModItems.CITROFITE_INGOT.get());

                        output.accept(ModItems.WITHERED_BONE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ZSTD_EQUIPMENT_TAB = CREATIVE_MODE_TABS.register("zstd_equipment_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CITROFITE_INGOT.get()))
                    .withTabsBefore(ZSTD_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.projectzstd.zstd_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.CITROFITE_SWORD.get());
                        output.accept(ModItems.CITROFITE_AXE.get());
                        output.accept(ModItems.CITROFITE_PICKAXE.get());
                        output.accept(ModItems.CITROFITE_SHOVEL.get());
                        output.accept(ModItems.CITROFITE_HOE.get());
                        output.accept(ModItems.CITROFITE_SCYTHE.get());

                        output.accept(ModItems.CITROFITE_HELMET.get());
                        output.accept(ModItems.CITROFITE_CHESTPLATE.get());
                        output.accept(ModItems.CITROFITE_LEGGINGS.get());
                        output.accept(ModItems.CITROFITE_BOOTS.get());

                        output.accept(ModItems.WOODEN_SCYTHE.get());
                        output.accept(ModItems.STONE_SCYTHE.get());
                        output.accept(ModItems.IRON_SCYTHE.get());
                        output.accept(ModItems.GOLDEN_SCYTHE.get());
                        output.accept(ModItems.DIAMOND_SCYTHE.get());
                        output.accept(ModItems.NETHERITE_SCYTHE.get());

                        output.accept(ModItems.WITHERED_STEEL_HELMET.get());
                        output.accept(ModItems.WITHERED_STEEL_CHESTPLATE.get());
                        output.accept(ModItems.WITHERED_STEEL_LEGGINGS.get());
                        output.accept(ModItems.WITHERED_STEEL_BOOTS.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}