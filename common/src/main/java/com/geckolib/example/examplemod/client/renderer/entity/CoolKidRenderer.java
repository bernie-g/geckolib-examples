package com.geckolib.example.examplemod.client.renderer.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.entity.CoolKidEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.GeoRenderer;
import com.geckolib.renderer.layer.GeoRenderLayer;
import com.geckolib.renderer.layer.builtin.TextureLayerGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

/**
 * Example {@link GeoRenderer} implementation of an entity that uses a {@link GeoRenderLayer render layer}
 * @see CoolKidEntity
 */
public class CoolKidRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<CoolKidEntity, R> {
	public CoolKidRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(Identifier.fromNamespaceAndPath(ModConstants.MODID, "cool_kid")));

		this.shadowRadius = 0.25f;

		// Add our render layer
		withRenderLayer(new TextureLayerGeoLayer<>(this,
												   Identifier.fromNamespaceAndPath(ModConstants.MODID, "textures/entity/cool_kid_glasses.png"),
												   RenderTypes::armorCutoutNoCull));
    }
}
