package com.factions.grace.listeners;

import com.factions.grace.GracePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onExploseTnT(ExplosionPrimeEvent event) {
        if (GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable"))
            event.setCancelled(true);
    }
}
