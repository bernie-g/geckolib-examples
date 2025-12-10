package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.ParasiteModel;
import com.example.examplemod.entity.ParasiteEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoEntityRenderer} implementation of an entity
 * @see ParasiteModel
 * @see ParasiteEntity
 */
public class ParasiteRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<ParasiteEntity, R> {
	public ParasiteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ParasiteModel());
	}

    // We want this entity to have a translucent render
    @Override
    public @Nullable RenderType getRenderType(R renderState, Identifier texture) {
        return RenderTypes.entityTranslucent(texture);
    }
}
