package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

import java.util.List;

public final class ArmorMaterialRegistry {
    public static final Holder<ArmorMaterial> WOLF_ARMOR_MATERIAL = register("wolf", ArmorMaterialRegistry.dummyArmorMaterial());
    public static final Holder<ArmorMaterial> GECKO_ARMOR_MATERIAL = register("gecko", ArmorMaterialRegistry.dummyArmorMaterial());

    public static void init() {}

    public static <M extends ArmorMaterial> Holder<M> register(String name, M armorMaterial) {
        return (Holder<M>)Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, new ResourceLocation(ExampleMod.MODID, name), armorMaterial);
    }

    private static ArmorMaterial dummyArmorMaterial() {
        ArmorMaterial diamond = ArmorMaterials.DIAMOND.value();

        return new ArmorMaterial(diamond.defense(), diamond.enchantmentValue(), diamond.equipSound(), diamond.repairIngredient(), List.of(), diamond.toughness(), diamond.knockbackResistance());
    }
}
