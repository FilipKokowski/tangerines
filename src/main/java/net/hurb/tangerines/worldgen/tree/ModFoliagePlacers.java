package net.hurb.tangerines.worldgen.tree;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.worldgen.tree.custom.OrangewoodFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, McMod.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<OrangewoodFoliagePlacer>> ORANGEWOOD_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("orangewood_foliage_placer", () -> new FoliagePlacerType<>(OrangewoodFoliagePlacer.CODEC));

    public static void register(IEventBus event){
        FOLIAGE_PLACERS.register(event);
    }

}
