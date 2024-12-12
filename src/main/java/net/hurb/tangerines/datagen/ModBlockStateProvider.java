package net.hurb.tangerines.datagen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, McMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock((RotatedPillarBlock) ModBlocks.ORANGEWOOD_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.ORANGEWOOD_WOOD.get()), blockTexture(ModBlocks.ORANGEWOOD_LOG.get()),
                blockTexture(ModBlocks.ORANGEWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ORANGEWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get()),
                new ResourceLocation(McMod.MOD_ID, "block/stripped_orangewood_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ORANGEWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get()));

        blockItem(ModBlocks.ORANGEWOOD_LOG);
        blockItem(ModBlocks.ORANGEWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_ORANGEWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_ORANGEWOOD_WOOD);

        blockWithItem(ModBlocks.ORANGEWOOD_PLANKS);

        leavesBlock(ModBlocks.ORANGEWOOD_LEAVES);
        saplingBlock(ModBlocks.ORANGEWOOD_SAPLING);

    }

    private void saplingBlock(RegistryObject<Block> block) {
        simpleBlock(block.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                        blockTexture(block.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(McMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
