package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class BlockEntityRegistry {
	public static final BlockEntityType<GeckoHabitatBlockEntity> GECKO_HABITAT = register("habitat", BlockEntityType.Builder.of(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT));
	public static final BlockEntityType<FertilizerBlockEntity> FERTILIZER_BLOCK = register("fertilizer", BlockEntityType.Builder.of(FertilizerBlockEntity::new, BlockRegistry.FERTILIZER));

	public static void init() {}

	public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
		return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(ExampleMod.MODID, name), builder.build(null));
	}
}
