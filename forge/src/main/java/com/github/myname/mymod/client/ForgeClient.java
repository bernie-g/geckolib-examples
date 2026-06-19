package com.github.myname.mymod.client;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.client.ClientRegistration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/// Initializer class for Forge-specific client setup tasks
@Mod.EventBusSubscriber(modid = ModConstants.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ForgeClient {
    /// Register [Entity] and [BlockEntity] renderers
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        ClientRegistration.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
}
