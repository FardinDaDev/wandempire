package com.wand.main;

import java.util.HashSet;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Spark implements Listener {

	private Main plugin;
	
	public Spark(Main instance) {
		this.plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	public void onCast(Player p) {
		Location loc = p.getTargetBlock(((HashSet<Byte>)null), 50).getLocation();
		try {
		InstantFirework.createFireworkEffect(loc, FireworkEffect.builder().with(Type.BURST).withColor(Color.GREEN).withFade(Color.AQUA).flicker(true).trail(false).build());
		
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	for(Entity e : this.plugin.getTargets.getTargetList(p, loc, 3)) {
		if(e instanceof LivingEntity) {
			((LivingEntity)e).damage(5);
		}
	}
}
}