package io.github.chakyl.whimsydeco.blocks;


import io.github.chakyl.whimsydeco.blocks.bases.RotatingTallBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BigPandaBlock extends RotatingTallBlock  {
    public static final VoxelShape SHAPE_UPPER = box(1, 0, 3, 15, 13, 16);
    public static final VoxelShape SHAPE_LOWER = box(1, 0, 3, 15, 16, 16);

    public BigPandaBlock(Properties pProperties) {
        super(pProperties, RotatingTallBlock.createShapeBuilder(SHAPE_UPPER, SHAPE_LOWER));
    }

}