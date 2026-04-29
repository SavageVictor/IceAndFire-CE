package com.iafenvoy.iceandfire.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

public record BlockTransformRule(Block from, Block to) {
    public static final Codec<BlockTransformRule> CODEC = RecordCodecBuilder.create(i ->
            i.group(
                    Registries.BLOCK.getCodec().fieldOf("from").forGetter(BlockTransformRule::from),
                    Registries.BLOCK.getCodec().fieldOf("to").forGetter(BlockTransformRule::to)
            ).apply(i, BlockTransformRule::new));
}
