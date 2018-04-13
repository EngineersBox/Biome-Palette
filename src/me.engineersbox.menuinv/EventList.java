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
		
		if (hand.equals(EquipmentSlot.HAND)) {
			
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
		        if (p.getInventory().getItemInMainHand().equals(Item.tool)) {
		            
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
		        }
		    }
			
		}
	}
	
	
    @EventHandler
    public void onPlayerClickGUI(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        //ItemStack item = e.getCurrentItem();
        int slot = e.getRawSlot();
        
        if (e.getInventory().getTitle().equals(ChatColor.DARK_RED + "           " + Main.prefix)) { //main inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 3) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.SAND) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "DESERT"))) {
            	LoadInv.getItemList("desert");
            	p.openInventory(Inventories.desert);
            }
            
            if ((e.getCurrentItem().getType() == Material.GRASS) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "PLAINS"))) {
            	LoadInv.getItemList("plains");
            	p.openInventory(Inventories.plains);
            }
            
            if ((e.getCurrentItem().getType() == Material.LEAVES) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "FOREST"))) {
            	LoadInv.getItemList("forest");
            	p.openInventory(Inventories.forest);
            }
            
            if ((e.getCurrentItem().getType() == Material.STONE) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY + "EXTREME HILLS"))) {
            	LoadInv.getItemList("extremehills");
            	p.openInventory(Inventories.extremehills);
            }
            
            if ((e.getCurrentItem().getType() == Material.LOG_2) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "SAVANNA"))) {
            	LoadInv.getItemList("savanna");
            	p.openInventory(Inventories.savanna);
            }
            
            if ((e.getCurrentItem().getType() == Material.SNOW_BLOCK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "TAIGA"))) {
            	LoadInv.getItemList("taiga");
            	p.openInventory(Inventories.taiga);
            }
            
            if ((e.getCurrentItem().getType() == Material.PRISMARINE) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_BLUE + "OCEAN"))) {
            	LoadInv.getItemList("ocean");
            	p.openInventory(Inventories.ocean);
            }
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.GOLD + "Desert")) { //desert inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_GREEN + "Plains")) { //plains inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.GREEN + "Forest")) { //forest inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_GRAY + "Extreme Hills")) { //extreme hills inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_RED + "Savanna")) { //savanna inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.WHITE + "Taiga")) { //taiga inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
        
        
        if (e.getInventory().getTitle().equals(Main.prefix + ChatColor.DARK_BLUE + "Ocean")) { //ocean inventory
            if (e.getSlot() == -999) {
                return;
            }

            if (slot >= 0 && slot < 9 * 5) {
                e.setCancelled(true);
                //p.sendMessage("Event Cancelled!"); //debug
            }
            
            if ((e.getCurrentItem().getType() == Material.OBSIDIAN) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "EXIT"))) {
            	p.closeInventory();
            }
            
            if ((e.getCurrentItem().getType() == Material.BOOK) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "BACK TO MAIN"))) {
            	p.openInventory(Inventories.main);
            }
        
        }
 
    }

}
