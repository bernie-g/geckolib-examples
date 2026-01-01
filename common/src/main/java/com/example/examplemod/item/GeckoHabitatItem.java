package com.example.examplemod.item;

import com.example.examplemod.ExampleModCommon;
import com.google.common.base.Suppliers;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class GeckoHabitatItem extends BlockItem implements GeoItem {
	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public GeckoHabitatItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			// Defer creation of our renderer then cache it so that it doesn't get instantiated too early
			private final Supplier<GeoItemRenderer<GeckoHabitatItem>> renderer = Suppliers.memoize(
					() -> new GeoItemRenderer<GeckoHabitatItem>(new DefaultedBlockGeoModel<>(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "gecko_habitat"))));

			@Nullable
			@Override
			public GeoItemRenderer<GeckoHabitatItem> getGeoItemRenderer() {
				return this.renderer.get();
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
