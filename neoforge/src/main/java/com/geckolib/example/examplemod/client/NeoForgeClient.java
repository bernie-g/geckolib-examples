package com.geckolib.example.examplemod.client;

import com.geckolib.example.examplemod.ModConstants;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/// Initializer class for NeoForge-specific client setup tasks
@Mod(value = ModConstants.MODID, dist = Dist.CLIENT)
public final class NeoForgeClient {
    public NeoForgeClient(IEventBus modBus, ModContainer modContainer) {
        modBus.addListener(EntityRenderersEvent.RegisterRenderers.class, NeoForgeClient::registerRenderers);
    }

    /// Register [Entity] and [BlockEntity] renderers
    private static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        ClientRegistration.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
}
