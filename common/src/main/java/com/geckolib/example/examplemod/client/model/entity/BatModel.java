package com.geckolib.example.examplemod.client.model.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.entity.BatEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.model.GeoModel;
import net.minecraft.resources.Identifier;

/**
 * Example {@link GeoModel} for the {@link BatEntity}
 * @see com.geckolib.example.examplemod.client.renderer.entity.BatRenderer BatRenderer
 */
public class BatModel extends DefaultedEntityGeoModel<BatEntity> {
	// We use the alternate super-constructor here to tell the model it should handle head-turning for us
	public BatModel() {
		super(Identifier.fromNamespaceAndPath(ModConstants.MODID, "bat"));
	}
}
