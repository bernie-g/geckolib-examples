package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.entity.BatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link BatEntity}
 * @see com.example.examplemod.client.renderer.entity.BatRenderer BatRenderer
 */
public class BatModel extends DefaultedEntityGeoModel<BatEntity> {
	// We use the alternate super-constructor here to tell the model it should handle head-turning for us
	public BatModel() {
		super(new ResourceLocation(ExampleModCommon.MODID, "bat"), true);
	}
}
