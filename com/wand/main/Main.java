package com.wand.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;
    public List<String> spells = new ArrayList<String>();
    public getTargets getTargets = new getTargets();
    public ExplosionWave explosionwave = new ExplosionWave(this);
    public Spark spark = new Spark(this);
    public PotionWave potionwave = new PotionWave(this);
    public Leap leap = new Leap(this);
    public FlyingCloud flyingcloud = new FlyingCloud(this);
    public List<String> cloud = new ArrayList<String>();
    
	@Override
	public void onEnable() {
		plugin = this;
		shit();
		getServer().getPluginManager().registerEvents(this, this);
		spells.add("Spark");
		spells.add("ExplosionWave");
		spells.add("PotionWave");
		spells.add("Leap");
		spells.add("FlyingCloud");
	}
	

	private void shit() {
		//Commands
		getCommand("kw").setExecutor(new KingdomWands());
	
	}


	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			ItemStack stack = p.getItemInHand();
			if(stack != null && stack.getType() == Material.BLAZE_ROD && stack.hasItemMeta() && stack.getItemMeta().getDisplayName().equals("§cEmpire Wand")) {
				int SpellSelected = stack.getDurability();
				if(SpellSelected < 4) {
					stack.setDurability((short) (SpellSelected + 1));
					p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 119, 30);
				} else {
					stack.setDurability((short) 0);
				}
				ChatUtilities.sendMessage(p, "§6Geselecteerd§7: §7" + spells.get(SpellSelected) + "§6.");
			}
		}
			if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				Player p = e.getPlayer();
				ItemStack stack = p.getItemInHand();
				if(stack != null && stack.getType() == Material.BLAZE_ROD && stack.hasItemMeta() && stack.getItemMeta().getDisplayName().equals("§cEmpire Wand")) {
					int SpellSelected = stack.getDurability();
					if(SpellSelected == 2) {
						this.explosionwave.onCast(p);
					} else if (SpellSelected == 1) {
						this.spark.onCast(p);
					} else if (SpellSelected == 0) {
						this.flyingcloud.onCast(p);
					} else if (SpellSelected == 3) {
						this.potionwave.onCast(p);
					} else if (SpellSelected == 4) {
						this.leap.onCast(p);
					}
				}
				
			
			           
			}
}



	}

