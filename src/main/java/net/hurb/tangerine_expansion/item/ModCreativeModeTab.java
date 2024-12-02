package net.hurb.tangerine_expansion.item;

import net.hurb.tangerine_expansion.McMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, McMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HURB = CREATIVE_MODE_TABS.register("tangerine_expansion_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TANGERINE.get()))
                    .title(Component.translatable("Tangerine Expansion"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TANGERINE.get());
                        pOutput.accept(ModItems.PEELED_TANGERINE.get());
                        pOutput.accept(ModItems.TANGERINE_PEEL.get());
                        pOutput.accept(ModItems.TANGERINE_PEEL_FABRIC.get());
                        pOutput.accept(ModItems.TANGERINE_CAP.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
