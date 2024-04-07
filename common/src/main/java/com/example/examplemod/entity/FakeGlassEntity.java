package com.example.examplemod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Example {@link GeoAnimatable} implementation of an entity that uses the texture-per-bone feature of {@link software.bernie.geckolib.renderer.specialty.DynamicGeoEntityRenderer DynamicGeoEntityRenderer}
 *
 * @see com.example.examplemod.client.model.entity.FakeGlassModel FakeGlassModel
 * @see com.example.examplemod.client.renderer.entity.FakeGlassRenderer FakeGlassRenderer
 */
public class FakeGlassEntity extends PathfinderMob implements GeoEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public FakeGlassEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
		super(entityType, level);
	}

	// We don't care about animations for this one
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
