package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class SoundRegistry {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, ExampleMod.MODID);

	public static RegistryObject<SoundEvent> JACK_MUSIC = SOUNDS.register("jack_in_the_box_music", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ExampleMod.MODID, "jack_in_the_box_music")));
}
