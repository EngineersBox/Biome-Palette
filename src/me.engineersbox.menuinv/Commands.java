package me.engineersbox.menuinv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import me.engineersbox.menuinv.InvConfig;

public class Commands implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
        if (sender instanceof Player) {
        	
        	Player p = (Player) sender;
        	
            if ((cmd.getName().equalsIgnoreCase("bp")) && (p.hasPermission("bp.open"))) {
            	
            	if (args.length == 0) {
            		
            		p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Opening Palette!");
                    p.openInventory(Inventories.main);
                    
            	} else if (args.length > 0) {
            		
            		if ((args[0].equalsIgnoreCase("help")) && (p.hasPermission("bp.help"))) {
            			
	            		p.sendMessage("");
	                	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Help" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
	                	p.sendMessage("");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Opens The Block Palette Interface");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp tool " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Gives The Block Biome Altering Tool");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp setbiome <biome>" + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Sets The Biome To Be Used with /bp tool");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp getbiome <enable/disable> " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Changes Tool To Identify The Biome Of A Selected Block");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp biomelist " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays The Valid Biomes For /bp tool biome");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp areareplace <enbale/disable> " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Replaces Specific Biome To Another Within Area Selection Made With /bp tool");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp repalceto <from> <to> " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Specifies Biomes To Swap In Area Selection");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp chunkinfo <enable/disable> " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays Chunk Data When Using /bp tool");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp settings " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays Current chunkinfo and getbiome Settings");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp add <biome> <block> <name>" + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Adds A Block To The BlockPalette, Given Via Arguments");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp remove <biome> <block> <name>" + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Removes A Block From The BlockPalette, Given Via Arguments");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp version " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays The Plugin Version And Author");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp reload " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Reloads The BlockPalette Plugin");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp help " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Opens This Menu");
	                	p.sendMessage("");
	                	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Help" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
	                	p.sendMessage("");
                	
            		} else if ((args[0].equalsIgnoreCase("tool")) && (p.hasPermission("bp.tool"))) {
            			
            			p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Giving Block Biome Tool!");
            			p.getInventory().addItem(Item.tool);
            			
            		} else if ((args[0].equalsIgnoreCase("setbiome")) && (p.hasPermission("bp.setbiome"))) {
            			
            			if (args.length == 2) {
            				
            				if ((args[1].equalsIgnoreCase("desert")) || (args[1].equalsIgnoreCase("forest")) || (args[1].equalsIgnoreCase("ocean")) || (args[1].equalsIgnoreCase("extremehills")) || (args[1].equalsIgnoreCase("taiga")) || (args[1].equalsIgnoreCase("plains"))) {
            					
            					Main.biome = args[1];
            					p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Biome Set To: " + ChatColor.DARK_GREEN + args[1].substring(0, 1).toUpperCase() + args[1].substring(1).toLowerCase());
            					
            				} else {
            					
            					Main.biome = "";
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "View Valid Biomes With: "  + ChatColor.ITALIC + "/bp biomelist");
            					
            				}
            				
            			} else if (args.length == 1) {
            				
            				Main.biome = "";
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Syntax!");
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp setbiome <biome>");
            	
            			}
            			
            		
            		} else if ((args[0].equalsIgnoreCase("getbiome")) && (p.hasPermission("bp.getbiome"))) {
            			
            			if (args.length == 2) {
            				
            				if (args[1].equalsIgnoreCase("enable")) {
            					
            					if (Main.getB == 0) {
            						
            						Main.getB = 1;
            						p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Get Biome Enabled!");
            						
            					} else if (Main.getB == 1) {
            						
            						p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Error: Get Biome Already Enabled!");
            						
            					}
            					
            					
            				} else if (args[1].equalsIgnoreCase("disable")) {
            					
            					if (Main.getB == 1) {
            						
            						Main.getB = 0;
            						p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Get Biome Disabled!");
            						
            					} else if (Main.getB == 0) {
            						
            						p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Error: Get Biome Already Disabled!");
            						
            					}
            					
            				} else {
            					
            					p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Syntax!");
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp getbiome <enable/disable>");
            					
            				}
            				
            			}
            		
            		} else if ((args[0].equalsIgnoreCase("undo")) && (p.hasPermission("bp.undo"))) {
            			
            			if (Main.undobool == true) {
            				
            				for (Block cb : Main.undolist) {
            					cb.setBiome(Main.undobiome);
								cb.getChunk().getWorld().refreshChunk(cb.getChunk().getX(), cb.getChunk().getZ());
							}
            				
            				Main.undobool = false;
            				p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Biomes Reverted");
            				
            			} else {
            				
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Nothing To Undo!");
            				
            			}
            			
            		} else if ((args[0].equalsIgnoreCase("replaceto")) && (p.hasPermission("bp.replaceto")) && (args.length > 2)) {
            			
            			Main.rplfromto = new ArrayList<String>();
            			
            			for (int i = 1; i < 3; i++) {
    						if ((args[i].equals("desert")) | (args[i].equals("plains")) | (args[i].equals("extremehills")) | (args[i].equals("forest")) | (args[i].equals("ocean")) | (args[i].equals("savanna")) | (args[i].equals("taiga"))) {
    							Main.rplfromto.add(args[i]);
    						} else {
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "View Valid Biomes With: "  + ChatColor.ITALIC + "/bp biomelist");
    						}
            			}
            			p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Biome From: " + Main.rplfromto.get(0) + " To: " + Main.rplfromto.get(1));
            			
            		} else if ((args[0].equalsIgnoreCase("areareplace")) && (p.hasPermission("bp.areareplace")) && (args.length > 1)) {
            			
            			if (args[1].equalsIgnoreCase("enable")) {
            				
            				if (Main.arpl == false) {
            					
            					Main.arpl = true;
            					p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Area Replace Biome Enabled!");
            					
            				} else if (Main.arpl == true) {
            					
            					p.sendMessage(Main.prefix + ChatColor.DARK_GREEN + "Error: Area Replace Biome Already Enabled!");
            					
            				}
            				
            			} else if (args[1].equalsIgnoreCase("disable")) {
            				
            				if (Main.arpl == true) {
            					
            					Main.arpl = false;
            					p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Area Replace Biome Disabled!");
            					
            				} else if (Main.arpl == false) {
            					
            					p.sendMessage(Main.prefix + ChatColor.DARK_GREEN + "Error: Area Replace Biome Already Disabled!");
            					
            				}
            				
            			} else {
            				
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Syntax!");
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp areareplace <enable/disable>");
            				
            			}
            			
            		} else if ((args[0].equalsIgnoreCase("chunkinfo")) && (p.hasPermission("bp.chunkinfo"))) {
            			
            			if (args.length == 2) {
            				
            				if (args[1].equalsIgnoreCase("enable")) {
            					
            					if (Main.chunkinfo == 0) {
            						
            						Main.chunkinfo = 1;
            						p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Chunk Info Enabled!");
            						
            					} else if (Main.chunkinfo == 1) {
            						
            						p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Error: Chunk Info Already Enabled!");
            						
            					}
            					
            					
            				} else if (args[1].equalsIgnoreCase("disable")) {
            					
            					if (Main.chunkinfo == 1) {
            						
            						Main.chunkinfo = 0;
            						p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Chunk Info Disabled!");
            						
            					} else if (Main.chunkinfo == 0) {
            						
            						p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Error: Chunk Info Already Disabled!");
            						
            					}
            					
            				} else {
            					
            					p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Syntax!");
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp chunkinfo <enable/disable>");
            					
            				}
            				
            			}
            		
            		} else if ((args[0].equalsIgnoreCase("settings")) && (p.hasPermission("bp.settings"))) {
            			
            			String getbiome = "";
            			String chunkinfo = "";
            			
            			if (Main.getB == 1) {
            				
            				getbiome = ChatColor.GREEN + "Enabled";
            				
            			} else {
            				
            				getbiome = ChatColor.DARK_RED + "Disabled";
            				
            			}
            			
            			if (Main.chunkinfo == 1) {
            				
            				chunkinfo = ChatColor.GREEN + "Enabled";
            				
            			} else {
            				
            				chunkinfo = ChatColor.DARK_RED + "Disabled";
            				
            			}
            			
            			p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Settings" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "Get Biome " + ChatColor.WHITE + ":: " + getbiome);
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "Chunk Info " + ChatColor.WHITE + ":: " + chunkinfo);
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Settings" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
            			
            		} else if ((args[0].equalsIgnoreCase("version")) && (p.hasPermission("bp.version"))) {
        				
            			String version = Bukkit.getServer().getPluginManager().getPlugin("BlockPalette").getDescription().getVersion();
            			
        				p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Version Info" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "Version Number " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + version);
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "Author " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "EngineersBox");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Version Info" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
        		    
            		} else if ((args[0].equalsIgnoreCase("reload")) && (p.hasPermission("bp.reload"))) {
            			
            			Main.config = YamlConfiguration.loadConfiguration(Main.cfile);
            			
            			p.sendMessage(Main.prefix + ChatColor.DARK_GREEN + "Reloading BlockPalette...");
            			Plugin plugin = p.getServer().getPluginManager().getPlugin("BlockPalette");
            			p.getServer().getPluginManager().disablePlugin(plugin);
            			p.getServer().getPluginManager().enablePlugin(plugin);
            			p.sendMessage(Main.prefix + ChatColor.DARK_GREEN + "Reload Complete!");
        		    	
            		} else if ((args[0].equalsIgnoreCase("biomelist")) && (p.hasPermission("bp.biomelist"))) {
        				
        				p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Biome List" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "plains " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Plains");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "desert " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Desert");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "extremehills " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Extreme Hills");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "forest " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Forest");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "savanna " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Savanna");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "taiga " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Taiga");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Biome List" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");	
        		    
            		} else if ((args[0].equalsIgnoreCase("add")) && (p.hasPermission("bp.add"))) {
            			
            			if (args.length == 4) {
            				
            				String biome = args[1].toLowerCase();
                			String block = args[2].toLowerCase();
                			String name = args[3].toLowerCase();
                			
                			if (Material.matchMaterial(block.toUpperCase()) != null) {
                				
                				Main.mater = block.toUpperCase();
                				
                				if ((biome.equalsIgnoreCase("plains")) || (biome.equalsIgnoreCase("desert")) || (biome.equalsIgnoreCase("ocean")) || (biome.equalsIgnoreCase("forest")) || (biome.equalsIgnoreCase("savanna")) || (biome.equalsIgnoreCase("taiga")) || (biome.equalsIgnoreCase("extremehills"))) {
                					
                					p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Added " + Main.mater + " [" + name + "]" + " To " + biome.substring(0, 1).toUpperCase() + biome.substring(1).toLowerCase());
                					InvConfig.newInv(biome, block, name);
                    				AbstractFile.saveConfig();
                					
                				} else {
                					p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
                				}
                				
                			} else {
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Block/Material!");
                			}
            				
            			} else if (args.length < 4) {
            				
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Syntax!");
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp add <biome> <block> <name>");
            				
            			}
            		
            		} else if ((args[0].equalsIgnoreCase("remove")) && (p.hasPermission("bp.remove"))) {
            			
            			if (args.length == 4) {
            				
            				String biome = args[1].toLowerCase();
                			String block = args[2].toLowerCase();
                			String name = args[3].toLowerCase();
                			
                			if (Material.matchMaterial(block.toUpperCase()) != null) {
                				
                				Main.mater = block.toUpperCase();
                				
                				if ((biome.equalsIgnoreCase("plains")) || (biome.equalsIgnoreCase("desert")) || (biome.equalsIgnoreCase("ocean")) || (biome.equalsIgnoreCase("forest")) || (biome.equalsIgnoreCase("savanna")) || (biome.equalsIgnoreCase("taiga")) || (biome.equalsIgnoreCase("extremehills"))) {
                					
                					LoadInv.removeItemList(args[1], args[2], args[3]);
                					p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Removed " + Main.mater + " [" + name + "] From " + biome.substring(0, 1).toUpperCase() + biome.substring(1).toLowerCase());
                    				
                				} else {
                					p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
                				}
                				
                			} else {
                				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Block/Material!");
                			}
            				
            			} else if (args.length < 4) {
            				
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Syntax!");
            				p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp remove <biome> <block> <name>");
            				
            			}
            		
            		} else  if ((!p.hasPermission("help")) || (!p.hasPermission("tool")) || (!p.hasPermission("open")) || (!p.hasPermission("setbiome")) || (!p.hasPermission("getbiome")) || (!p.hasPermission("biomelist")) || (!p.hasPermission("chunkinfo")) || (!p.hasPermission("settings")) || (!p.hasPermission("add")) || (!p.hasPermission("version")) || (!p.hasPermission("reload"))) {	
            		
            			p.sendMessage(Main.prefix + ChatColor.RED + "You Do Not Have Permission!");
            			
            		} else {
            			
            			p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Command!");
            			
            		}
            	}

            	return true;
            	
            }
            
            return true;
            
        }
        
		return false;
    
    }

}
