package com.geckolib.example.examplemod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

/// Initializer class for Fabric-specific client setup tasks
public final class FabricClient implements ClientModInitializer {
    @SuppressWarnings("deprecation")
    @Override
    public void onInitializeClient() {
        ClientRegistration.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
    }
}
