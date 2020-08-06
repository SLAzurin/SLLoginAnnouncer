package io.github.slazurin.slloginannouncer.api;

import io.github.slazurin.slloginannouncer.SLLoginAnnouncer;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;

public class SLLoginAnnouncerApi {
    private final String[] loginMessages;
    private final SLLoginAnnouncer plugin;
    
    public SLLoginAnnouncerApi(SLLoginAnnouncer plugin) {
        this.plugin = plugin;
        this.loginMessages = new String[]{
            "GUESS WHO'S HERE?! <NAME> IS HERE!",
            "~\\o/ <NAME> has joined the partaaay! WoOHoO!! \\o/~",
            "<NAME> has arrived! Quick, PINATA TIME!!",
            "Quick, hide! <NAME> has appeared!! EEK >A<!!",
            "<NAME> has joined the game. Yep, That's it.",
            "Oh wow- It's <NAME>! HELLO <NAME>!!",
            "Welcome back, <NAME>!",
            "<NAME>! <NAME>! <NAME>! <NAME>!"
        };
    }
    
    public String getRandomLoginMessage() {
        return this.loginMessages[(int) (Math.random() * this.loginMessages.length)];
    }
    
    public void broadcastLoginNotes() {
        List<Player> players = new ArrayList(Bukkit.getOnlinePlayers());
        
        for (Player p : players) {
            p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.natural(1, Note.Tone.F));
        }
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.C));
            }
        }, (long) 10);
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.D));
            }
        }, (long) 20);
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(0, Note.Tone.G));
            }
        }, (long) 30);
        
        // 2nd half
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(0, Note.Tone.G));
            }
        }, (long) 60);
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.D));
            }
        }, (long) 70);
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.natural(1, Note.Tone.F));
            }
        }, (long) 80);
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.C));
            }
        }, (long) 90);
        
    }
}
