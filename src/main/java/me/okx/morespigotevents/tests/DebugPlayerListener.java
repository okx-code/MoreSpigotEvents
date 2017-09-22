package me.okx.morespigotevents.tests;

import me.okx.morespigotevents.events.*;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class DebugPlayerListener implements Listener {
    @EventHandler
    public void on(PlayerCameraChangeEvent e) {
        Bukkit.broadcastMessage(e.getPlayer().getName() + " -> " + e.getCamera().getName());
        e.setCancelled(true);
    }

    @EventHandler
    public void on(PlayerListUpdateEvent e) {
        e.getPlayer().sendMessage("Footer:");
        e.getPlayer().spigot().sendMessage(e.getFooter());
        e.setCancelled(true);
    }

    @EventHandler
    public void on(PlayerSettingsUpdateEvent e) {
        Bukkit.broadcastMessage(e.getPlayer().getName() + " hat " + e.getSettings().getSkinParts().isHat());
    }

    @EventHandler
    public void on(PlayerOpenSignEditorEvent e) {
        Bukkit.broadcastMessage(e.getPlayer().getName() + " opened the sign editor");
        e.setCancelled(true);
    }

    @EventHandler
    public void on(PlayerElderGuardianEffectEvent e) {
        Bukkit.broadcastMessage("elder guardian effect");
        e.setCancelled(true);
    }

    @EventHandler
    public void on(PlayerReceiveStatisticsEvent e) {
        Bukkit.broadcastMessage(e.getStatistic("stat.walkOneCm") + "");
    }

    @EventHandler
    public void on(PlayerReceiveMessageEvent e) {
        System.out.println(e.toPlainText() + " type: " + e.getType().name() + " -> " + e.getPlayer().getName());
    }
}
