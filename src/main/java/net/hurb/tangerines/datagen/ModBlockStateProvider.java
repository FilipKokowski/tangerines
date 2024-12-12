package net.hurb.tangerines.datagen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, McMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ORANGEWOOD_LOG);
        blockWithItem(ModBlocks.ORANGEWOOD_LEAVES);
        blockWithItem(ModBlocks.ORANGEWOOD_PLANKS);
        blockWithItem(ModBlocks.ORANGEWOOD_WOOD);
        blockWithItem(ModBlocks.STRIPPED_ORANGEWOOD_LOG);
        blockWithItem(ModBlocks.STRIPPED_ORANGEWOOD_WOOD);
     }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
