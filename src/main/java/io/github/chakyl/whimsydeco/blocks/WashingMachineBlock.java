package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WashingMachineBlock extends RotatingBlock {

    public static final VoxelShape SHAPE =  box(0, 0, 0, 16, 16, 16);

    public WashingMachineBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }

}