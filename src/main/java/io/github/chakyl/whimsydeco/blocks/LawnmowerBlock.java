package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LawnmowerBlock extends RotatingBlock {

    public static final VoxelShape SHAPE = box(2, 0, 2, 14, 11, 14);

    public LawnmowerBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }


}