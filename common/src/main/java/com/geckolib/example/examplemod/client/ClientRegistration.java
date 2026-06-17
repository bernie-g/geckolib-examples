package com.geckolib.example.examplemod.client;

import com.geckolib.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import com.geckolib.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import com.geckolib.example.examplemod.client.renderer.entity.*;
import com.geckolib.example.examplemod.registry.BlockEntityRegistry;
import com.geckolib.example.examplemod.registry.EntityRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

/// Platform-agnostic client registration
public final class ClientRegistration {
    /// Register [EntityRenderers][EntityRenderer] and [BlockEntityRenderers][BlockEntityRenderer]
    @SuppressWarnings("rawtypes")
    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
                                         BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {
        entityRenderers.accept(EntityRegistry.BAT.get(), BatRenderer::new);
        entityRenderers.accept(EntityRegistry.BIKE.get(), BikeRenderer::new);
        entityRenderers.accept(EntityRegistry.RACE_CAR.get(), RaceCarRenderer::new);
        entityRenderers.accept(EntityRegistry.PARASITE.get(), ParasiteRenderer::new);
        entityRenderers.accept(EntityRegistry.COOL_KID.get(), CoolKidRenderer::new);
        entityRenderers.accept(EntityRegistry.MUTANT_ZOMBIE.get(), MutantZombieRenderer::new);
        entityRenderers.accept(EntityRegistry.GREMLIN.get(), GremlinRenderer::new);
        entityRenderers.accept(EntityRegistry.FAKE_GLASS.get(), FakeGlassRenderer::new);

        entityRenderers.accept(EntityTypes.CREEPER, ReplacedCreeperRenderer::new);

        blockEntityRenderers.accept(BlockEntityRegistry.GECKO_HABITAT.get(), GeckoHabitatBlockRenderer::new);
        blockEntityRenderers.accept(BlockEntityRegistry.FERTILIZER_BLOCK.get(), FertilizerBlockRenderer::new);
    }
}
