package net.hurb.tangerines.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hurb.tangerines.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class OrangewoodTrunkPlacer extends TrunkPlacer {

    public static final Codec<OrangewoodTrunkPlacer> CODEC = RecordCodecBuilder.create(orangewoodTrunkPlacerInstance ->
            trunkPlacerParts(orangewoodTrunkPlacerInstance).apply(orangewoodTrunkPlacerInstance, OrangewoodTrunkPlacer::new));

    public OrangewoodTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.ORANGEWOOD_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter,
                                                            RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int height = pRandom.nextInt(2) + 5;

        for(int i = 0; i < height; i++){
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            if(i == height - 2){
                int yOffset = 0;
                int xOffset = 0;
                int branchRecession = 0;

                for(int branchLength = 0; branchLength < pRandom.nextInt(4, 6); branchLength++){
                    if(pRandom.nextFloat() > 0.4f)
                        if(yOffset <= 4)
                            yOffset++;
                        else
                            if(xOffset > 0)
                                xOffset++;
                            else
                                xOffset--;


                    if(pRandom.nextFloat() * xOffset * (3 * branchLength) > 2.5f)
                        branchRecession--;

                    if(branchRecession + branchLength > 4) {
                        branchRecession--;

                        if (pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;
                    }
                    else if(pRandom.nextFloat() * branchLength > .8f)
                        if(pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;


                    pBlockSetter.accept(pPos.above(i + yOffset).relative(Direction.NORTH, branchLength + branchRecession + 1)
                            .relative(Direction.EAST, xOffset), (BlockState) Function.identity()
                            .apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                }

                yOffset = 0;
                xOffset = 0;
                for(int branchLength = 0; branchLength < pRandom.nextInt(2, 6); branchLength++){
                    if(pRandom.nextFloat() > 0.4f)
                        if(yOffset <= 4)
                            yOffset++;
                        else
                            if(xOffset > 0)
                                xOffset++;
                            else
                                xOffset--;

                    if(pRandom.nextFloat() * branchLength > .8f)
                        if(pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;

                    if(pRandom.nextFloat() * xOffset * (3 * branchLength) > 2.5f)
                        branchRecession--;

                    if(branchRecession + branchLength > 4) {
                        branchRecession--;

                        if (pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;
                    }

                    BlockPos pos = pPos.above(i + yOffset).relative(Direction.SOUTH, branchLength + branchRecession + 1)
                            .relative(Direction.EAST, xOffset);

                    pBlockSetter.accept(pPos.above(i + yOffset).relative(Direction.SOUTH, branchLength + branchRecession + 1)
                            .relative(Direction.EAST, xOffset), (BlockState) Function.identity()
                            .apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));


                }

                yOffset = 0;
                xOffset = 0;
                for(int branchLength = 0; branchLength < pRandom.nextInt(2, 6); branchLength++){
                    if(pRandom.nextFloat() > 0.4f)
                        if(yOffset <= 4)
                            yOffset++;
                        else
                            if(xOffset > 0)
                                xOffset++;
                            else
                                xOffset--;

                    if(pRandom.nextFloat() * branchLength > .8f)
                        if(pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;

                    if(pRandom.nextFloat() * xOffset * (3 * branchLength) > 2.5f)
                        branchRecession--;

                    if(branchRecession + branchLength > 4) {
                        branchRecession--;

                        if (pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;
                    }

                    pBlockSetter.accept(pPos.above(i + yOffset).relative(Direction.EAST, branchLength + branchRecession + 1)
                            .relative(Direction.NORTH, xOffset), (BlockState) Function.identity()
                            .apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));

                }

                yOffset = 0;
                xOffset = 0;
                for(int branchLength = 0; branchLength < pRandom.nextInt(2, 6); branchLength++){
                    if(pRandom.nextFloat() > 0.4f)
                        if(yOffset <= 4)
                            yOffset++;
                        else
                            if(xOffset > 0)
                                xOffset++;
                            else
                                xOffset--;

                    if(pRandom.nextFloat() * branchLength > .8f)
                        if(pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;

                    if(pRandom.nextFloat() * xOffset * (3 * branchLength) > 2.5f)
                        branchRecession--;

                    if(branchRecession + branchLength > 4) {
                        branchRecession--;

                        if (pRandom.nextBoolean())
                            xOffset++;
                        else
                            xOffset--;
                    }

                    pBlockSetter.accept(pPos.above(i + yOffset).relative(Direction.WEST, branchLength + branchRecession + 1)
                            .relative(Direction.NORTH, xOffset), (BlockState) Function.identity()
                            .apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));

                }



            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}
