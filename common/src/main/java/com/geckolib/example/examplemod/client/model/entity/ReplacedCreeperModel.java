package com.geckolib.example.examplemod.client.model.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.client.renderer.entity.ReplacedCreeperRenderer;
import com.geckolib.example.examplemod.entity.ReplacedCreeperEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import net.minecraft.resources.Identifier;

/**
 * Example {@link com.geckolib.model.GeoModel} for dynamically replacing an
 * existing entity's renderer with a GeckoLib model (in this case, {@link net.minecraft.world.entity.monster.Creeper}
 * @see com.geckolib.renderer.GeoReplacedEntityRenderer
 * @see ReplacedCreeperRenderer ReplacedCreeperRenderer
 */
public class ReplacedCreeperModel extends DefaultedEntityGeoModel<ReplacedCreeperEntity> {
	public ReplacedCreeperModel() {
		super(Identifier.fromNamespaceAndPath(ModConstants.MODID, "creeper"));
	}
}
