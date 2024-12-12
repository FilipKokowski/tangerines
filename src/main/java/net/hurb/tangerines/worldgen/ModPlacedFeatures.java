package net.hurb.tangerines.worldgen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ORANGEWOOD_PLANK_PLACED_KEY = registerKey("orangewood_plank_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ORANGEWOOD_PLANK_PLACED_KEY = registerKey("nether_orangewood_plank_placed");
    public static final ResourceKey<PlacedFeature> END_ORANGEWOOD_PLANK_PLACED_KEY = registerKey("end_orangewood_plank_placed");

    public static final ResourceKey<PlacedFeature> ORANGEWOOD_PLACED_KEY = registerKey("orangewood_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ORANGEWOOD_PLANK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ORANGEWOOD_PLANK_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NETHER_ORANGEWOOD_PLANK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ORANGEWOOD_PLANK_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, END_ORANGEWOOD_PLANK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ORANGEWOOD_PLANK_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, ORANGEWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGEWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.25f, 2),
                        ModBlocks.ORANGEWOOD_SAPLING.get()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name){
        return  ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(McMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuredFeatureHolder, List.copyOf(modifiers)));
    }
}
