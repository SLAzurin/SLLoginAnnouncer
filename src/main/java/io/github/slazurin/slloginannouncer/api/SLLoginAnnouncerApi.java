package io.github.slazurin.slloginannouncer.api;

import io.github.slazurin.slloginannouncer.SLLoginAnnouncer;
import java.util.ArrayList;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

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
            "<NAME>! <NAME>! <NAME>! <NAME>!",
            "<NAME> has connected.",
            "<NAME> has returned, once again!"
        };
    }
    
    public String getRandomLoginMessage() {
        return this.loginMessages[(int) (Math.random() * this.loginMessages.length)];
    }
    
    public String getLogoutMessage(Player p) {
        return ChatColor.BLUE.toString() + ChatColor.ITALIC + "--" + p.getName() + " has left the game--";
    }    
    public void broadcastLoginNotes() {
        List<Player> players = new ArrayList(Bukkit.getOnlinePlayers());
        int tickInterval = 6;
        int currentTick = 0;
        
        for (Player p : players) {
            p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.natural(1, Note.Tone.F));
        }
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.C));
            }
        }, (long) (currentTick += tickInterval));
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.D));
            }
        }, (long) (currentTick += tickInterval));
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(0, Note.Tone.G));
            }
        }, (long) (currentTick += tickInterval));
        
        // 2nd half
        currentTick += tickInterval*2;
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(0, Note.Tone.G));
            }
        }, (long) (currentTick += tickInterval));
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.D));
            }
        }, (long) (currentTick += tickInterval));
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.natural(1, Note.Tone.F));
            }
        }, (long) (currentTick += tickInterval));
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.CHIME, Note.sharp(1, Note.Tone.C));
            }
        }, (long) (currentTick += tickInterval));
        
    }
    
    public void broadcastLogoutNotes() {
        List<Player> players = new ArrayList(Bukkit.getOnlinePlayers());
        int tickInterval = 6;
        int currentTick = 0;
        
        
        for (Player p : players) {
            p.playNote(p.getEyeLocation(), Instrument.GUITAR, Note.natural(1, Note.Tone.C));
        }
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.GUITAR, Note.natural(1, Note.Tone.G));
            }
        }, (long) (currentTick += tickInterval));
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.GUITAR, Note.natural(0, Note.Tone.E));
            }
        }, (long) (currentTick += tickInterval));
        
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
            for (Player p : players) {
                p.playNote(p.getEyeLocation(), Instrument.GUITAR, Note.natural(0, Note.Tone.C));
            }
        }, (long) (currentTick += tickInterval));
    }
    
    public boolean isVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
    }
}
