package com.geckolib.example.examplemod.registry;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class EntityRegistry {
	public static void init() {}

	public static final Supplier<EntityType<BatEntity>> BAT = register("bat", BatEntity::new, MobCategory.MISC, 0.7f, 1.3f);
	public static final Supplier<EntityType<BikeEntity>> BIKE = register("bike", BikeEntity::new, MobCategory.MISC, 0.5f, 0.6f);
	public static final Supplier<EntityType<RaceCarEntity>> RACE_CAR = register("race_car", RaceCarEntity::new, MobCategory.MISC, 1.5f, 1.5f);
	public static final Supplier<EntityType<ParasiteEntity>> PARASITE = register("parasite", ParasiteEntity::new, MobCategory.MISC, 1.5f, 1.5f);
	public static final Supplier<EntityType<DynamicExampleEntity>> MUTANT_ZOMBIE = register("mutant_zombie", DynamicExampleEntity::new, MobCategory.MISC, 0.5f, 1.9f);
	public static final Supplier<EntityType<FakeGlassEntity>> FAKE_GLASS = register("fake_glass", FakeGlassEntity::new, MobCategory.MISC, 1, 1);
	public static final Supplier<EntityType<CoolKidEntity>> COOL_KID = register("cool_kid", CoolKidEntity::new, MobCategory.MISC, 0.45f, 1f);
    public static final Supplier<EntityType<DynamicExampleEntity>> GREMLIN = register("gremlin", DynamicExampleEntity::new, MobCategory.MISC, 0.5f, 1.9f);

	public static void registerEntityAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier> registrar) {
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

	//<editor-fold defaultstate="collapsed" desc="<Registration Methods>">
	/// Register a basic [EntityType]
	private static <T extends Entity> Supplier<EntityType<T>> register(String id, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
		return register(id, () -> EntityType.Builder.of(factory, category).sized(width, height));
	}

	/// Register a basic [EntityType], additionally specifying a custom eye height
	private static <T extends Entity> Supplier<EntityType<T>> register(String id, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height, float eyeHeight) {
		return register(id, () -> EntityType.Builder.of(factory, category).sized(width, height).eyeHeight(eyeHeight));
	}

	/// Register an [EntityType]
	private static <T extends Entity> Supplier<EntityType<T>> register(String id, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height, UnaryOperator<EntityType.Builder<T>> modifier) {
		return register(id, () -> modifier.apply(EntityType.Builder.of(factory, category).sized(width, height)));
	}

	/// Register an [EntityType]
	private static <T extends Entity> Supplier<EntityType<T>> register(String id, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height, float eyeHeight, UnaryOperator<EntityType.Builder<T>> modifier) {
		return register(id, () -> modifier.apply(EntityType.Builder.of(factory, category).sized(width, height).eyeHeight(eyeHeight)));
	}

	/// Register a custom [EntityType]
	private static <T extends Entity> Supplier<EntityType<T>> register(String id, Supplier<EntityType.Builder<T>> entityTypeBuilder) {
		return ModConstants.PLATFORM.registerEntity(id, () -> entityTypeBuilder.get().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ModConstants.MODID, id))));
	}
	//</editor-fold>
}
