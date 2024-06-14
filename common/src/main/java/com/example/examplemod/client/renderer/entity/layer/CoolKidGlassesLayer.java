package com.example.examplemod.client.renderer.entity.layer;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.CoolKidRenderer;
import com.example.examplemod.entity.CoolKidEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.Color;

/**
 * Example implementation of a {@link GeoRenderLayer}.<br>
 * Renders a pair of glasses over the {@link CoolKidEntity} example entity
 * @see CoolKidRenderer CoolKidRenderer
 */
public class CoolKidGlassesLayer extends GeoRenderLayer<CoolKidEntity> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "textures/entity/cool_kid_glasses.png");

	public CoolKidGlassesLayer(GeoRenderer<CoolKidEntity> entityRenderer) {
        super(entityRenderer);
    }

    // Apply the glasses texture layer to the existing geo model, and render it over the top of the existing model
    @Override
    public void render(PoseStack poseStack, CoolKidEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE);

        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                Color.WHITE.argbInt());
    }
}