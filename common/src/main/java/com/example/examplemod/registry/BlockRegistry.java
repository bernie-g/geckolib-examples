package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.FertilizerBlock;
import com.example.examplemod.block.GeckoHabitatBlock;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public final class BlockRegistry {
	public static void init() {}

	public static final Supplier<GeckoHabitatBlock> GECKO_HABITAT = registerBlock("gecko_habitat", GeckoHabitatBlock::new);
	public static final Supplier<FertilizerBlock> FERTILIZER = registerBlock("fertilizer", FertilizerBlock::new);

	private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
		return ExampleModCommon.COMMON_PLATFORM.registerBlock(id, block);
	}
}
