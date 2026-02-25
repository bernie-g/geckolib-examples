package com.geckolib.example.examplemod.block.entity;

import com.geckolib.animatable.GeoBlockEntity;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.RawAnimation;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.example.examplemod.client.model.block.FertilizerModel;
import com.geckolib.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import com.geckolib.example.examplemod.registry.BlockEntityRegistry;
import com.geckolib.util.GeckoLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Example {@link BlockEntity} implementation using a GeckoLib model.
 * @see FertilizerModel
 * @see FertilizerBlockRenderer
 */
public class FertilizerBlockEntity extends BlockEntity implements GeoBlockEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	// We register a new DataTicket under our modid to use for holding the raining predicate for later
	public static final DataTicket<Boolean> IS_RAINING = DataTicket.create("examplemod_is_raining", Boolean.class);

	// We statically instantiate our RawAnimations for efficiency, consistency, and error-proofing
	private static final RawAnimation FERTILIZER_ANIMS = RawAnimation.begin().thenPlay("fertilizer.deploy").thenLoop("fertilizer.idle");
	private static final RawAnimation BOTARIUM_ANIMS = RawAnimation.begin().thenPlay("botarium.deploy").thenLoop("botarium.idle");

	public FertilizerBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.FERTILIZER_BLOCK.get(), pos, state);
	}

	// Let's set our animations up
	// For this one, we want it to play the "Fertilizer" animation set if it's raining,
	// or switch to a botarium if it's not.
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("Main", test -> {
            if (test.getData(IS_RAINING))
                return test.setAndContinue(FERTILIZER_ANIMS);

            return test.setAndContinue(BOTARIUM_ANIMS);
        }));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
