package io.github.chakyl.whimsydeco.blocks.providers;


import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;
/**
 * @author skyjay1
 * [https://github.com/skyjay1/Tanuki-Decor/blob/main-1.20.1/src/main/java/tanukidecor/block/seat/ISeatProvider.java]
 * Used with permission under the GNU LGPLv3 license
 */
public interface ISeatProvider {

    public static final Predicate<Entity> IS_SEAT_ENTITY = e ->
            e.getType() == EntityType.PIG && e.isSilent() && e.isInvisible() && e.isNoGravity();

    /**
     * @param blockState the block state
     * @param level the level
     * @param blockPos the block position
     * @return the vertical offset of the seat entity, typically 2 pixels above the seating part of the model
     */
    double getSeatYOffset(BlockState blockState, Level level, BlockPos blockPos);

    /**
     * @param blockState the block state
     * @param level the level
     * @param blockPos the block position
     * @return the horizontal direction toward the front of the seat
     */
    Direction getSeatDirection(BlockState blockState, Level level, BlockPos blockPos);

    /**
     * @param blockState the block state
     * @param level the level
     * @param blockPos the block position
     * @return the position of the seat entity
     */
    default Vec3 getSeatPosition(BlockState blockState, Level level, BlockPos blockPos) {
        return new Vec3(blockPos.getX() + 0.5D, blockPos.getY() + getSeatYOffset(blockState, level, blockPos), blockPos.getZ() + 0.5D);
    }

    /**
     * @param blockState the block state
     * @param level the level
     * @param pos the block position
     * @param force true to despawn the seat even if it has a passenger
     * @return true if the seat entity had no passengers and was removed
     */
    default boolean despawnSeat(BlockState blockState, Level level, BlockPos pos, boolean force) {
        Entity entity = getSeat(level, pos);
        if(entity != null && (force || !entity.isVehicle())) {
            entity.ejectPassengers();
            entity.discard();
            return true;
        }
        return false;
    }

    /**
     * @param blockState the block state
     * @param level the level
     * @param pos the block position
     * @param player the player
     * @return true if the seat entity exists and the player was added as a passenger
     */
    default boolean startSitting(BlockState blockState, Level level, BlockPos pos, Player player) {
        Entity entity = getOrCreateSeat(blockState, level, pos);
        // verify entity exists and can be vehicle
        if(null == entity || entity.isVehicle()) {
            return false;
        }
        // add passenger
        if(!player.startRiding(entity, true)) {
            return false;
        }
        // update rotation
        if(player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.teleport(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), entity.getYRot(), serverPlayer.getXRot());
        }
        return true;
    }

    /**
     * @param blockState the block state
     * @param level the level
     * @param pos the block position
     * @return true if the seat entity exists and at the passenger was ejected
     */
    default boolean stopSitting(BlockState blockState, Level level, BlockPos pos) {
        // locate existing entity, if any
        Entity entity = getSeat(level, pos);
        if(null == entity || !entity.isVehicle()) {
            return false;
        }
        entity.ejectPassengers();
        return true;
    }

    /**
     * @param level the level
     * @param pos the block position
     * @return the entity to use as the seat
     * @see #getSeat(Level, BlockPos)
     */
    default @Nullable Entity getOrCreateSeat(BlockState blockState, Level level, BlockPos pos) {
        // locate existing entity, if an y
        final Entity existingEntity = getSeat(level, pos);
        if(existingEntity != null) {
            return existingEntity;
        }
        // otherwise, create new entity
        final Vec3 seatPos = getSeatPosition(blockState, level, pos);
        final Direction seatDirection = getSeatDirection(blockState, level, pos);
        final Pig entity = EntityType.PIG.create(level);
        if(entity != null) {
            // entity position and rotation
            final float rotation = seatDirection.toYRot();
            entity.setYRot(rotation);
            entity.setYHeadRot(rotation);
            entity.setPos(seatPos.add(0, -entity.getPassengersRidingOffset(), 0));
            // entity settings
            entity.setNoAi(true);
            entity.setSilent(true);
            entity.setNoGravity(true);
            entity.setInvisible(true);
            entity.setInvulnerable(true);
            entity.setAge(Integer.MIN_VALUE);
            entity.noPhysics = true;
            entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, Integer.MAX_VALUE, 0, false, false));
            // add entity to level
            level.addFreshEntity(entity);
        }
        return entity;
    }

    /**
     * @param level the level
     * @param pos the block position
     * @return the entity to use as the seat, if one exists
     */
    default @Nullable Entity getSeat(Level level, BlockPos pos) {
        final AABB aabb = new AABB(pos).inflate(-0.0625D, 0.25D, -0.0625D);
        final List<Entity> list = level.getEntitiesOfClass(Entity.class, aabb, IS_SEAT_ENTITY);
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}