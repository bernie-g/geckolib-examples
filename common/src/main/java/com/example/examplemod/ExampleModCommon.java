package com.example.examplemod;

import com.example.examplemod.platform.ExampleModPlatform;
import com.example.examplemod.registry.*;

import java.util.ServiceLoader;

/**
 * Base multiloader class for the mod, handling all the common distribution tasks and holding common values
 */
public final class ExampleModCommon {
    public static final String MODID = "examplemod";

    public static final ExampleModPlatform COMMON_PLATFORM = ServiceLoader.load(ExampleModPlatform.class).findFirst().orElseThrow();

    public static void doRegistrations() {
        SoundRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        EntityRegistry.init();
        ItemRegistry.init();
    }
}
