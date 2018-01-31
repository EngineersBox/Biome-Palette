package me.engineersbox.menuinv;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {

	public static ItemStack tool = new ItemStack(Material.STONE_AXE);
	
		static {
			ItemMeta im = tool.getItemMeta();
			im.setDisplayName(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "Biome " + ChatColor.DARK_AQUA + "Tool" + ChatColor.DARK_RED + "]");
			im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			ArrayList<String> Lore = new ArrayList<String>();
			Lore.add(ChatColor.YELLOW + "Alters Block Specific Biomes");
			im.setLore(Lore);
			tool.setItemMeta(im);
		}
}
