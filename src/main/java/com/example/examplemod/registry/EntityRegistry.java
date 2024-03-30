package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class EntityRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, ExampleMod.MODID);

	public static final DeferredHolder<EntityType<?>, EntityType<BatEntity>> BAT = register("bat", BatEntity::new, 0.7f, 1.3f, 0x1F1F1F, 0x0D0D0D);
	public static final DeferredHolder<EntityType<?>, EntityType<BikeEntity>> BIKE = register("bike", BikeEntity::new, 0.5f, 0.6f, 0xD3E3E6, 0xE9F1F5);
	public static final DeferredHolder<EntityType<?>, EntityType<RaceCarEntity>> RACE_CAR = register("race_car", RaceCarEntity::new, 1.5f, 1.5f, 0x9E1616, 0x595959);
	public static final DeferredHolder<EntityType<?>, EntityType<ParasiteEntity>> PARASITE = register("parasite", ParasiteEntity::new, 1.5f, 1.5f, 0x302219, 0xACACAC);
	public static final DeferredHolder<EntityType<?>, EntityType<DynamicExampleEntity>> MUTANT_ZOMBIE = register("mutant_zombie", DynamicExampleEntity::new, 0.5f, 1.9f, 0x3C6236, 0x579989);
	public static final DeferredHolder<EntityType<?>, EntityType<FakeGlassEntity>> FAKE_GLASS = register("fake_glass", FakeGlassEntity::new, 1, 1, 0xDD0000, 0xD8FFF7);
	public static final DeferredHolder<EntityType<?>, EntityType<CoolKidEntity>> COOL_KID = register("cool_kid", CoolKidEntity::new, 0.45f, 1f, 0x5F2A31, 0x6F363E);
    public static final DeferredHolder<EntityType<?>, EntityType<DynamicExampleEntity>> GREMLIN = register("gremlin", DynamicExampleEntity::new, 0.5f, 1.9f, 0x505050, 0x606060);

	@SubscribeEvent
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		AttributeSupplier.Builder genericAttribs = PathfinderMob.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 16)
				.add(Attributes.MAX_HEALTH, 1);
		AttributeSupplier.Builder genericMovingAttribs = PathfinderMob.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 16)
				.add(Attributes.MAX_HEALTH, 1)
				.add(Attributes.MOVEMENT_SPEED, 0.25f);
		AttributeSupplier.Builder genericMonsterAttribs = Monster.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 16)
				.add(Attributes.MAX_HEALTH, 1)
				.add(Attributes.MOVEMENT_SPEED, 0.25f)
				.add(Attributes.ATTACK_DAMAGE, 5)
				.add(Attributes.ATTACK_KNOCKBACK, 0.1);

		event.put(EntityRegistry.BIKE.get(), genericAttribs.build());
		event.put(EntityRegistry.RACE_CAR.get(), genericAttribs.build());
		event.put(EntityRegistry.BAT.get(), genericAttribs.build());
		event.put(EntityRegistry.MUTANT_ZOMBIE.get(), genericAttribs.build());
		event.put(EntityRegistry.GREMLIN.get(), genericAttribs.build());
		event.put(EntityRegistry.COOL_KID.get(), genericMovingAttribs.build());
		event.put(EntityRegistry.FAKE_GLASS.get(), genericMovingAttribs.build());
		event.put(EntityRegistry.PARASITE.get(), genericMonsterAttribs.build());
	}

	private static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.EntityFactory<T> entity, float width, float height, int primaryEggColor, int secondaryEggColor) {
		return ENTITIES.register(name, () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
	}
}
