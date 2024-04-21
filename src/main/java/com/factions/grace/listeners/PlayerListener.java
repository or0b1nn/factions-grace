package com.factions.grace.listeners;

import com.factions.grace.GracePlugin;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {
    @EventHandler
    public void onExploseTnT(ExplosionPrimeEvent event) {
        if (GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable")) {
            if (event.getBlockPlaced().getType() == Material.TNT) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cNao pode colocar TNT's durante o grace");
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (GracePlugin.getInstance().getConfig().getBoolean("settings.grace-enable")) {
            ItemStack itemStack = event.getItem();

            if (itemStack.getType() == Material.MONSTER_EGG) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cNao pode spawnar ovos durante o grace");
            }
        }
    }
}
