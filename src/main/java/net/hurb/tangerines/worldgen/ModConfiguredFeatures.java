package net.hurb.tangerines.worldgen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.hurb.tangerines.worldgen.tree.custom.OrangewoodFoliagePlacer;
import net.hurb.tangerines.worldgen.tree.custom.OrangewoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ORANGEWOOD_PLANK_KEY = registerKey("overworld_orangewood_planks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ORANGEWOOD_PLANK_KEY = registerKey("nether_orangewood_planks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ORANGEWOOD_PLANK_KEY = registerKey("end_orangewood_planks");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGEWOOD_KEY = registerKey("orangewood");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldOrangewoodPlanks = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.ORANGEWOOD_PLANKS.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ORANGEWOOD_PLANKS.get().defaultBlockState()));

        register(context, OVERWORLD_ORANGEWOOD_PLANK_KEY, Feature.ORE, new OreConfiguration(overworldOrangewoodPlanks, 9));
        register(context, NETHER_ORANGEWOOD_PLANK_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.ORANGEWOOD_PLANKS.get().defaultBlockState(), 9));
        register(context, END_ORANGEWOOD_PLANK_KEY, Feature.ORE, new OreConfiguration(endstoneReplaceables, ModBlocks.ORANGEWOOD_PLANKS.get().defaultBlockState(), 9));

        register(context, ORANGEWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ORANGEWOOD_LOG.get()),
                new OrangewoodTrunkPlacer(5, 4, 3),

                BlockStateProvider.simple(ModBlocks.ORANGEWOOD_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(4), ConstantInt.of(2),2),

                new TwoLayersFeatureSize(1,0,2)).build());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(McMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
