package com.wand.main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class KingdomWands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
	    	p.sendMessage(ChatColor.YELLOW + "=============================================");
	    	p.sendMessage(ChatColor.YELLOW + "Kies uit " + ChatColor.RED + "/kw wand");
	    	p.sendMessage(ChatColor.YELLOW + "Kies uit " + ChatColor.RED + "/kw bloedwand");
	    	p.sendMessage(ChatColor.YELLOW + "=============================================");
	    }
	
			if(!(sender instanceof Player)) {
				sender.sendMessage("Je moet een speler zijn!");
			} else {
	    if(args[0].equalsIgnoreCase("wand")) {
	    	if(sender.hasPermission("kw.wand")) {
	    	ItemStack stack = new ItemStack(Material.BLAZE_ROD);
	    	ItemMeta stackMeta = stack.getItemMeta();
	    	stackMeta.setDisplayName(ChatColor.RED + "Empire Wand");
	    	stack.setItemMeta(stackMeta);
	    	ChatUtilities.sendMessage(p, ChatColor.RED + "Je hebt nu de Empire wand!");
	    	p.getInventory().addItem(stack);
	    	} else {
	    		sender.sendMessage(ChatColor.RED + "Je hebt geen permissies!");
	    	}
	    	
		
		return false;
			}

}
			return false;
	}
}
