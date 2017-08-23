package me.okx.morespigotevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerElderGuardianEffectEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();

    /**
     * Fired when a player is inflicted with mining fatigue from an elder guardian.
     * @param who The player receiving the elder guardian effect.
     */
    public PlayerElderGuardianEffectEvent(Player who) {
        super(who);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
