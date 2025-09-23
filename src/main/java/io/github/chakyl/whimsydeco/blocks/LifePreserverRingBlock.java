package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.WallFloorBlock;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import io.github.chakyl.whimsydeco.util.ShapeUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LifePreserverRingBlock extends WallFloorBlock {
    public static final VoxelShape SHAPE = box(2, 0, 2, 14, 4, 14);
    public static final VoxelShape SHAPE_WALL = box(2, 2, 12, 14, 14, 16);

    public LifePreserverRingBlock(Properties props) {
        super(props, createShapeBuilder());
    }

    public static ShapeBuilder createShapeBuilder() {
        return blockState -> {
            final Boolean flying = blockState.getValue(WALL);
            final Direction facing = blockState.getValue(FACING);
            return flying ? ShapeUtils.rotateShape(Direction.NORTH, facing, SHAPE_WALL) : ShapeUtils.rotateShape(Direction.NORTH, facing, SHAPE);
        };
    }
}