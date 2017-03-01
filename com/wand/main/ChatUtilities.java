package com.wand.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ChatUtilities {
	
	public static void sendMessage(Player p, String msg) {
		p.sendMessage(prefix() + msg);
	
	}
	
	public static String prefix() {
		return ChatColor.GOLD + "[" + ChatColor.GRAY + "X" + ChatColor.GOLD + "] " + ChatColor.GRAY;
	}
	
}
