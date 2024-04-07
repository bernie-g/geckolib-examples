package com.example.examplemod;

import com.example.examplemod.client.ExampleModClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public final class ExampleModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExampleModClient.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
    }
}
