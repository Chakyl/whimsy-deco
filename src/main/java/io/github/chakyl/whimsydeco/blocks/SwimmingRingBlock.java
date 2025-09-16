package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SwimmingRingBlock extends RotatingBlock {

    public static final VoxelShape SHAPE = box(2, 0, 2, 14, 4, 14);

    public SwimmingRingBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }


}