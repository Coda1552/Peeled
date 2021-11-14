package coda.peeled;

import com.minecraftabnormals.neapolitan.common.entity.BananaPeelEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod(Peeled.MOD_ID)
public class Peeled {
    public static final String MOD_ID = "peeled";

    public Peeled() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        PeeledSounds.SOUNDS.register(bus);

        forgeBus.addListener(this::onBananaPushed);
    }

    private void onBananaPushed(EntityEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            List<BananaPeelEntity> list = player.level.getEntitiesOfClass(BananaPeelEntity.class, player.getBoundingBox());

            if (!list.isEmpty() && entity.tickCount % 5 == 0) {
                player.level.playLocalSound(list.get(0).getX(), list.get(0).getY(), list.get(0).getZ(), PeeledSounds.SLIP.get(), SoundCategory.PLAYERS, 1.0F, 1.0F, true);
            }
        }
    }
}
