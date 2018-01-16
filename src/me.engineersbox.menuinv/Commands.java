package me.engineersbox.menuinv;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("blockpalette")) {
			
			ItemStack bp = new ItemStack(Material.BLAZE_POWDER);
			ItemMeta im = bp.getItemMeta();
			im.setDisplayName(ChatColor.DARK_AQUA + "Block Palette");
			bp.setItemMeta(im);
			
			Player player = (Player) sender;
			PlayerInventory inventory = player.getInventory();
			inventory.addItem(new ItemStack(bp));
			return true;
		}
		
		return false;
	}
	
}
