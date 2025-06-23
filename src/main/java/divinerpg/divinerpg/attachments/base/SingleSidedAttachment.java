package divinerpg.attachments.base;

import com.mojang.serialization.Codec;
import divinerpg.registries.AttachmentRegistry;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class SingleSidedAttachment<T> extends ModAttachment<T> {
    public final boolean clientSide;
    public SingleSidedAttachment(String name, Supplier<T> defaultValue, Codec<T> codec, boolean clientSide) {
        super(name, defaultValue, codec);
       this.clientSide = clientSide;
    }
    protected SingleSidedAttachment(DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment, boolean clientSide) {
        super(attachment);
        this.clientSide = clientSide;
    }
    @Override
    public boolean validate(Entity e, T data) {
        if(clientSide ^ e.level().isClientSide()) throw new UnsupportedOperationException((clientSide ? "Client" : "Server") + " sided Data only!");
        return super.validate(e, data);
    }
    @Override public void update(Entity e, T data) {}
    @Override @Deprecated
    public void setSilent(Entity e, T data) {
        throw new UnsupportedOperationException("Use standard setter instead!");
    }
    public T get(Entity e) {
        validate(e, null);
        return e.getData(attachment);
    }
    @Override
    public T getOrDefault(Entity e, T defaultValue) {
        validate(e, defaultValue);
        return super.getOrDefault(e, defaultValue);
    }
    public static class Serializable<B extends Tag, S extends INBTSerializable<B>> extends SingleSidedAttachment<S> {
        public Serializable(String name, Supplier<S> defaultValue, boolean clientSide) {
            super(AttachmentRegistry.ATTACHMENT_TYPES.register(name, () -> AttachmentType.serializable(defaultValue).build()), clientSide);
        }
    }
}