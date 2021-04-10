package io.github.slazurin.slloginannouncer.listeners;

import io.github.slazurin.slloginannouncer.SLLoginAnnouncer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {
    private final SLLoginAnnouncer plugin;
    
    public PlayerLeaveListener(SLLoginAnnouncer plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (this.plugin.getApi().isVanished(e.getPlayer())) {
            e.quitMessage(null);
            return;
        }
        String message = ChatColor.BLUE.toString() + ChatColor.ITALIC + "--" + e.getPlayer().getName() + " has left the game--";
        e.quitMessage(net.kyori.adventure.text.Component.text(message));
        this.plugin.getApi().broadcastLogoutNotes();
    }
}
