package me.engineersbox.menuinv;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin implements Listener {

	
	
	public static Inventory BiomePalette;
	
	
	public void onEnable() {
		
		this.getLogger().info("BlockPalette Enabled");
		
		getCommand("blockpalette").setExecutor(new Commands());
		
		BiomePalette = Bukkit.createInventory(null, 9, "Biome Block Palette");
		getServer().getPluginManager().registerEvents(this, this);
		
		ItemStack leaves = new ItemStack(Material.LEAVES);
		ItemMeta im = leaves.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "");
		List<String> loreList = new ArrayList<String>();
		loreList.add(ChatColor.GREEN + "Forest");
		loreList.add(ChatColor.YELLOW + "Biome Palette");
		im.setLore(loreList);
		leaves.setItemMeta(im);

		
		ItemStack stone = new ItemStack(Material.SANDSTONE);
		ItemMeta im1 = stone.getItemMeta();
		im1.setDisplayName(ChatColor.RED + "");
		List<String> loreList1 = new ArrayList<String>();
		loreList1.add(ChatColor.RED + "Desert");
		loreList1.add(ChatColor.YELLOW + "Biome Palette");
		im1.setLore(loreList1);
		stone.setItemMeta(im1);
		
		BiomePalette.addItem(leaves, stone);
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
