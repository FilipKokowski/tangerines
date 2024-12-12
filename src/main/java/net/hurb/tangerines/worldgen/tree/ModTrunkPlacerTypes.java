package net.hurb.tangerines.worldgen.tree;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.worldgen.tree.custom.OrangewoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, McMod.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<OrangewoodTrunkPlacer>> ORANGEWOOD_TRUNK_PLACER =
            TRUNK_PLACER.register("orangewood_trunk_placer", () -> new TrunkPlacerType<>(OrangewoodTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }

}
