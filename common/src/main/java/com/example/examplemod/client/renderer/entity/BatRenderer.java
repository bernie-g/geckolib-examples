package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.BatModel;
import com.example.examplemod.entity.BatEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.util.ClientUtil;

/**
 * Example {@link GeoRenderer} for {@link BatEntity}
 * @see BatModel
 */
public class BatRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<BatEntity, R> {
	private int lastParticleTick = -1;

	public BatRenderer(EntityRendererProvider.Context context) {
		super(context, new BatModel());

		// Add the glow layer to the bat so that it can live out its dreams of being rudolph
		addRenderLayer(new AutoGlowingGeoLayer<>(this));
	}

	// Add some particles around the ear when rendering
	// Normally you would do this properly via the entity's tick, but for the sake of brevity in this example I've done it here
	@Override
	public void renderFinal(R renderState, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer) {
		if (this.lastParticleTick < 0 || this.lastParticleTick < renderState.ageInTicks - 1) {
			this.lastParticleTick = (int)renderState.ageInTicks;

			// Find the earbone and use it as the point of reference
			this.model.getBone("leftear").ifPresent(ear -> {
				RandomSource rand = ClientUtil.getLevel().getRandom();
				Vector3d earPos = ear.getWorldPosition();

				ClientUtil.getLevel().addParticle(ParticleTypes.PORTAL,
															   earPos.x(),
															   earPos.y(),
															   earPos.z(),
															   rand.nextDouble() - 0.5D,
															   -rand.nextDouble(),
															   rand.nextDouble() - 0.5D);
			});
		}

		super.renderFinal(renderState, poseStack, model, bufferSource, buffer);
	}
}
