package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LedgeBlock extends RotatingBlock {

    public static final VoxelShape SHAPE = Shapes.or(
            box(0, 14, 0, 16, 16, 16),
            box(0, 4, 15, 16, 16, 16));

    public LedgeBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }


}