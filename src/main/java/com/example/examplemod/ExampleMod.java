package com.example.examplemod;

import com.example.examplemod.registry.*;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {
	public static final String MODID = "examplemod";

	@Override
	public void onInitialize() {
		BlockRegistry.init();
		EntityRegistry.init();
		ItemRegistry.init();
		BlockEntityRegistry.init();
		SoundRegistry.init();
	}
}