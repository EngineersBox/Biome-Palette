package me.engineersbox.menuinv;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.engineersbox.menuinv.Main;
import me.engineersbox.menuinv.Inventories;

public class LoadInv extends AbstractFile {

	public LoadInv(Main main) {
	       
        super(main, "invconfig.yml");
       
    }

	public static void getItemList(String biome) {
		
		if (config.contains(biome)) {
			
			List<String> items = config.getStringList(biome);
			
			//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "List Exists!");
			
			int i = 0;
			while (i < items.size()) {
				
				String current = items.get(i);
				String[] split = current.split("-");
				String block = split[0];
				String name = split[1];
				
				//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug1");
				
				ItemStack item = new ItemStack(Material.matchMaterial(block), 1, (short) 7);
		        ItemMeta item1 = item.getItemMeta();
		        item1.setDisplayName(name);
		        item.setItemMeta(item1);
		        
		        //Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug2");
		        
		        if ((biome == "plains") && i < 39) {
		        	
		        	Inventories.plains.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug plains");
		        	
		        } else if ((biome == "desert") && i < 39) {
		        	
		        	Inventories.desert.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug desert");
		        	
		        } else if ((biome == "ocean") && i < 39) {
		        	
		        	Inventories.ocean.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug ocean");
		        	
		        } else if ((biome == "forest") && i < 39) {
		        	
		        	Inventories.forest.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug forest");
		        	
		        } else if ((biome == "savanna") && i < 39) {
		        	
		        	Inventories.savanna.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug savanna");
		        
		        } else if ((biome == "taiga") && i < 39) {
		        	
		        	Inventories.taiga.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug taiga");
		        
		        } else if ((biome == "extremehills") && i < 39) {
		        	
		        	Inventories.extremehills.setItem(i, item);
		        	i += 1;
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug extremehills");
		        
		        } else if ((i > 38) && (i < 44)) {
		        	
		        	Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Inventory Overflow!");
		        	i += 1;
		        	
		        } else {
		        	
		        	Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Invalid Biome!");
		        	i += 1;
		        	
		        }
			}
			
		} else {
			
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Biome List Does Not Exist!");
			
		}
		
		
	}
	
}
