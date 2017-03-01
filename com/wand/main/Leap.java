package com.wand.main;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class Leap implements Listener {

	public Main plugin;
	
	public Leap(Main instance) {
		this.plugin = instance;
	}
	
    public void onCast(final Player p) {
        Location Explosion = p.getLocation();
        Vector vector = new Vector();
        double rotX = Explosion.getYaw();
        double rotY = -40.0;
        vector.setY(- Math.sin(Math.toRadians(rotY)));
        double h = Math.cos(Math.toRadians(rotY));
        vector.setX((- h) * Math.sin(Math.toRadians(rotX)));
        vector.setZ(h * Math.cos(Math.toRadians(rotX)));
        p.setVelocity(vector.multiply(3));
        p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10.0f, 1.0f);
        new BukkitRunnable(){
            public int timer;

            public void run() {
                p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 0);
                p.setFallDistance(-1.0E7f);
                if (p.getLocation().add(0.0, -1.0, 0.0).getBlock().getType() != Material.AIR) {
                    this.cancel();
                    return;
                }
                if (this.timer++ > 150) {
                    this.cancel();
                }
            }
        }.runTaskTimer(this.plugin, 8, 1);
    }

}
	

