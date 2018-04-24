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

	public static void setItemList(String biome) {
		
		/*Exception e = new NullPointerException();
    	
    	StringWriter outError = new StringWriter();
    	e.printStackTrace(new PrintWriter(outError));
    	String errorString = outError.toString();*/ //stack trace string [debug]
		
		int slot = 0;
		int totali = Main.i * Main.cinv;
		int k = 0;
		
		ItemStack pagecount = new ItemStack(Material.EYE_OF_ENDER, (short) Main.cinv + 1);
		ItemMeta countid = pagecount.getItemMeta();
		countid.setDisplayName(ChatColor.DARK_PURPLE + "Page");
		pagecount.setItemMeta(countid);
		
		if (config.contains(biome)) {
			
			if (Main.oinv == true) {
				
				if (biome == "desert") {
					
					while (k < 36) {
						
						Inventories.desert.clear(k);
						Inventories.desert.setItem(40, pagecount);
						k += 1;
						
					}
				
				} else if (biome == "plains") {
					
					while (k < 36) {
						
						Inventories.plains.clear(k);
						Inventories.plains.setItem(40, pagecount);
						k += 1;
						
					}
					
				} else if (biome == "forest") {
					
					while (k < 36) {
						
						Inventories.forest.clear(k);
						Inventories.forest.setItem(40, pagecount);
						k += 1;
						
					}
					
				} else if (biome == "extremehills") {
					
					while (k < 36) {
						
						Inventories.extremehills.clear(k);
						Inventories.extremehills.setItem(40, pagecount);
						k += 1;
						
					}
					
				} else if (biome == "savanna") {
					
					while (k < 36) {
						
						Inventories.savanna.clear(k);
						Inventories.savanna.setItem(40, pagecount);
						k += 1;
						
					}
					
				} else if (biome == "taiga") {
					
					while (k < 36) {
						
						Inventories.taiga.clear(k);
						Inventories.taiga.setItem(40, pagecount);
						k += 1;
						
					}
					
				} else if (biome == "ocean") {
					
					while (k < 36) {
						
						Inventories.ocean.clear(k);
						Inventories.ocean.setItem(40, pagecount);
						k += 1;
						
					}
					
				} else {
					
					Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Invalid Biome!");
					
				}
			
				slot = 0;
				Main.oinv = false;
		
			}
			
			List<String> items = config.getStringList(biome);
			
			//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "List Exists!");
			
			while ((Main.i < items.size()) && (Main.oinv == false)) {
				
				//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug int " + Main.i + " Slot" + slot);
				//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug0 (total i)" + ChatColor.GRAY + totali);
				
				String current = items.get(Main.i);
				String[] split = current.split("-");
				String block = split[0];
				String name = split[1];
				
				//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug1");
				
				ItemStack item = new ItemStack(Material.matchMaterial(block), 1, (short) 7);
		        ItemMeta item1 = item.getItemMeta();
		        item1.setDisplayName(name);
		        item.setItemMeta(item1);
		        
		        //Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug2");
		        
		        if ((biome == "plains") && slot < 36) {
		        	
		        	Inventories.plains.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug plains");
		        	
		        } else if ((biome == "desert") && slot < 36) {
		        	
		        	Inventories.desert.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug desert");
		        	
		        } else if ((biome == "ocean") && slot < 36) {
		        	
		        	Inventories.ocean.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug ocean");
		        	
		        } else if ((biome == "forest") && slot < 36) {
		        	
		        	Inventories.forest.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug forest");
		        	
		        } else if ((biome == "savanna") && slot < 36) {
		        	
		        	Inventories.savanna.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug savanna");
		        
		        } else if ((biome == "taiga") && slot < 36) {
		        	
		        	Inventories.taiga.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug taiga");
		        
		        } else if ((biome == "extremehills") && slot < 36) {
		        	
		        	Inventories.extremehills.setItem(slot, item);
		        	slot += 1;
		        	Main.i += 1;
		        	saveConfig();
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "debug extremehills");
		        
		        } else if (slot >= totali) {
		        	
		        	//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Inventory Overflow!" + ChatColor.GRAY + " (Debug int) Value:" + Main.i);
		        	Main.oinv = true;
		        	break;
		        	
		        } else if (slot > totali + 5) {
		        	
		        	Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Int i is too big!");
		        	break;
		        	
		        } else {
		        	
		        	Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Invalid Biome!");
		        	throw new NullPointerException("Invalid Biome");
		        	//break;
		        	
		        }
			}
			
		} else {
			
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + " Biome List Does Not Exist!");
			
		}
		
		
	}
	
	public static void removeItemList(String biome, String block, String name) {
		
		String blockitem = block.toUpperCase() + "-" + name;
		config.getList(biome).remove(config.getStringList(biome).indexOf(blockitem));
		//Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + biome + ChatColor.DARK_RED + "removed"); //debug
		saveConfig();
		
	}
	
}
