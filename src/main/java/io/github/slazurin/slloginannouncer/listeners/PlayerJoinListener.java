package io.github.slazurin.slloginannouncer.listeners;

import io.github.slazurin.slloginannouncer.SLLoginAnnouncer;
import io.github.slazurin.slloginannouncer.utils.RainbowText;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final SLLoginAnnouncer plugin;
    
    public PlayerJoinListener(SLLoginAnnouncer plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        RainbowText rt = new RainbowText(this.plugin.getApi().getRandomLoginMessage().replaceAll("<NAME>", e.getPlayer().getName()));
        rt.setOffset((int) (Math.random() * 12));
        e.setJoinMessage(rt.getRainbowText());
        broadcastPlayNotes();
    }

    private void broadcastPlayNotes() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.E));
        }
        
        try {
            Thread.sleep(750);
        }   catch (InterruptedException ie) {
            //do nothing, nothing can be done anyway
        }
        
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.C));
        }
        
    }
    
}
