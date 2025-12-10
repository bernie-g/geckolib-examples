package com.example.examplemod.block.entity;

import com.example.examplemod.client.model.block.GeckoHabitatModel;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import com.example.examplemod.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Example {@link BlockEntity} implementation using a GeckoLib model.
 * @see GeckoHabitatModel
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatBlockEntity extends BlockEntity implements GeoBlockEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	// We register a new DataTicket under our modid to use for holding the daytime predicate for later
	public static final DataTicket<Long> DAY_TIME = DataTicket.create("examplemod_day_time", Long.class);

	public GeckoHabitatBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.GECKO_HABITAT.get(), pos, state);
	}

	// We just want a permanent idle animation happening here
	// But if it's day time we want him to take a nap
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>("Main", animTest -> {
			long dayTime = animTest.getData(DAY_TIME);

			if (dayTime > 23000 || dayTime < 13000) {
				return animTest.setAndContinue(DefaultAnimations.REST);
			}
			else {
				return animTest.setAndContinue(DefaultAnimations.IDLE);
			}
		}));
	}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
