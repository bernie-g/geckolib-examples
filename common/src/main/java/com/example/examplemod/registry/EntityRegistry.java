package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.entity.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public final class EntityRegistry {
	public static void init() {}

	public static final Supplier<EntityType<BatEntity>> BAT = registerEntity("bat", BatEntity::new, 0.7f, 1.3f, 0x1F1F1F, 0x0D0D0D);
	public static final Supplier<EntityType<BikeEntity>> BIKE = registerEntity("bike", BikeEntity::new, 0.5f, 0.6f, 0xD3E3E6, 0xE9F1F5);
	public static final Supplier<EntityType<RaceCarEntity>> RACE_CAR = registerEntity("race_car", RaceCarEntity::new, 1.5f, 1.5f, 0x9E1616, 0x595959);
	public static final Supplier<EntityType<ParasiteEntity>> PARASITE = registerEntity("parasite", ParasiteEntity::new, 1.5f, 1.5f, 0x302219, 0xACACAC);
	public static final Supplier<EntityType<DynamicExampleEntity>> MUTANT_ZOMBIE = registerEntity("mutant_zombie", DynamicExampleEntity::new, 0.5f, 1.9f, 0x3C6236, 0x579989);
	public static final Supplier<EntityType<FakeGlassEntity>> FAKE_GLASS = registerEntity("fake_glass", FakeGlassEntity::new, 1, 1, 0xDD0000, 0xD8FFF7);
	public static final Supplier<EntityType<CoolKidEntity>> COOL_KID = registerEntity("cool_kid", CoolKidEntity::new, 0.45f, 1f, 0x5F2A31, 0x6F363E);
    public static final Supplier<EntityType<DynamicExampleEntity>> GREMLIN = registerEntity("gremlin", DynamicExampleEntity::new, 0.5f, 1.9f, 0x505050, 0x606060);

	public static void registerEntityAttributes(BiConsumer<EntityType<? extends Entity>, AttributeSupplier> registrar) {
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

		registrar.accept(EntityRegistry.BIKE.get(), genericAttribs.build());
		registrar.accept(EntityRegistry.RACE_CAR.get(), genericAttribs.build());
		registrar.accept(EntityRegistry.BAT.get(), genericAttribs.build());
		registrar.accept(EntityRegistry.MUTANT_ZOMBIE.get(), genericAttribs.build());
		registrar.accept(EntityRegistry.GREMLIN.get(), genericAttribs.build());
		registrar.accept(EntityRegistry.COOL_KID.get(), genericMovingAttribs.build());
		registrar.accept(EntityRegistry.FAKE_GLASS.get(), genericMovingAttribs.build());
		registrar.accept(EntityRegistry.PARASITE.get(), genericMonsterAttribs.build());
	}

	private static <T extends Mob> Supplier<EntityType<T>> registerEntity(String name, EntityType.EntityFactory<T> entity, float width, float height, int primaryEggColor, int secondaryEggColor) {
		return ExampleModCommon.COMMON_PLATFORM.registerEntity(name, () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
	}
}
