package net.hurb.tangerines.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hurb.tangerines.worldgen.tree.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class OrangewoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<OrangewoodFoliagePlacer> CODEC = RecordCodecBuilder.create(orangewoodFoliagePlacerInstance
            -> foliagePlacerParts(orangewoodFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(orangewoodFoliagePlacerInstance, OrangewoodFoliagePlacer::new));

    private final int height;

    public OrangewoodFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.ORANGEWOOD_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom,
                                 TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment,
                                 int pFoliageHeight, int pFoliageRadius, int pOffset) {


        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3).east((int) Math.ceil((pRandom.nextFloat() - .5f) * 1.5f)), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3).east((int) Math.ceil((pRandom.nextFloat() - .5f) * 1.5f)), 1, 0, pAttachment.doubleTrunk());

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).east((int) Math.ceil((pRandom.nextFloat() - .5f) * 1.5f)), 2, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(1).east((int) Math.ceil((pRandom.nextFloat() - .5f) * 1.5f)), 3, 0, pAttachment.doubleTrunk());

        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0).east((int) Math.ceil((pRandom.nextFloat() - .5f))), 4, 0, pAttachment.doubleTrunk(), .6f, .4f);



    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
