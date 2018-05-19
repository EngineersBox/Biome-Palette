package me.engineersbox.menuinv;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.engineersbox.menuinv.LoadInv;


public class EventList implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPLayerUse(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		EquipmentSlot hand = event.getHand();
		
		if ((event.useInteractedBlock() != null) && (hand != null) && (event.getClickedBlock() != null) && (hand.equals(EquipmentSlot.HAND)) && (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && ((p.getInventory().getItemInMainHand().equals(Item.tool) || (p.getInventory().getItemInOffHand().equals(Item.tool))))) {
		            
		        	if (Main.getB == 1) {
		        		
		        		p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Block Biome: " + ChatColor.DARK_GREEN +  event.getClickedBlock().getBiome());
		        		
		        		if (Main.chunkinfo == 1) {
		        			
		        			p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "At Chunk: " + ChatColor.DARK_GRAY + event.getClickedBlock().getChunk());
		        			
		        		}
		        		
		        	} else if (Main.getB == 0) {
		        	
			        	if (Main.biome != "" ) {
			        		
			        		p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Block Biome Set To: " + ChatColor.DARK_GREEN +  Main.biome.substring(0, 1).toUpperCase() + Main.biome.substring(1).toLowerCase());
			        		
			        		if (Main.biome.equals("desert")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.DESERT);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else if (Main.biome.equals("plains")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.PLAINS);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else if (Main.biome.equals("extremehills")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.EXTREME_HILLS);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else if (Main.biome.equals("forest")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.FOREST);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else if (Main.biome.equals("ocean")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.OCEAN);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else if (Main.biome.equals("savanna")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.SAVANNA);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else if (Main.biome.equals("taiga")) {
			        			
			        			event.getClickedBlock().setBiome(Biome.TAIGA);
			        			event.getClickedBlock().getChunk().getWorld().refreshChunk(event.getClickedBlock().getChunk().getX(), event.getClickedBlock().getChunk().getZ());
			        			
			        		} else {
			        			
			        			p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
			        			
			        		}
			        	
			        		
			        	} else {
			        		
			        		p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Biome Not Set. Use: " + ChatColor.ITALIC + "/bp setbiome <biome>");
			        		
			        	}
		        	}
		        } else {
		        	return;
		        }
		    }
	
    @EventHandler
    public void onPlayerClickGUI(InventoryClickEvent e) {
    	
        Player p = (Player) e.getWhoClicked();
        int slot = e.getRawSlot();
        Boolean exitflag = false;
        
        if (e.getSlot() == -999) {
            return;
        }

        if (slot >= 0 && slot < 9 * 3) {
            e.setCancelled(true);
            //p.sendMessage("Event Cancelled!"); //debug
        }
        
        if (e.getCurrentItem() == null) {
        	
        	return;
        	
        } else if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
        	
        	exitflag = true;
        	Main.cinv = 0;
        	Main.i = 0;
        	p.closeInventory();
        	
        } else if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
    		
    		exitflag = true;
        	Main.cinv = 0;
        	Main.i = 0;
        	p.openInventory(Inventories.main);
        
        }
        
        if (e.getInventory().getTitle().equals(ChatColor.DARK_RED + "           " + Main.prefix)) { //main inventory
            
            if (e.getCurrentItem().getItemMeta() != null) {
            	
            	String currentItem = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName().toLowerCase());
            	
            	if (Main.BiomeList.contains(currentItem)) {
            		
            		Main.i = 0;
            		Inventories.openStoredInv(e, currentItem);
            		
            	} else if (exitflag == true) {
            		
            		exitflag = false;
            		return;
            		
            	} else {
            		
            		p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
            		
            	}
            	
            } else {
            	
            	return;
            	
            }
            
            if (e.getCurrentItem() == null) {
            	
            	return;
            	
            }
        }

        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.GOLD + "Desert")) { //desert inventory
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("desert");
            	p.openInventory(Inventories.desert);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("desert");
            	p.openInventory(Inventories.desert);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_GREEN + "Plains")) { //plains inventory
        	
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("plains");
            	p.openInventory(Inventories.plains);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("plains");
            	p.openInventory(Inventories.plains);
            }
        
        }
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.GREEN + "Forest")) { //forest inventory
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("forest");
            	p.openInventory(Inventories.forest);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("forest");
            	p.openInventory(Inventories.forest);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_GRAY + "Extreme Hills")) { //extreme hills inventory
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("extremehills");
            	p.openInventory(Inventories.extremehills);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("extremehills");
            	p.openInventory(Inventories.extremehills);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_RED + "Savanna")) { //savanna inventory
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("savanna");
            	p.openInventory(Inventories.savanna);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("savanna");
            	p.openInventory(Inventories.savanna);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.WHITE + "Taiga")) { //taiga inventory
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("taiga");
            	p.openInventory(Inventories.taiga);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("taiga");
            	p.openInventory(Inventories.taiga);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_BLUE + "Ocean")) { //ocean inventory
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) && (Main.oinv == true)) {
            	Main.cinv += 1;
            	LoadInv.setItemList("ocean");
            	p.openInventory(Inventories.ocean);
            	//p.sendMessage("Completed " + Main.oinv);
            }
            
            if ((e.getCurrentItem().getType() == Material.PAPER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Previous Page")) && (Main.cinv > 0)) {
            	Main.cinv -= 1;
            	Main.i = 36 * Main.cinv;
            	LoadInv.setItemList("ocean");
            	p.openInventory(Inventories.ocean);
            }
        
        }
        
    }

}
