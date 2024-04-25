package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.GeckoArmorItem;
import com.example.examplemod.item.GeckoHabitatItem;
import com.example.examplemod.item.JackInTheBoxItem;
import com.example.examplemod.item.WolfArmorItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public final class ArmorMaterialRegistry {
	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, ExampleMod.MODID);

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> WOLF_ARMOR_MATERIAL = ARMOR_MATERIALS.register("wolf", ArmorMaterialRegistry::dummyArmorMaterial);
	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> GECKO_ARMOR_MATERIAL = ARMOR_MATERIALS.register("gecko", ArmorMaterialRegistry::dummyArmorMaterial);

	private static ArmorMaterial dummyArmorMaterial() {
		ArmorMaterial diamond = ArmorMaterials.DIAMOND.value();

		return new ArmorMaterial(diamond.defense(), diamond.enchantmentValue(), diamond.equipSound(), diamond.repairIngredient(), List.of(), diamond.toughness(), diamond.knockbackResistance());
	}
}
