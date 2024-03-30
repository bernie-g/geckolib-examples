package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class BlockEntityRegistry {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ExampleMod.MODID);

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GeckoHabitatBlockEntity>> GECKO_HABITAT = BLOCK_ENTITIES.register("habitat", () -> BlockEntityType.Builder.of(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT.get()).build(null));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FertilizerBlockEntity>> FERTILIZER_BLOCK = BLOCK_ENTITIES.register("fertilizer", () -> BlockEntityType.Builder.of(FertilizerBlockEntity::new, BlockRegistry.FERTILIZER.get()).build(null));
}
