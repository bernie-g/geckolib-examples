package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public final class SoundRegistry {
	public static void init() {}

	public static Supplier<SoundEvent> JACK_MUSIC = registerSound("jack_in_the_box_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "jack_in_the_box_music")));

	private static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
		return ExampleModCommon.COMMON_PLATFORM.registerSound(id, sound);
	}
}
