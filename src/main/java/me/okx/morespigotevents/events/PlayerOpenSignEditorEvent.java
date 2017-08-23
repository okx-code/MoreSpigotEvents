package me.okx.morespigotevents.events;

import com.comphenix.protocol.wrappers.ChunkPosition;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerOpenSignEditorEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();

    private ChunkPosition position;

    /**
     * Fired when a player opens a sign for editing
     * @param who The player who opens the sign editor
     * @param position The position at which the event happened
     */
    public PlayerOpenSignEditorEvent(Player who, ChunkPosition position) {
        super(who);
        this.position = position;
    }

    /**
     * Returns the position at which the event happened
     * @return The position at which the event happened
     */
    public ChunkPosition getPosition() {
        return position;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
