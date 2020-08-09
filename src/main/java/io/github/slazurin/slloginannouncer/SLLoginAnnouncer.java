package io.github.slazurin.slloginannouncer;

import io.github.slazurin.slloginannouncer.api.SLLoginAnnouncerApi;
import io.github.slazurin.slloginannouncer.listeners.PlayerJoinListener;
import io.github.slazurin.slloginannouncer.listeners.PlayerLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SLLoginAnnouncer extends JavaPlugin {
    private SLLoginAnnouncerApi api;
    @Override
    public void onEnable() {
        registerListeners();
        this.api = new SLLoginAnnouncerApi(this);
    }
    
    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(this), this);
    }

    public SLLoginAnnouncerApi getApi() {
        return api;
    }
    
}
