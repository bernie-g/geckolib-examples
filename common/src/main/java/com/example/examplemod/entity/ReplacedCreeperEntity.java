package com.example.examplemod.entity;

import net.minecraft.world.entity.EntityType;
import com.geckolib.animatable.GeoEntity;
import com.geckolib.animatable.GeoReplacedEntity;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.util.GeckoLibUtil;

/**
 * Replacement {@link net.minecraft.world.entity.monster.Creeper Creeper} {@link GeoEntity} to showcase
 * replacing the model and animations of an existing entity
 *
 * @see com.geckolib.renderer.GeoReplacedEntityRenderer GeoReplacedEntityRenderer
 * @see com.example.examplemod.client.renderer.entity.ReplacedCreeperRenderer ReplacedCreeperRenderer
 * @see com.example.examplemod.client.model.entity.ReplacedCreeperModel ReplacedCreeperModel
 */
public class ReplacedCreeperEntity implements GeoReplacedEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	// Register the idle + walk animations for the entity.<br>
	// In this situation we're going to use a generic controller that is already built for us
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(DefaultAnimations.genericWalkIdleController());
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}

	@Override
	public EntityType<?> getReplacingEntityType() {
		return EntityType.CREEPER;
	}
}
