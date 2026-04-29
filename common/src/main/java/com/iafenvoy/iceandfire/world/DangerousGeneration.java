package com.iafenvoy.iceandfire.world;

import com.iafenvoy.uranus.ServerHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

import java.util.Optional;

public interface DangerousGeneration {
    default boolean isFarEnoughFromSpawn(WorldAccess world, BlockPos pos) {
        return !this.getOrigin(world, pos).isWithinDistance(pos, this.getDangerousRadius());
    }

    default boolean isFarEnoughFromSpawn(BlockPos pos) {
        return Optional.ofNullable(ServerHelper.server).map(server -> this.isFarEnoughFromSpawn(server.getOverworld(), pos)).orElse(true);
    }

    double getDangerousRadius();

    default BlockPos getOrigin(WorldAccess world, BlockPos pos) {
        BlockPos spawn = world.getLevelProperties().getSpawnPos();
        return new BlockPos(spawn.getX(), pos.getY(), spawn.getZ());
    }
}
