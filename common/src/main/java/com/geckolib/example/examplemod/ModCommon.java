package com.geckolib.example.examplemod;

import com.geckolib.example.examplemod.registry.*;

/// Platform-agnostic common-code setup
public final class ModCommon {
    /// Call out to all common-code platform-agnostic mod initialization tasks
    public static void init() {
        doRegistrations();
    }

    /// Call out to the various common-code platform-agnostic registration tasks
    public static void doRegistrations() {
        SoundRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        EntityRegistry.init();
        ArmorMaterialRegistry.init();
        ItemRegistry.init();
    }
}
