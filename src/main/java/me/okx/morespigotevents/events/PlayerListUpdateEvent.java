package me.okx.morespigotevents.events;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerListUpdateEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private BaseComponent[] header;
    private BaseComponent[] footer;

    /**
     * Fired when the server sends {@code who} the player list header & footer
     * This will never fire on a vanilla server
     * @param who The receipient of the player list header & footer packet
     * @param header
     * @param footer
     */
    public PlayerListUpdateEvent(Player who, BaseComponent[] header, BaseComponent[] footer) {
        super(who);
        this.header = header;
        this.footer = footer;
    }

    /**
     * Returns the player list header for this player
     * @return The player list header for this player
     */
    public BaseComponent[] getHeader() {
        return header;
    }

    /**
     * Returns the player list footer for this player
     * @return The player list footer for this player
     */
    public BaseComponent[] getFooter() {
        return footer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
