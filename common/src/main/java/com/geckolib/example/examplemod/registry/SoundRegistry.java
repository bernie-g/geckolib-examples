package com.geckolib.example.examplemod.registry;

import com.geckolib.example.examplemod.ModConstants;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public final class SoundRegistry {
	public static void init() {}

	public static Supplier<SoundEvent> JACK_MUSIC = registerSound("jack_in_the_box_music", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(ModConstants.MODID, "jack_in_the_box_music")));

	private static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
		return ModConstants.PLATFORM.registerSound(id, sound);
	}
}
