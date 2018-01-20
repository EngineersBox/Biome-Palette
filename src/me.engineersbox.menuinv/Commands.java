package me.engineersbox.menuinv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
        		slot = slot + 1;
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

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("bp")) {
            	p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] " + ChatColor.DARK_AQUA + "Opening Palette!");
                p.openInventory(main);
            }
        }
        
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("bp-help")) {
            	p.sendMessage("");
            	p.sendMessage(ChatColor.DARK_GRAY + "----={<" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Help" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
            	p.sendMessage("");
            	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Opens The Block Palette Interface");
            	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/version BlockPalette " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Displays The Plugin Version And Author");
            	p.sendMessage(ChatColor.BLACK + "> " + ChatColor.DARK_GREEN + "/bp-help " + ChatColor.WHITE + ":: " + ChatColor.DARK_RED + "Opens This Menu");
            	p.sendMessage("");
            	p.sendMessage(ChatColor.DARK_GRAY + "----=<{" + ChatColor.DARK_RED + "  [" + ChatColor.GOLD + "BlockPalette Help" + ChatColor.DARK_RED + "]  " + ChatColor.DARK_GRAY + "}>=----");
            	p.sendMessage("");
            }
        }

        return true;
     
    }

}