package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public final class BlockEntityRegistry {
	public static void init() {}

	public static final Supplier<BlockEntityType<GeckoHabitatBlockEntity>> GECKO_HABITAT = registerBlockEntity("habitat", () -> BlockEntityType.Builder.of(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT.get()).build(null));
	public static final Supplier<BlockEntityType<FertilizerBlockEntity>> FERTILIZER_BLOCK = registerBlockEntity("fertilizer", () -> BlockEntityType.Builder.of(FertilizerBlockEntity::new, BlockRegistry.FERTILIZER.get()).build(null));

	private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
		return ExampleModCommon.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
	}
}
