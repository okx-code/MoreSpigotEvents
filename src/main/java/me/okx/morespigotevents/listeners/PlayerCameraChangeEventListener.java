package me.okx.morespigotevents.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.*;
import me.okx.morespigotevents.events.PlayerCameraChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class PlayerCameraChangeEventListener extends PacketAdapter {
    private Plugin plugin;

    public PlayerCameraChangeEventListener(Plugin plugin) {
        super(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.CAMERA);
        this.plugin = plugin;
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        int entityId = event.getPacket().getIntegers().read(0);
        Entity entity = null;
        Player player = event.getPlayer();

        for(Entity entityWorld : player.getWorld().getEntities()) {
            if(entityWorld.getEntityId() == entityId) {
                entity = entityWorld;
                break;
            }
        }

        if(entity == null) {
            return;
        }

        PlayerCameraChangeEvent cameraEvent = new PlayerCameraChangeEvent(event.getPlayer(), entity);
        Bukkit.getPluginManager().callEvent(cameraEvent);
        if(cameraEvent.isCancelled()) {
            // Simply cancelling the packet seems to make the server think they are still
            // spectating the entity but the client will be able to move freely, and
            // when the client presses shift or an alternate keybind the server will
            // take the client out of spectating the entity, and teleport them on top of it.
            Bukkit.getScheduler().runTask(plugin, () -> player.setSpectatorTarget(null));
        }
    }
}
