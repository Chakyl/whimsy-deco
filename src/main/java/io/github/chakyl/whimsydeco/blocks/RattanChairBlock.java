package io.github.chakyl.whimsydeco.blocks;


import io.github.chakyl.whimsydeco.blocks.bases.TallChairBlock;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RattanChairBlock extends TallChairBlock {
    public static final VoxelShape UPPER_SHAPE = Shapes.join(
            box(0, 4, 10, 16, 6, 12),
            box(0.9, -0.1, 9.9, 15.1, 4.1, 12.1),
            BooleanOp.ONLY_FIRST
    );
    public static final VoxelShape LOWER_SHAPE = Shapes.or(
      box(2, 0, 3, 14, 2, 15),
      box(7, 2, 13, 9, 16, 15),
      box(13, 5, 10, 15, 16, 12),
      box(1, 5, 10, 3, 16, 12),
      box(1, 5, 0, 3, 7, 10),
      box(13, 5, 0, 15, 7, 10),
      box(3, 5, 0, 13, 7, 2),
      box(3, 4, 2, 13, 6, 13),
      box(3, 6, 11, 13, 16, 13));

    public RattanChairBlock(Properties pProperties) {
        super(UPPER_SHAPE, LOWER_SHAPE, 8.0D / 16.0D, pProperties);
    }

}