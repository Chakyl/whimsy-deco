package io.github.chakyl.whimsydeco.blocks;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class BambooCandleBlock extends CandleBlock {
    private static final Int2ObjectMap<List<Vec3>> PARTICLE_OFFSETS = Util.make(() -> {
        Int2ObjectMap<List<Vec3>> int2objectmap = new Int2ObjectOpenHashMap<>();
        int2objectmap.defaultReturnValue(ImmutableList.of());
        int2objectmap.put(1, ImmutableList.of(new Vec3(0.5D, 0.4D, 0.5D)));
        int2objectmap.put(2, ImmutableList.of(new Vec3(0.35D, 0.4D, 0.65D), new Vec3(0.7D, 0.3D, 0.44D)));
        int2objectmap.put(3, ImmutableList.of(new Vec3(0.7D, 0.3D, 0.64D), new Vec3(0.35D, 0.4D, 0.65D), new Vec3(0.55D, 0.3D, 0.32D)));
        int2objectmap.put(4,ImmutableList.of(new Vec3(0.7D, 0.3D, 0.64D), new Vec3(0.35D, 0.4D, 0.65D), new Vec3(0.7D, 0.3D, 0.32D),  new Vec3(0.3D, 0.25D, 0.375D)));
        return Int2ObjectMaps.unmodifiable(int2objectmap);
    });
    private static final VoxelShape ONE_AABB = Block.box(4.5D, 0.0D, 4.5D, 11.5D, 6.0D, 11.5D);
    private static final VoxelShape MULTIPLE_AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D);

    public BambooCandleBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pPos, CollisionContext pContext) {
        if (pBlockState.getValue(CANDLES) == 1)  return ONE_AABB;
        return MULTIPLE_AABB;
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState pBlockState) {
        return PARTICLE_OFFSETS.get(pBlockState.getValue(CANDLES).intValue());
    }

}
