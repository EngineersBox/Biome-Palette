package me.engineersbox.menuinv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor {
	
	public final static Inventory main = Bukkit.createInventory(null, 9 * 3, ChatColor.DARK_RED + "           [" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] ");
	
	static {
		
		ItemStack exit = new ItemStack(Material.OBSIDIAN);
        ItemMeta im0 = exit.getItemMeta();
        im0.setDisplayName(ChatColor.GRAY + "EXIT");
        exit.setItemMeta(im0);
		
		ItemStack plains = new ItemStack(Material.GRASS);
        ItemMeta im = plains.getItemMeta();
        im.setDisplayName(ChatColor.DARK_GREEN + "PLAINS");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(ChatColor.YELLOW + "Biome Palette");
        im.setLore(Lore);
        plains.setItemMeta(im);
        
        ItemStack desert = new ItemStack(Material.SAND);
        ItemMeta im1 = desert.getItemMeta();
        im1.setDisplayName(ChatColor.GOLD + "DESERT");
        ArrayList<String> Lore1 = new ArrayList<String>();
        Lore1.add(ChatColor.YELLOW + "Biome Palette");
        im1.setLore(Lore1);
        desert.setItemMeta(im1);
        
        ItemStack forest = new ItemStack(Material.LEAVES);
        ItemMeta im2 = forest.getItemMeta();
        im2.setDisplayName(ChatColor.GREEN + "FOREST");
        ArrayList<String> Lore2 = new ArrayList<String>();
        Lore2.add(ChatColor.YELLOW + "Biome Palette");
        im2.setLore(Lore2);
        forest.setItemMeta(im2);
        
        ItemStack extreme = new ItemStack(Material.STONE);
        ItemMeta im3 = extreme.getItemMeta();
        im3.setDisplayName(ChatColor.DARK_GRAY + "EXTREME HILLS");
        ArrayList<String> Lore3 = new ArrayList<String>();
        Lore3.add(ChatColor.YELLOW + "Biome Palette");
        im3.setLore(Lore3);
        extreme.setItemMeta(im3);
        
        ItemStack savanna = new ItemStack(Material.LOG_2);
        ItemMeta im4 = savanna.getItemMeta();
        im4.setDisplayName(ChatColor.DARK_RED + "SAVANNA");
        ArrayList<String> Lore4 = new ArrayList<String>();
        Lore4.add(ChatColor.YELLOW + "Biome Palette");
        im4.setLore(Lore4);
        savanna.setItemMeta(im4);
        
        ItemStack taiga = new ItemStack(Material.SNOW_BLOCK);
        ItemMeta im5 = taiga.getItemMeta();
        im5.setDisplayName(ChatColor.WHITE + "TAIGA");
        ArrayList<String> Lore5 = new ArrayList<String>();
        Lore5.add(ChatColor.YELLOW + "Biome Palette");
        im5.setLore(Lore5);
        taiga.setItemMeta(im5);
        
        ItemStack ocean = new ItemStack(Material.PRISMARINE);
        ItemMeta im6 = ocean.getItemMeta();
        im6.setDisplayName(ChatColor.DARK_BLUE + "OCEAN");
        ArrayList<String> Lore6 = new ArrayList<String>();
        Lore6.add(ChatColor.YELLOW + "Biome Palette");
        im6.setLore(Lore6);
        ocean.setItemMeta(im6);
        
        ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta im7 = pane.getItemMeta();
        im7.setDisplayName(ChatColor.GRAY + "");
        pane.setItemMeta(im7);
		
        int slot = 0;
        
        while(slot < 27) {
        	if((slot > 9) && (slot < 17) || (slot == 22)) {
        		slot = slot + 1;
        	} else {
        		main.setItem(slot, pane);
        		slot += 1;
        	}
        }

        main.setItem(10, plains);
        main.setItem(11, desert);
        main.setItem(12, forest);
        main.setItem(13, extreme);
        main.setItem(14, savanna);
        main.setItem(15, taiga);
        main.setItem(16, ocean);
        
        main.setItem(22, exit);
        
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	Player p = (Player) sender;
    	
        if (sender instanceof Player) {
        	
            if (cmd.getName().equalsIgnoreCase("bp")) {
            	
            	if (args.length == 0) {
            		
            		p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Opening Palette!");
                    p.openInventory(main);
                    
            	} else if (args.length > 0) {
            		
            		if (args[0].equalsIgnoreCase("help")) {
            			
	            		p.sendMessage("");
	                	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Help" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
	                	p.sendMessage("");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Opens The Block Palette Interface");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp tool " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Gives The Block Biome Altering Tool");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp setbiome <biome>" + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Sets The Biome To Be Used with /bp tool");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp biomelist " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays The Valid Biomes For /bp tool biome");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp version " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays The Plugin Version And Author");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp reload " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Reloads The BlockPalette Plugin");
	                	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp help " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Opens This Menu");
	                	p.sendMessage("");
	                	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Help" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
	                	p.sendMessage("");
                	
            		} else if (args[0].equalsIgnoreCase("tool")) {
            			
            			ItemStack tool = new ItemStack(Material.STONE_AXE);
            			ItemMeta im = tool.getItemMeta();
            			im.setDisplayName(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "Biome " + ChatColor.DARK_AQUA + "Tool" + ChatColor.DARK_RED + "]");
            			im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
            			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            			ArrayList<String> Lore = new ArrayList<String>();
            			Lore.add(ChatColor.YELLOW + "Alters Block Specific Biomes");
            			im.setLore(Lore);
            			tool.setItemMeta(im);
            			
            			p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Giving Block Biome Tool!");
            			p.getInventory().addItem(tool);
            			
            		} else if (args[0].equalsIgnoreCase("setbiome")) {
            			if (args.length == 2) {
            				
            				if ((args[1].equalsIgnoreCase("desert")) || (args[1].equalsIgnoreCase("forest")) || (args[1].equalsIgnoreCase("ocean")) || (args[1].equalsIgnoreCase("extremehills")) || (args[1].equalsIgnoreCase("taiga")) || (args[1].equalsIgnoreCase("plains"))) {
            					
            					Main.biome = args[1];
            					p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To: " + ChatColor.DARK_GREEN + args[1].substring(0, 1).toUpperCase() + args[1].substring(1).toLowerCase());
            					
            				} else {
            					
            					Main.biome = "";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "Invalid Biome!");
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "View Valid Biomes With: "  + ChatColor.ITALIC + "/bp biomelist");
            					
            				}
            				
            				/*if (args[1].equalsIgnoreCase("desert")) {
                				
                				Main.biome = "desert";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To Desert");
                				
                			} else if (args[1].equalsIgnoreCase("forest")) {
                				
                				Main.biome = "forest";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To Forest");
                				
                			} else if (args[1].equalsIgnoreCase("ocean")) {
                				
                				Main.biome = "ocean";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To Ocean");
                				
                			} else if (args[1].equalsIgnoreCase("extremehills")) {
                				
                				Main.biome = "extremehills";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To Extreme Hills");
                				
                			} else if (args[1].equalsIgnoreCase("taiga")) {
                				
                				Main.biome = "taiga";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To Taiga");
                				
                			} else if (args[1].equalsIgnoreCase("plains")) {
                				
                				Main.biome = "plains";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Biome Set To Plains");
                			
                			} else {
                				
                				Main.biome = "";
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "Invalid Syntax!");
                				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "Usage: /bp setbiome <biome>");
                				
                			}*/ //debug if complex if statement doesnt work
            				
            			} else if (args.length == 1) {
            				
            				Main.biome = "";
            				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "Invalid Syntax!");
            				p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "Usage: " + ChatColor.ITALIC + "/bp setbiome <biome>");
            				
            			}
            			
            			
            		} else if (args[0].equalsIgnoreCase("version")) {
        				
        				p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Version Info" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "Version Number " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "1.1");
        		    	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "Author " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "EngineersBox");
        		    	p.sendMessage("");
        		    	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Version Info" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
        		    	p.sendMessage("");
        		    
            		} else if (args[0].equalsIgnoreCase("reload")) {
            			
            			Main.config = YamlConfiguration.loadConfiguration(Main.cfile);
            			
            			p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_GREEN + "Reloading BlockPalette...");
            			Plugin plugin = p.getServer().getPluginManager().getPlugin("BlockPalette");
            			p.getServer().getPluginManager().disablePlugin(plugin);
            			p.getServer().getPluginManager().enablePlugin(plugin);
            			p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_GREEN + "Reload Complete!");
        		    	
            		} else if (args[0].equalsIgnoreCase("biomelist")) {
        				
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
        		    
            		} else {
            			p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_PURPLE + "Invalid Command!");
            		}
            	}

            	return true;
            	
            }
            
            return true;
            
        }
        
		return false;
    
    }
}