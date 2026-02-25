package com.github.myname.mymod.client;

import com.github.myname.mymod.ModConstants;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

/// Initializer class for Forge-specific client setup tasks
@Mod.EventBusSubscriber(modid = ModConstants.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ForgeClient {
    /// Register [Entity] and [BlockEntity] renderers
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        ClientRegistration.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
}
