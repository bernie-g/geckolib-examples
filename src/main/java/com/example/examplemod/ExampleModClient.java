package com.example.examplemod;

import com.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import com.example.examplemod.client.renderer.entity.*;
import com.example.examplemod.client.renderer.entity.*;
import com.example.examplemod.registry.BlockEntityRegistry;
import com.example.examplemod.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = ExampleMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExampleModClient {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntityRegistry.BAT.get(), BatRenderer::new);
            event.registerEntityRenderer(EntityRegistry.BIKE.get(), BikeRenderer::new);
            event.registerEntityRenderer(EntityRegistry.RACE_CAR.get(), RaceCarRenderer::new);
            event.registerEntityRenderer(EntityRegistry.PARASITE.get(), ParasiteRenderer::new);
            event.registerEntityRenderer(EntityRegistry.COOL_KID.get(), CoolKidRenderer::new);
            event.registerEntityRenderer(EntityRegistry.MUTANT_ZOMBIE.get(), MutantZombieRenderer::new);
            event.registerEntityRenderer(EntityRegistry.GREMLIN.get(), GremlinRenderer::new);
            event.registerEntityRenderer(EntityRegistry.FAKE_GLASS.get(), FakeGlassRenderer::new);

            event.registerEntityRenderer(EntityType.CREEPER, ReplacedCreeperRenderer::new);

            event.registerBlockEntityRenderer(BlockEntityRegistry.GECKO_HABITAT.get(), context -> new GeckoHabitatBlockRenderer());
            event.registerBlockEntityRenderer(BlockEntityRegistry.FERTILIZER_BLOCK.get(), context -> new FertilizerBlockRenderer());
    }
}
