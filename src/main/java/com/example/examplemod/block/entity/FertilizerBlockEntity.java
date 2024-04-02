package com.example.examplemod.block.entity;

import com.example.examplemod.client.model.block.FertilizerModel;
import com.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import com.example.examplemod.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Example {@link BlockEntity} implementation using a GeckoLib model.
 * @see FertilizerModel
 * @see FertilizerBlockRenderer
 */
public class FertilizerBlockEntity extends BlockEntity implements GeoBlockEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	// We statically instantiate our RawAnimations for efficiency, consistency, and error-proofing
	private static final RawAnimation FERTILIZER_ANIMS = RawAnimation.begin().thenPlay("fertilizer.deploy").thenLoop("fertilizer.idle");
	private static final RawAnimation BOTARIUM_ANIMS = RawAnimation.begin().thenPlay("botarium.deploy").thenLoop("botarium.idle");

	public FertilizerBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.FERTILIZER_BLOCK, pos, state);
	}

	// Let's set our animations up
	// For this one, we want it to play the "Fertilizer" animation set if it's raining,
	// or switch to a botarium if it's not.
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, state -> {
			if (state.getAnimatable().getLevel().isRaining())
				return state.setAndContinue(FERTILIZER_ANIMS);

			return state.setAndContinue(BOTARIUM_ANIMS);
		}));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
