package me.okx.morespigotevents.events;

import me.okx.morespigotevents.util.ClientSettings;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerSettingsUpdateEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private ClientSettings settings;

    public PlayerSettingsUpdateEvent(Player who, ClientSettings settings) {
        super(who);
        this.settings = settings;
    }

    public ClientSettings getSettings() {
        return settings;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
