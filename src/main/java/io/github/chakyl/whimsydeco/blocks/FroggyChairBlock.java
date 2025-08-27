package io.github.chakyl.whimsydeco.blocks;

import io.github.chakyl.whimsydeco.blocks.bases.TallChairBlock;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FroggyChairBlock extends TallChairBlock {

//            box(0, 10, 13, 16, 24, 15),
//            box(1, 0, 1, 15, 10, 15));
    public static final VoxelShape UPPER_SHAPE = Shapes.join(
            box(2, 0, 12, 14, 8, 14),
            box(4, 7, 12, 12, 8, 14),
            BooleanOp.ONLY_FIRST
    );
    public static final VoxelShape LOWER_SHAPE = Shapes.or(
            box(3, 0, 3, 5, 8, 5),
            box(11, 0, 3, 13, 8, 5),
            box(3, 0, 11, 5, 8, 13),
            box(11, 0, 11, 13, 8, 13),
            box(2, 8, 2, 14, 10, 14),
            box(2, 10, 12, 14, 16, 14));

    public FroggyChairBlock(Properties pProperties) {
        super(UPPER_SHAPE, LOWER_SHAPE, 12.0D / 16.0D, pProperties);
    }
}