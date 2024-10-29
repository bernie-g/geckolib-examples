package com.example.examplemod.block;

import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.model.block.GeckoHabitatModel;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import com.example.examplemod.registry.BlockEntityRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * Example animated block using GeckoLib animations.<br>
 * There's nothing to see here since the {@link Block} class itself has little to do with animations
 * @see GeckoHabitatModel
 * @see GeckoHabitatBlockEntity
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatBlock extends BaseEntityBlock implements EntityBlock {
	public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

	public GeckoHabitatBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return null;
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING,
				context.getHorizontalDirection().getClockWise().getClockWise());
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return BlockEntityRegistry.GECKO_HABITAT.get().create(blockPos, blockState);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			case NORTH -> Block.box(0, 0, 0, 32, 16, 16);
			case SOUTH -> Block.box(-16, 0, 0, 16, 16, 16);
			case WEST -> Block.box(0, 0, -16, 16, 16, 16);
			default -> Block.box(0, 0, 0, 16, 16, 32);
		};
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		for (BlockPos testPos : BlockPos.betweenClosed(pos,
				pos.relative(state.getValue(FACING).getClockWise(), 2))) {
			if (!testPos.equals(pos) && !world.getBlockState(testPos).isAir())
				return false;
		}

		return true;
	}
}
