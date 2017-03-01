package com.wand.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class FlyingCloud implements Listener {

	public Main plugin;
	
	public FlyingCloud(Main instance) {
		this.plugin = instance;
	}
	
	
    public void onCast(Player p) {
        if (Main.plugin.cloud.contains(p.getName())) {
            Main.plugin.cloud.remove(p.getName());
            ChatUtilities.sendMessage(p, "Cloud stopped!");
            if (p.getGameMode() != GameMode.CREATIVE) {
                p.setAllowFlight(false);
            }
        } else {
            Main.plugin.cloud.add(p.getName());
            ChatUtilities.sendMessage(p, "Cloud started!");
            if (p.getGameMode() != GameMode.CREATIVE) {
                p.setAllowFlight(true);
            }
        }
        
        
    }
}

