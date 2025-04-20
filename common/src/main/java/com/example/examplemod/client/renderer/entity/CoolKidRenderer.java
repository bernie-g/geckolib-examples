package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.entity.CoolKidEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.layer.TextureLayerGeoLayer;

/**
 * Example {@link GeoRenderer} implementation of an entity that uses a {@link GeoRenderLayer render layer}
 * @see CoolKidEntity
 */
public class CoolKidRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<CoolKidEntity, R> {
	public CoolKidRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "cool_kid")));

		this.shadowRadius = 0.25f;

		// Add our render layer
		addRenderLayer(new TextureLayerGeoLayer<>(this,
												  ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "textures/entity/cool_kid_glasses.png"),
												  RenderType::armorCutoutNoCull));
    }
}
