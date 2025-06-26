package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockModMobCage extends BlockMod {
	public final Identifier type, spawnItem;
	protected final BlockPos relativePos;

	public BlockModMobCage(Settings settings, Identifier type, @Nullable Identifier spawnItem, @Nullable BlockPos relativePos) {
		super(settings.pistonBehavior(PistonBehavior.BLOCK));
		this.type = type;
		this.spawnItem = spawnItem;
		this.relativePos = relativePos;
	}
	public BlockModMobCage(Identifier type, Identifier spawnItem) {
		super(Settings.copy(Blocks.SPAWNER).nonOpaque().pistonBehavior(PistonBehavior.BLOCK));
		this.type = type;
		this.spawnItem = spawnItem;
		relativePos = null;
	}
	public BlockModMobCage(Identifier type, Identifier spawnItem, MapColor color) {
		super(Settings.copy(Blocks.SPAWNER).nonOpaque().pistonBehavior(PistonBehavior.BLOCK).mapColor(color));
		this.type = type;
		this.spawnItem = spawnItem;
		relativePos = null;
	}
	public BlockModMobCage(Identifier type, @Nullable Identifier spawnItem, MapColor color, @Nullable BlockPos relativePos) {
		super(Settings.copy(Blocks.SPAWNER).nonOpaque().pistonBehavior(PistonBehavior.BLOCK).mapColor(color));
		this.type = type;
		this.spawnItem = spawnItem;
		this.relativePos = relativePos;
	}

	public void trySpawn(World world, BlockPos pos) {
		if (!world.isClient)
			Registries.ENTITY_TYPE.get(this.type).spawn(
					(ServerWorld) world,
					null,
					null,  // TODO: Make sure this does not have to be an empty Consumer instead of null
					this.relativePos == null ? pos : pos.add(this.relativePos),
					SpawnReason.MOB_SUMMONED,
					true,
					false
			);
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		trySpawn(world, pos);
		super.onBreak(world, pos, state, player);
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.isEmpty()) return super.onUse(state, world, pos, player, hand, hit);
		
		if(!player.getItemCooldownManager().isCoolingDown(stack.getItem()) && (spawnItem == null || stack.isOf(Registries.ITEM.get(spawnItem)))) {
			trySpawn(world, pos);
			if (spawnItem != null) {
				player.increaseStat(Stats.USED.getOrCreateStat(stack.getItem()), 1);
				player.getItemCooldownManager().set(stack.getItem(), 40);
				stack.decrement(1);
			}
			return ActionResult.SUCCESS;
		} return ActionResult.FAIL;
	}
}