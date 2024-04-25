package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

import java.util.List;
import java.util.function.Supplier;

public final class ArmorMaterialRegistry {
	public static void init() {}

	public static final Holder<ArmorMaterial> WOLF_ARMOR_MATERIAL = registerArmorMaterial("wolf", ArmorMaterialRegistry::dummyArmorMaterial);
	public static final Holder<ArmorMaterial> GECKO_ARMOR_MATERIAL = registerArmorMaterial("gecko", ArmorMaterialRegistry::dummyArmorMaterial);

	private static <T extends ArmorMaterial> Holder<T> registerArmorMaterial(String id, Supplier<T> armorMaterial) {
		return ExampleModCommon.COMMON_PLATFORM.registerArmorMaterial(id, armorMaterial);
	}

	private static ArmorMaterial dummyArmorMaterial() {
		ArmorMaterial diamond = ArmorMaterials.DIAMOND.value();

		return new ArmorMaterial(diamond.defense(), diamond.enchantmentValue(), diamond.equipSound(), diamond.repairIngredient(), List.of(), diamond.toughness(), diamond.knockbackResistance());
	}
}
