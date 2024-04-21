package com.factions.grace.listeners;

import com.factions.grace.GracePlugin;
import com.massivecraft.factions.event.EventFactionsEnteredInAttack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FactionListener implements Listener {
    @EventHandler
    public void onFactionEnteredAttack(EventFactionsEnteredInAttack event) {
        if (GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable"))
            event.setCancelled(true);
    }
}
