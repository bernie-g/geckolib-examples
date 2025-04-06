package com.example.examplemod.client.renderer.entity.layer;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.CoolKidRenderer;
import com.example.examplemod.entity.CoolKidEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/**
 * Example implementation of a {@link GeoRenderLayer}.<br>
 * Renders a pair of glasses over the {@link CoolKidEntity} example entity
 * @see CoolKidRenderer CoolKidRenderer
 */
public class CoolKidGlassesLayer<R extends LivingEntityRenderState & GeoRenderState> extends GeoRenderLayer<CoolKidEntity, Void, R> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "textures/entity/cool_kid_glasses.png");

	public CoolKidGlassesLayer(GeoEntityRenderer<CoolKidEntity, R> entityRenderer) {
        super(entityRenderer);
    }

    // Apply the glasses texture layer to the existing geo model, and render it over the top of the existing model
    @Override
    public void render(R renderState, PoseStack poseStack, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int renderColor) {
        renderType = RenderType.armorCutoutNoCull(TEXTURE);

        getRenderer().reRender(renderState, poseStack, bakedModel, bufferSource, renderType, bufferSource.getBuffer(renderType), packedLight, packedOverlay, renderColor);
    }
}