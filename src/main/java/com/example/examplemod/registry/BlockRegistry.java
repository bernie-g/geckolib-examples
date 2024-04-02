package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.FertilizerBlock;
import com.example.examplemod.block.GeckoHabitatBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public final class BlockRegistry {
	public static final GeckoHabitatBlock GECKO_HABITAT = register("gecko_habitat", new GeckoHabitatBlock());
	public static final FertilizerBlock FERTILIZER = register("fertilizer", new FertilizerBlock());

	public static void init() {}

	public static <T extends Block> T register(String name, T block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ExampleMod.MODID, name), block);
	}
}
