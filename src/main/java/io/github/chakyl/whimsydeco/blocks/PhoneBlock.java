package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.WallFloorBlock;
import io.github.chakyl.whimsydeco.util.ShapeBuilder;
import io.github.chakyl.whimsydeco.util.ShapeUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PhoneBlock extends WallFloorBlock {
    public static final VoxelShape SHAPE = Shapes.or(
            box(2, 0, 3, 14, 3, 16),
            box(11, 3, 3, 14, 5, 16));
    public static final VoxelShape SHAPE_WALL = Shapes.or(
            box(2, 3, 13, 14, 16, 16),
            box(11, 3, 11, 14, 16, 13));

    public PhoneBlock(Properties props) {
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