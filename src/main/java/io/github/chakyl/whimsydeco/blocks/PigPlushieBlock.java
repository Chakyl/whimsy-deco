package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.RotatingBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PigPlushieBlock extends RotatingBlock {

    public static final VoxelShape SHAPE =  box(3, 0, 3, 12, 10, 14);

    public PigPlushieBlock(Properties props) {
        super(props, RotatingBlock.createShapeBuilder(SHAPE));
    }

}