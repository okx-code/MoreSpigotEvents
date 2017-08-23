package me.okx.morespigotevents;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.okx.morespigotevents.listeners.PlayerCameraChangeEventListener;
import me.okx.morespigotevents.listeners.PlayerListUpdateEventListener;
import me.okx.morespigotevents.listeners.PlayerOpenSignEditorEventListener;
import me.okx.morespigotevents.listeners.PlayerSettingsUpdateEventListener;
import me.okx.morespigotevents.tests.DebugPlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MoreSpigotEvents extends JavaPlugin {
    @Override
    public void onEnable() {
        registerListeners();
        //registerDebugListeners();
    }

    private void registerListeners() {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

        protocolManager.addPacketListener(new PlayerCameraChangeEventListener(this));
        protocolManager.addPacketListener(new PlayerSettingsUpdateEventListener(this));
        protocolManager.addPacketListener(new PlayerListUpdateEventListener(this));
        protocolManager.addPacketListener(new PlayerOpenSignEditorEventListener(this));
    }

    private void registerDebugListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new DebugPlayerListener(), this);
    }
}
