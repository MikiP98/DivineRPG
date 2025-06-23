package divinerpg.attachments.base;

import com.mojang.serialization.Codec;
import divinerpg.registries.AttachmentRegistry;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public abstract class ModAttachment<T> {
    public final DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment;
    public ModAttachment(DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment) {
        this.attachment = attachment;
    }
    public ModAttachment(String name, Supplier<T> defaultValue, Codec<T> codec) {
        attachment = AttachmentRegistry.ATTACHMENT_TYPES.register(name, () -> AttachmentType.builder(defaultValue).serialize(codec).build());
    }
    public abstract void update(Entity e, T data);
    public boolean validate(Entity e, T data) {
        return !e.getData(attachment).equals(data);
    }
    public void set(Entity e, T data) {
        if(validate(e, data)) {
            e.setData(attachment, data);
            update(e, data);
        }
    }
    public void setSilent(Entity e, T data) {
        if(validate(e, data)) e.setData(attachment, data);
    }
    public T get(Entity e) {
        return e.getData(attachment);
    }
    public T getOrDefault(Entity e, T defaultValue) {
        return e.hasData(attachment) ? e.getData(attachment) : defaultValue;
    }
    public boolean has(Entity e) {
        return e.hasData(attachment);
    }
    public void clone(Entity original, Entity clone) {
        if(original.hasData(attachment)) set(clone, original.getData(attachment));
    }
}