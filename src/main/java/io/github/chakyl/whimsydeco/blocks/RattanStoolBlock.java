package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.ChairBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RattanStoolBlock extends ChairBlock {

    public static final VoxelShape SHAPE = box(2, 0, 2, 14, 12, 14);

    public RattanStoolBlock(Properties pProperties) {
        super(SHAPE, 0.8D, pProperties);
    }
}
