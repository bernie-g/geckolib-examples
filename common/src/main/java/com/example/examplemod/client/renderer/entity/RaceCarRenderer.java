package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.RaceCarModel;
import com.example.examplemod.entity.RaceCarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;

/**
 * Example {@link GeoRenderer} implementation of an entity
 * @see RaceCarModel
 * @see RaceCarEntity
 */
public class RaceCarRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<RaceCarEntity, R> {
	public RaceCarRenderer(EntityRendererProvider.Context context) {
		super(context, new RaceCarModel());
	}

    // We want this entity to have a translucent render
    @Override
    public @Nullable RenderType getRenderType(R renderState, Identifier texture) {
        return RenderTypes.entityTranslucent(texture);
    }
}