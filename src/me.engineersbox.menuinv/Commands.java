package me.engineersbox.menuinv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventories {
	
	@EventHandler
	public static void openStoredInv(InventoryClickEvent e, String invname) throws IllegalArgumentException {
		
		Player p = (Player) e.getWhoClicked();
		
		if (invname.equals("desert")) {
			
        	LoadInv.setItemList("desert");
        	p.openInventory(Inventories.desert);
			
		} else if (invname.equals("plains")) {
			
        	LoadInv.setItemList("plains");
        	p.openInventory(Inventories.plains);
			
		} else if (invname.equals("forest")) {
			
        	LoadInv.setItemList("forest");
        	p.openInventory(Inventories.forest);
			
		} else if (invname.equals("extremehills")) {
			
        	LoadInv.setItemList("extremehills");
        	p.openInventory(Inventories.extremehills);
			
		} else if (invname.equals("savanna")) {
			
        	LoadInv.setItemList("savanna");
        	p.openInventory(Inventories.savanna);
			
		} else if (invname.equals("taiga")) {
			
        	LoadInv.setItemList("taiga");
        	p.openInventory(Inventories.taiga);
			
		} else if (invname.equals("ocean")) {
			
        	LoadInv.setItemList("ocean");
        	p.openInventory(Inventories.ocean);
			
		} else {
			
			p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE + "Invalid Biome!");
			throw new IllegalArgumentException();
			
		}
		
	}
	
	public final static Inventory main = Bukkit.createInventory(null, 9 * 3, ChatColor.DARK_RED + "           " + Main.prefix);
		
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
	        		
	        		slot += 1;
	        		
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
	
		public final static Inventory desert = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.GOLD + "Desert");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	        
	        desert.setItem(39, prev);
	        desert.setItem(40, eye);
	        desert.setItem(41, next);
	        
	        desert.setItem(36, back);
	        desert.setItem(44, exit);
		}
		
		public final static Inventory plains = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.DARK_GREEN + "Plains");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	        
	        plains.setItem(39, prev);
	        plains.setItem(40, eye);
	        plains.setItem(41, next);
	        
	        plains.setItem(36, back);
	        plains.setItem(44, exit);
		}
		
		public final static Inventory forest = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.GREEN + "Forest");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	        
	        forest.setItem(39, prev);
	        forest.setItem(40, eye);
	        forest.setItem(41, next);
	        
	        forest.setItem(36, back);
	        forest.setItem(44, exit);
		}
		
		public final static Inventory extremehills = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.DARK_GRAY + "Extreme Hills");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	       
	        extremehills.setItem(39, prev);
	        extremehills.setItem(40, eye);
	        extremehills.setItem(41, next);
	        
	        extremehills.setItem(36, back);
	        extremehills.setItem(44, exit);
		}
		
		public final static Inventory savanna = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.DARK_RED + "Savanna");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	        
	        savanna.setItem(39, prev);
	        savanna.setItem(40, eye);
	        savanna.setItem(41, next);
	        
	        savanna.setItem(36, back);
	        savanna.setItem(44, exit);
		}
		
		public final static Inventory taiga = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.WHITE + "Taiga");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	        
	        taiga.setItem(39, prev);
	        taiga.setItem(40, eye);
	        taiga.setItem(41, next);
	        
	        taiga.setItem(36, back);
	        taiga.setItem(44, exit);
		}
		
		public final static Inventory ocean = Bukkit.createInventory(null, 9 * 5, Main.prefix + ChatColor.DARK_BLUE + "Ocean");
	
		static {
			
			ItemStack exit = new ItemStack(Material.OBSIDIAN);
	        ItemMeta im0 = exit.getItemMeta();
	        im0.setDisplayName(ChatColor.GRAY + "EXIT");
	        exit.setItemMeta(im0);
	        
	        ItemStack back = new ItemStack(Material.BOOK);
	        ItemMeta im1 = back.getItemMeta();
	        im1.setDisplayName(ChatColor.DARK_RED + "BACK TO MAIN");
	        back.setItemMeta(im1);
	        
	        ItemStack prev = new ItemStack(Material.PAPER);
	        ItemMeta im2 = prev.getItemMeta();
	        im2.setDisplayName(ChatColor.AQUA + "Previous Page");
	        prev.setItemMeta(im2);
	
	        ItemStack eye = new ItemStack(Material.EYE_OF_ENDER);
	        ItemMeta im3 = eye.getItemMeta();
	        im3.setDisplayName(ChatColor.DARK_PURPLE + "Page");
	        eye.setItemMeta(im3);
	        
	        ItemStack next = new ItemStack(Material.PAPER);
	        ItemMeta im4 = next.getItemMeta();
	        im4.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
	        next.setItemMeta(im4);
	        
	        ocean.setItem(39, prev);
	        ocean.setItem(40, eye);
	        ocean.setItem(41, next);
	        
	        ocean.setItem(36, back);
	        ocean.setItem(44, exit);
		}
	
}
