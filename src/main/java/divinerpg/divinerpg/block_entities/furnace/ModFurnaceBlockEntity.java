package divinerpg.divinerpg.block_entities.furnace;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.*;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.block.entity.AbstractFurnaceBlockEntity.canUseAsFuel;
import static net.minecraft.block.entity.AbstractFurnaceBlockEntity.createFuelTimeMap;

public abstract class ModFurnaceBlockEntity extends LockableContainerBlockEntity implements SidedInventory, RecipeUnlocker, RecipeInputProvider {
    private static final int[] SLOTS_FOR_UP = new int[]{0}, SLOTS_FOR_DOWN = new int[]{2, 1}, SLOTS_FOR_SIDES = new int[]{1};
    public final RecipeManager.MatchGetter<Inventory, ? extends AbstractCookingRecipe> matchGetter = RecipeManager.createCachedMatchGetter(RecipeType.SMELTING);
    private final Object2IntOpenHashMap<Identifier> recipesUsed = new Object2IntOpenHashMap<>();
    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public final String containerName;
    public final double speed;

    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal;
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        public int get(int index) {
            return switch (index) {
                case 0 -> ModFurnaceBlockEntity.this.burnTime;
                case 1 -> ModFurnaceBlockEntity.this.fuelTime;
                case 2 -> ModFurnaceBlockEntity.this.cookTime;
                case 3 -> ModFurnaceBlockEntity.this.cookTimeTotal;
                default -> 0;
            };
        }
        public void set(int index, int value) {
            switch (index) {
                case 0 -> ModFurnaceBlockEntity.this.burnTime = value;
                case 1 -> ModFurnaceBlockEntity.this.fuelTime = value;
                case 2 -> ModFurnaceBlockEntity.this.cookTime = value;
                case 3 -> ModFurnaceBlockEntity.this.cookTimeTotal = value;
            }
        }
        public int size() { return 4; }
    };

    public ModFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, String containerName, double speed) {
        super(type, pos, state);
        this.containerName = containerName;
        this.speed = speed;
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable(containerName);
    }

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) return 0;
        else return (int) Math.round(createFuelTimeMap().getOrDefault(fuel.getItem(), 0) / speed);
    }

    private static int getCookTime(World world, ModFurnaceBlockEntity furnace) {
        return (int) Math.round(furnace.matchGetter.getFirstMatch(furnace, world).map(AbstractCookingRecipe::getCookTime).orElse(200) / furnace.speed);
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readNbt(nbt, this.inventory);
        this.burnTime = nbt.getShort("BurnTime");
        this.cookTime = nbt.getShort("CookTime");
        this.cookTimeTotal = nbt.getShort("CookTimeTotal");
        this.fuelTime = this.getFuelTime(this.inventory.get(1));
        NbtCompound nbtCompound = nbt.getCompound("RecipesUsed");

        for (String string : nbtCompound.getKeys()) {
            this.recipesUsed.put(new Identifier(string), nbtCompound.getInt(string));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putShort("BurnTime", (short) this.burnTime);
        nbt.putShort("CookTime", (short) this.cookTime);
        nbt.putShort("CookTimeTotal", (short) this.cookTimeTotal);
        Inventories.writeNbt(nbt, this.inventory);
        NbtCompound nbtCompound = new NbtCompound();
        this.recipesUsed.forEach((identifier, count) -> nbtCompound.putInt(identifier.toString(), count));
        nbt.put("RecipesUsed", nbtCompound);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ModFurnaceBlockEntity blockEntity) {
        boolean flag = blockEntity.isBurning();
        boolean flag2 = false;

        if (blockEntity.isBurning())
            --blockEntity.burnTime;

        ItemStack itemStack = blockEntity.inventory.get(1);
        boolean flag3 = !blockEntity.inventory.get(0).isEmpty();
        boolean flag4 = !itemStack.isEmpty();
        if (blockEntity.isBurning() || flag4 && flag3) {
            Recipe<?> recipe;
            if (flag3) recipe = blockEntity.matchGetter.getFirstMatch(blockEntity, world).orElse(null);
            else recipe = null;

            int maxStackSize = blockEntity.getMaxCountPerStack();
            if (!blockEntity.isBurning() && canAcceptRecipeOutput(world.getRegistryManager(), recipe, blockEntity.inventory, maxStackSize)) {
                blockEntity.burnTime = blockEntity.getFuelTime(itemStack);
                blockEntity.fuelTime = blockEntity.burnTime;
                if (blockEntity.isBurning()) {
                    flag2 = true;
                    if (flag4) {
                        Item item = itemStack.getItem();
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            Item item2 = item.getRecipeRemainder();
                            blockEntity.inventory.set(1, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                        }
                    }
                }
            }

            if (blockEntity.isBurning() && canAcceptRecipeOutput(world.getRegistryManager(), recipe, blockEntity.inventory, maxStackSize)) {
                ++blockEntity.cookTime;
                if (blockEntity.cookTime == blockEntity.cookTimeTotal) {
                    blockEntity.cookTime = 0;
                    blockEntity.cookTimeTotal = getCookTime(world, blockEntity);
                    if (craftRecipe(world.getRegistryManager(), recipe, blockEntity.inventory, maxStackSize))
                        blockEntity.setLastRecipe(recipe);

                    flag2 = true;
                }
            } else {
                blockEntity.cookTime = 0;
            }
        } else if (!blockEntity.isBurning() && blockEntity.cookTime > 0)
            blockEntity.cookTime = MathHelper.clamp(blockEntity.cookTime - 2, 0, blockEntity.cookTimeTotal);

        if (flag != blockEntity.isBurning()) {
            flag2 = true;
            state = state.with(AbstractFurnaceBlock.LIT, blockEntity.isBurning());
            world.setBlockState(pos, state, 3);
        }

        if (flag2) markDirty(world, pos, state);
    }

    private static boolean canAcceptRecipeOutput(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe, DefaultedList<ItemStack> inventory, int maxStackSize) {
        if(!inventory.getFirst().isEmpty() && recipe != null) {
            ItemStack itemStack = recipe.getOutput(registryManager);
            if (itemStack.isEmpty()) return false;
            else {
                ItemStack itemStack2 = inventory.get(2);
                if (itemStack2.isEmpty()) return true;
                else if (!ItemStack.areItemsEqual(itemStack2, itemStack)) return false;
                else return (itemStack2.getCount() < maxStackSize && itemStack2.getCount() < itemStack2.getMaxCount()) || itemStack2.getCount() < itemStack.getMaxCount();
            }
        } else return false;
    }

    private static boolean craftRecipe(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe, DefaultedList<ItemStack> inventory, int maxStackSize) {
        if (recipe != null && canAcceptRecipeOutput(registryManager, recipe, inventory, maxStackSize)) {
            ItemStack itemStack = inventory.get(0);
            ItemStack itemStack2 = recipe.getOutput(registryManager);
            ItemStack itemStack3 = inventory.get(2);
            if(itemStack3.isEmpty())
                inventory.set(2, itemStack2.copy());
            else if (itemStack3.isOf(itemStack2.getItem()))
                itemStack3.increment(1);

            if (itemStack.isOf(Blocks.WET_SPONGE.asItem()) && !inventory.get(1).isEmpty() && inventory.get(1).isOf(Items.BUCKET))
                inventory.set(1, new ItemStack(Items.WATER_BUCKET));

            itemStack.decrement(1);
            return true;
        } else return false;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) return SLOTS_FOR_DOWN;
        else return side == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return this.isValid(slot, stack);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return dir != Direction.DOWN || slot != 1 || stack.isOf(Items.WATER_BUCKET) || stack.isOf(Items.BUCKET);
    }

    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : this.inventory)
            if (!itemStack.isEmpty()) return false;
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(this.inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ItemStack itemStack = this.inventory.get(slot);
        boolean flag = !stack.isEmpty() && ItemStack.canCombine(stack, itemStack);
        this.inventory.set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack())
            stack.setCount(this.getMaxCountPerStack());
        if (slot == 0 && !flag) {
            this.cookTimeTotal = getCookTime(this.world, this);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse(this, player);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (slot == 2)
            return false;
        else if (slot != 1)
            return true;
        else {
            ItemStack itemStack = this.inventory.get(1);
            return canUseAsFuel(stack) || stack.isOf(Items.BUCKET) && !itemStack.isOf(Items.BUCKET);
        }
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    @Override
    public void setLastRecipe(@Nullable Recipe<?> recipe) {
        if (recipe != null) this.recipesUsed.addTo(recipe.getId(), 1);
    }

    @Override
    @Nullable
    public Recipe<?> getLastRecipe() {
        return null;
    }

    @Override
    public void unlockLastRecipe(PlayerEntity player, List<ItemStack> ingredients) {}

    public void dropExperienceForRecipesUsed(ServerPlayerEntity player) {
        List<Recipe<?>> list = getRecipesUsedAndDropExperience(player.getServerWorld(), player.getPos());
        player.unlockRecipes(list);

        for (Recipe<?> recipe : list)
            if (recipe != null)
                player.onRecipeCrafted(recipe, this.inventory);

        this.recipesUsed.clear();
    }

    public List<Recipe<?>> getRecipesUsedAndDropExperience(ServerWorld world, Vec3d position) {
        List<Recipe<?>> list = Lists.newArrayList();

        for (Entry<Identifier> entry : this.recipesUsed.object2IntEntrySet()) {
            world.getRecipeManager().get(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                dropExperience(world, position, entry.getIntValue(), ((AbstractCookingRecipe) recipe).getExperience());
            });
        }

        return list;
    }

    private static void dropExperience(ServerWorld world, Vec3d pos, int multiplier, float experience) {
        int i = MathHelper.floor(multiplier * experience);
        float f = MathHelper.fractionalPart(multiplier * experience);
        if (f != 0.0F && Math.random() < f) {
            i++;
        }

        ExperienceOrbEntity.spawn(world, pos, i);
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {
        for (ItemStack itemStack : this.inventory) {
            finder.addInput(itemStack);
        }
    }
}