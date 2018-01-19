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

	public final static Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "BlockPalette");
	
		static {
			
			ItemStack plains = new ItemStack(Material.GRASS);
            ItemMeta im = plains.getItemMeta();
            im.setDisplayName(ChatColor.DARK_GREEN + "PLAINS");
            ArrayList<String> Lore = new ArrayList<String>();
            Lore.add(ChatColor.YELLOW + "Biome Palette");
            im.setLore(Lore);
            plains.setItemMeta(im);
            
            ItemStack desert = new ItemStack(Material.SANDSTONE);
            ItemMeta im1 = desert.getItemMeta();
            im1.setDisplayName(ChatColor.DARK_RED + "DESERT");
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
            
            ItemStack ocean = new ItemStack(Material.PRISMARINE);
            ItemMeta im4 = ocean.getItemMeta();
            im4.setDisplayName(ChatColor.DARK_BLUE + "OCEAN");
            ArrayList<String> Lore4 = new ArrayList<String>();
            Lore4.add(ChatColor.YELLOW + "Biome Palette");
            im4.setLore(Lore3);
            ocean.setItemMeta(im4);
			
            inv.setItem(0, plains);
            inv.setItem(1, desert);
            inv.setItem(2, forest);
            inv.setItem(3, extreme);
            inv.setItem(4, ocean);
            
		}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("bp")) {
                p.openInventory(inv);
            }
        }

        return false;
     
    }

}