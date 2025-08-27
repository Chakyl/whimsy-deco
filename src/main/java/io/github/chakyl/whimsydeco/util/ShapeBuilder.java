package io.github.chakyl.whimsydeco.util;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

@FunctionalInterface
public interface ShapeBuilder extends Function<BlockState, VoxelShape> {}