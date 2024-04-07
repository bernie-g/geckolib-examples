package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class GeckoHabitatItem extends BlockItem implements GeoItem {
	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public GeckoHabitatItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private GeoItemRenderer<GeckoHabitatItem> renderer = null;

			@Override
			@Nullable
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (this.renderer == null)
					this.renderer = new GeoItemRenderer<>(new DefaultedBlockGeoModel<>(new ResourceLocation(ExampleMod.MODID, "gecko_habitat")));
				// Defer creation of our renderer then cache it so that it doesn't get instantiated too early

				return this.renderer;
			}
		});
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}
}