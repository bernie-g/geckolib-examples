package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class BlockEntityRegistry {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ExampleMod.MODID);

	public static final RegistryObject<BlockEntityType<GeckoHabitatBlockEntity>> GECKO_HABITAT = BLOCK_ENTITIES.register("habitat", () -> BlockEntityType.Builder.of(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT.get()).build(null));
	public static final RegistryObject<BlockEntityType<FertilizerBlockEntity>> FERTILIZER_BLOCK = BLOCK_ENTITIES.register("fertilizer", () -> BlockEntityType.Builder.of(FertilizerBlockEntity::new, BlockRegistry.FERTILIZER.get()).build(null));
}
