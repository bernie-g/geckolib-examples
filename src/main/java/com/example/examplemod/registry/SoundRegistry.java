package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class SoundRegistry {
	public static SoundEvent JACK_MUSIC = register("jack_in_the_box_music", SoundEvent.createVariableRangeEvent(new ResourceLocation(ExampleMod.MODID, "jack_in_the_box_music")));

	public static void init() {}

	public static <T extends SoundEvent> T register(String name, T sound) {
		return Registry.register(BuiltInRegistries.SOUND_EVENT, new ResourceLocation(ExampleMod.MODID, name), sound);
	}
}
