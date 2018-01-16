package me.engineersbox.menuinv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class MenuInv extends JavaPlugin implements Listener {

	public static Inventory BiomePalette;
	
	public void onEnable() {
		BiomePalette = Bukkit.createInventory(null, 9, "Biome Palette");
		getServer().getPluginManager().registerEvents(this,  this);
		
		ItemStack leaves = new ItemStack(Material.LEAVES);
		ItemMeta im = leaves.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "");
		List<String> loreList = new ArrayList<String>();
		loreList.add(ChatColor.GREEN + "Forest");
		loreList.add(ChatColor.YELLOW + "Biome Palette");
		im.setLore(loreList);
		leaves.setItemMeta(im);
		
		im.setLore(Arrays.asList(ChatColor.YELLOW + "Open The ", ChatColor.GREEN + "Forest ", ChatColor.YELLOW + "Biome Palette"));
		
		ItemStack stone = new ItemStack(Material.STONE);
		
		BiomePalette.addItem(leaves, stone);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("openInv")) {
			if (sender instanceof Player) {
				((Player)sender).openInventory(BiomePalette);
				BiomePalette.clear();
				BiomePalette.addItem(new ItemStack(Material.DIAMOND));
			}
		}
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(event.getInventory() == BiomePalette) {
			if(event.getCurrentItem().getType() == Material.DIAMOND) {
				event.setCancelled(true);
				event.getWhoClicked().getInventory().addItem(new ItemStack(Material.APPLE));
			}
		}
		if (!event.getInventory().getName().equalsIgnoreCase(BiomePalette.getName())) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Forest")) {
                event.setCancelled(true);
                event.getWhoClicked().closeInventory();
        }
	}
     
     @SuppressWarnings("deprecation")
		@EventHandler
 	public void onPlayerUse(PlayerInteractEvent event){
 	    Player p = event.getPlayer();
 	 
 	    if(p.getItemInHand().getType() == Material.BLAZE_POWDER){
 	    	event.getPlayer().openInventory(BiomePalette);
 	    }
 	}
}
