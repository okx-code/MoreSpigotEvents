package me.okx.morespigotevents.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import me.okx.morespigotevents.events.PlayerSettingsUpdateEvent;
import me.okx.morespigotevents.util.ClientSettings;
import net.minecraft.server.v1_12_R1.EnumMainHand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PlayerSettingsUpdateEventListener extends PacketAdapter {
    public PlayerSettingsUpdateEventListener(Plugin plugin) {
        super(plugin, ListenerPriority.NORMAL, PacketType.Play.Client.SETTINGS);
        this.plugin = plugin;
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        PacketContainer packet = event.getPacket();
        String locale = packet.getStrings().read(0);
        int viewDistance = packet.getIntegers().read(0);
        EnumWrappers.ChatVisibility chatVisibility = packet.getChatVisibilities().read(0);
        boolean colours = packet.getBooleans().read(0);
        ClientSettings.SkinParts skinParts = new ClientSettings.SkinParts(packet.getIntegers().read(1));
        EnumMainHand hand = packet.getEnumModifier(EnumMainHand.class, 5).read(0);
        PlayerSettingsUpdateEvent settingsUpdateEvent = new PlayerSettingsUpdateEvent(event.getPlayer(),
                new ClientSettings(locale, viewDistance, chatVisibility, colours, skinParts, hand));
        Bukkit.getPluginManager().callEvent(settingsUpdateEvent);
    }
}
