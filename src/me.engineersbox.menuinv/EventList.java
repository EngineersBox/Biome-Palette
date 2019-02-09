package me.engineersbox.menuinv;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.engineersbox.menuinv.LoadInv;


public class EventList implements Listener {
	
	public static List<Block> select(Location loc1, Location loc2, World w){
		 
        List<Block> blocks = new ArrayList<Block>();
 
        int x1 = loc1.getBlockX();
        int y1 = loc1.getBlockY();
        int z1 = loc1.getBlockZ();
 
        int x2 = loc2.getBlockX();
        int y2 = loc2.getBlockY();
        int z2 = loc2.getBlockZ();
 
        int xMin, yMin, zMin;
        int xMax, yMax, zMax;
        int x, y, z;
 
        if(x1 > x2){
            xMin = x2;
            xMax = x1;
        }else{
            xMin = x1;
            xMax = x2;
        }
 
        if(y1 > y2){
            yMin = y2;
            yMax = y1;
        }else{
            yMin = y1;
            yMax = y2;
        }
 
        //And Z
        if(z1 > z2){
            zMin = z2;
            zMax = z1;
        }else{
            zMin = z1;
            zMax = z2;
        }
 
        //Now it's time for the loop
        for(x = xMin; x <= xMax; x ++){
            for(y = yMin; y <= yMax; y ++){
                for(z = zMin; z <= zMax; z ++){
                    Block b = new Location(w, x, y, z).getBlock();
                    blocks.add(b);
                }
            }
        }
 
        //And last but not least, we return with the list
        return blocks;
    }
	
	public static Biome retBiome(String bstring) {
		
		if (bstring.equalsIgnoreCase("desert")) {
			return Biome.DESERT;
		} else if (bstring.equalsIgnoreCase("plains")) {
			return Biome.PLAINS;
		} else if (bstring.equalsIgnoreCase("extremehills")) {
			return Biome.EXTREME_HILLS;
		} else if (bstring.equalsIgnoreCase("forest")) {
			return Biome.FOREST;
		} else if (bstring.equalsIgnoreCase("ocean")) {
			return Biome.OCEAN;
		} else if (bstring.equalsIgnoreCase("savanna")) {
			return Biome.SAVANNA;
		} else if (bstring.equalsIgnoreCase("taiga")) {
			return Biome.TAIGA;
		} else {
			return Biome.PLAINS;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPLayerUse(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		EquipmentSlot hand = event.getHand();
		
		if ((event.useInteractedBlock() != null) && (hand != null) && (event.getClickedBlock() != null) && (hand.equals(EquipmentSlot.HAND)) && (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && ((p.getInventory().getItemInMainHand().equals(Item.tool) || (p.getInventory().getItemInOffHand().equals(Item.tool))))) {
		            
					if (Main.arpl == true) {
						
						String biomefrom = Main.rplfromto.get(0);
						String biometo = Main.rplfromto.get(1);
						
						if (Main.poscount == 0) {
							
							Main.loc1 = event.getClickedBlock().getLocation();
							p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Position 1 Registered");
							Main.poscount = 1;
							
						} else if (Main.poscount == 1) {
							
							Main.loc2 = event.getClickedBlock().getLocation();
							p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Position 2 Registered");
							p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Replacing Biome From: " + biomefrom + " To: " + biometo + " ...");
							List<Block> blocklist = select(Main.loc1, Main.loc2, p.getWorld());
							for (Block cb : blocklist) {
								if (cb.getBiome().equals(retBiome(biomefrom))) {
									if (biometo.equals("desert")) {
										cb.setBiome(Biome.DESERT);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									} else if (biometo.equals("plains")) {
										cb.setBiome(Biome.PLAINS);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									} else if (biometo.equals("extremehills")) {
										cb.setBiome(Biome.EXTREME_HILLS);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									} else if (biometo.equals("forest")) {
										cb.setBiome(Biome.FOREST);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									} else if (biometo.equals("ocean")) {
										cb.setBiome(Biome.OCEAN);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									} else if (biometo.equals("savanna")) {
										cb.setBiome(Biome.SAVANNA);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									} else if (biometo.equals("taiga")) {
										cb.setBiome(Biome.TAIGA);
										cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
									}
								}
							}
							
							Main.poscount = 0;
							Main.loc1 = null;
							Main.loc2 = null;
							
							
							p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Biomes Replaced!");
						}
						
					} else {
						
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
      
        if ((e.getInventory().getTitle().contains(Main.prefix)) && (slot >= 0 && slot < 9 * 5)) {
        	
        	e.setCancelled(true);
        	
	        if ((e.getCurrentItem() == null) || (e.getCurrentItem().getItemMeta() == null)) {
	        	
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
	        
	        } else if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
	        	
	        	return;
	        	
	        }
	        
	        if (e.getInventory().getTitle().equals(ChatColor.DARK_RED + "           " + Main.prefix)) { //main inventory
	            
	            if (e.getCurrentItem().getItemMeta() != null) {
	            	
	            	String currentItem = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName().toLowerCase()).replaceAll(" ", "");
	            	
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

}
