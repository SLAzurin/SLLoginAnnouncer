package io.github.slazurin.slloginannouncer.listeners;

import io.github.slazurin.slloginannouncer.SLLoginAnnouncer;
import io.github.slazurin.slloginannouncer.utils.RainbowText;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final SLLoginAnnouncer plugin;
    
    public PlayerJoinListener(SLLoginAnnouncer plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (this.plugin.getApi().isVanished(e.getPlayer())) {
            e.setJoinMessage(null);
            return;
        }
        RainbowText rt = new RainbowText(this.plugin.getApi().getRandomLoginMessage().replaceAll("<NAME>", e.getPlayer().getName()));
        rt.setOffset((int) (Math.random() * 12));
        e.setJoinMessage(rt.getRainbowText());
        this.plugin.getApi().broadcastLoginNotes();
    }
}
