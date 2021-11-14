package coda.peeled;

import coda.peeled.Peeled;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PeeledSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Peeled.MOD_ID);

    public static final RegistryObject<SoundEvent> SLIP = SOUNDS.register("slip", () -> new SoundEvent(new ResourceLocation(Peeled.MOD_ID, "slip")));
}
