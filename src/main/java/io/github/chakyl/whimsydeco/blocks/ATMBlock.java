package io.github.chakyl.whimsydeco.blocks;


import io.github.chakyl.whimsydeco.blocks.bases.RotatingTallBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ATMBlock extends RotatingTallBlock {
    public static final VoxelShape SHAPE_UPPER = box(0, 0, 0, 16, 14, 16);
    public static final VoxelShape SHAPE_LOWER = box(0, 0, 0, 16, 16, 16);

    public ATMBlock(Properties pProperties) {
        super(pProperties, RotatingTallBlock.createShapeBuilder(SHAPE_UPPER, SHAPE_LOWER));
    }

}