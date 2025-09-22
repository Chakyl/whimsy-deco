package io.github.chakyl.whimsydeco.datagen;

import io.github.chakyl.whimsydeco.WhimsyDeco;
import io.github.chakyl.whimsydeco.blocks.FroggyChairBlock;
import io.github.chakyl.whimsydeco.blocks.ToyPlaneBlock;
import io.github.chakyl.whimsydeco.registry.WhimsyRegistry;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WhimsyDeco.MODID, exFileHelper);
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(WhimsyDeco.MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        customDirectionalTallBlock(WhimsyRegistry.BlockRegistry.FROGGY_CHAIR.get(),
//                $ -> existingModel(WhimsyRegistry.BlockRegistry.FROGGY_CHAIR.get()), FroggyChairBlock.WATERLOGGED);
//        customDirectionalTallBlock(WhimsyRegistry.BlockRegistry.YELLOW_FROGGY_CHAIR.get(),
//                $ -> existingModel(WhimsyRegistry.BlockRegistry.YELLOW_FROGGY_CHAIR.get()), FroggyChairBlock.WATERLOGGED);
//        customDirectionalTallBlock(WhimsyRegistry.BlockRegistry.PINK_FROGGY_CHAIR.get(),
//                $ -> existingModel(WhimsyRegistry.BlockRegistry.PINK_FROGGY_CHAIR.get()), FroggyChairBlock.WATERLOGGED);
//        customDirectionalTallBlock(WhimsyRegistry.BlockRegistry.ORANGE_FROGGY_CHAIR.get(),
//                $ -> existingModel(WhimsyRegistry.BlockRegistry.ORANGE_FROGGY_CHAIR.get()), FroggyChairBlock.WATERLOGGED);
//        customDirectionalTallBlock(WhimsyRegistry.BlockRegistry.BLUE_FROGGY_CHAIR.get(),
//                $ -> existingModel(WhimsyRegistry.BlockRegistry.BLUE_FROGGY_CHAIR.get()), FroggyChairBlock.WATERLOGGED);

//        toyPlaneStates(WhimsyRegistry.BlockRegistry.RED_TOY_PLANE.get(),  "red");
//        toyPlaneStates(WhimsyRegistry.BlockRegistry.BLUE_TOY_PLANE.get(),  "blue");
//        toyPlaneStates(WhimsyRegistry.BlockRegistry.YELLOW_TOY_PLANE.get(), "yellow");
    }

    public void simpleHorizontalState(Block block, String color) {
        getVariantBuilder(block).forAllStates(state -> {
            String chair = color != null ? color + "_froggy_chair" : "froggy_chair";
            return ConfiguredModel.builder()
                    .modelFile(existingModel(chair))
                    .build();
        });
    }
    public void customDirectionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationY(dir.getAxis().isVertical() ? 0 : ((int) dir.toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                }, ignored);
    }
    public void customDirectionalTallBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationY(dir.getAxis().isVertical() ? 0 : ((int) dir.toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                }, ignored);
    }
    public void toyPlaneStates(Block block, String color) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean flying = state.getValue(ToyPlaneBlock.FLYING);
            String plane = color + "_toy_plane" + (flying ? "_fly" : "");
            return ConfiguredModel.builder()
                    .modelFile(existingModel(plane))
                    .build();
        });
    }

}
