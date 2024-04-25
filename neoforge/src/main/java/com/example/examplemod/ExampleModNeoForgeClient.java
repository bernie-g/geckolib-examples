package com.example.examplemod;

import com.example.examplemod.client.ExampleModClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = ExampleModCommon.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class ExampleModNeoForgeClient {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        ExampleModClient.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
}
