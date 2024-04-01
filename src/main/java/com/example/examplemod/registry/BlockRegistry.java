package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.FertilizerBlock;
import com.example.examplemod.block.GeckoHabitatBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class BlockRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ExampleMod.MODID);

	public static final RegistryObject<GeckoHabitatBlock> GECKO_HABITAT = BLOCKS.register("gecko_habitat", GeckoHabitatBlock::new);
	public static final RegistryObject<FertilizerBlock> FERTILIZER = BLOCKS.register("fertilizer", FertilizerBlock::new);
}
