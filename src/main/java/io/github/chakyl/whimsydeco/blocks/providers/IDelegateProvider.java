package io.github.chakyl.whimsydeco.blocks.providers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
/**
 * @author skyjay1
 * [https://github.com/skyjay1/Tanuki-Decor/blob/main-1.20.1/src/main/java/tanukidecor/block/storage/IDelegateProvider.java]
 * Used with permission under the GNU LGPLv3 license
 */
public interface IDelegateProvider {

    /**
     * @param blockState the block state
     * @param blockPos the block position
     * @return the block position to delegate to
     */
    BlockPos getDelegatePos(final BlockState blockState, final BlockPos blockPos);
}