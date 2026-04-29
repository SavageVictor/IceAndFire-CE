package com.iafenvoy.iceandfire.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record StructureGenerationConfig(float generateChance, double dangerousRadius) {
    public static final StructureGenerationConfig DEFAULT = new StructureGenerationConfig(0.5f, 1000.0);

    public static final Codec<StructureGenerationConfig> CODEC = RecordCodecBuilder.create(i ->
            i.group(
                    Codec.floatRange(0f, 1f)
                            .optionalFieldOf("generate_chance", 0.5f)
                            .forGetter(StructureGenerationConfig::generateChance),
                    Codec.doubleRange(0, 100_000)
                            .optionalFieldOf("dangerous_radius", 1000.0)
                            .forGetter(StructureGenerationConfig::dangerousRadius)
            ).apply(i, StructureGenerationConfig::new));
}
