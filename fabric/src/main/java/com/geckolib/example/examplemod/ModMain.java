package com.geckolib.example.examplemod;

import com.geckolib.example.examplemod.registry.EntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

/// Initializer class for Fabric-specific client setup tasks
public final class ModMain implements ModInitializer {
    @Override
    public void onInitialize() {
        ModConstants.init();
        ModCommon.init();

        EntityRegistry.registerEntityAttributes(FabricDefaultAttributeRegistry::register);
    }
}
