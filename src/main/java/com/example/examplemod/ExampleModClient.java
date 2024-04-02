package com.example.examplemod;

import com.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import com.example.examplemod.client.renderer.entity.*;
import com.example.examplemod.registry.BlockEntityRegistry;
import com.example.examplemod.registry.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.entity.EntityType;

public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegistry.BAT, BatRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.BIKE, BikeRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.RACE_CAR, RaceCarRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.PARASITE, ParasiteRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.COOL_KID, CoolKidRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.MUTANT_ZOMBIE, MutantZombieRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.GREMLIN, GremlinRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.FAKE_GLASS, FakeGlassRenderer::new);

        EntityRendererRegistry.register(EntityType.CREEPER, ReplacedCreeperRenderer::new);

        BlockEntityRenderers.register(BlockEntityRegistry.GECKO_HABITAT, context -> new GeckoHabitatBlockRenderer());
        BlockEntityRenderers.register(BlockEntityRegistry.FERTILIZER_BLOCK, context -> new FertilizerBlockRenderer());
    }
}
