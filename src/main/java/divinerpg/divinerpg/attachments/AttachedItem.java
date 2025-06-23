package divinerpg.attachments;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

public class AttachedItem implements INBTSerializable<CompoundTag> {
    public static final StreamCodec<ByteBuf, AttachedItem> CODEC = new StreamCodec<ByteBuf, AttachedItem>() {
        public AttachedItem decode(ByteBuf buf) {return new AttachedItem(Item.byId(buf.readInt()).getDefaultInstance());}
        public void encode(ByteBuf buf, AttachedItem item) {buf.writeInt(Item.getId(item.item.getItem()));}
    };
    public ItemStack item = ItemStack.EMPTY;
    public AttachedItem() {}
    public AttachedItem(ItemStack item){
        this.item = item;
    }
    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.put("item", item.save(provider));
        return tag;
    }
    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {
        item = ItemStack.parse(provider, compoundTag.get("item")).orElse(ItemStack.EMPTY);
    }
}