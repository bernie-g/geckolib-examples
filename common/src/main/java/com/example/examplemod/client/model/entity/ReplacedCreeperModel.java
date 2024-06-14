package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.ReplacedCreeperRenderer;
import com.example.examplemod.entity.ReplacedCreeperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

/**
 * Example {@link software.bernie.geckolib.model.GeoModel} for dynamically replacing an
 * existing entity's renderer with a GeckoLib model (in this case, {@link net.minecraft.world.entity.monster.Creeper}
 * @see software.bernie.geckolib.renderer.GeoReplacedEntityRenderer
 * @see ReplacedCreeperRenderer ReplacedCreeperRenderer
 */
public class ReplacedCreeperModel extends DefaultedEntityGeoModel<ReplacedCreeperEntity> {
	public ReplacedCreeperModel() {
		super(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "creeper"));
	}
}
