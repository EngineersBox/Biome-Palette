package me.engineersbox.menuinv;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Leaves;
import org.bukkit.material.Sandstone;
import org.bukkit.material.LongGrass;
import org.bukkit.plugin.Plugin;

public class Menu implements Listener {
 
        private Inventory inv;
        private ItemStack f, d, s;
        
        public Menu(Plugin p) {
                inv = Bukkit.getServer().createInventory(null, 9, "Biome Palette");
                
                f = createItem(ChatColor.GREEN + "Forest");
                d = createItem1(ChatColor.YELLOW + "Desert");
                s = createItem2(ChatColor.RED + "Savanna");
                
                inv.setItem(2, f);
                inv.setItem(4, d);
                inv.setItem(6, s);
                
                Bukkit.getServer().getPluginManager().registerEvents(this, p);
        }
        
        @SuppressWarnings("deprecation")
		private ItemStack createItem(String name) {
                ItemStack i = new LongGrass(31, (byte) 1).toItemStack(1);
                ItemMeta im = i.getItemMeta();
                im.setDisplayName(name);
                im.setLore(Arrays.asList("Change Biome Pallete", "To " + name.toLowerCase()));
                i.setItemMeta(im);
                return i;
        }
        
        private ItemStack createItem1(String name) {
            ItemStack i = new Sandstone().toItemStack(1);
            ItemMeta im = i.getItemMeta();
            im.setDisplayName(name);
            im.setLore(Arrays.asList("Change Biome Pallete", "To " + name.toLowerCase()));
            i.setItemMeta(im);
            return i;
        }
        
        private ItemStack createItem2(String name) {
            ItemStack i = new Leaves().toItemStack(1);
            ItemMeta im = i.getItemMeta();
            im.setDisplayName(name);
            im.setLore(Arrays.asList("Change Biome Pallete", "To " + name.toLowerCase()));
            i.setItemMeta(im);
            return i;
        }
        
        public void show(Player p) {
                p.openInventory(inv);
        }
        
        @EventHandler
        public void onInventoryClick(InventoryClickEvent e) {
                if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
                if (e.getCurrentItem().getItemMeta() == null) return;
                if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Forest")) {
                        e.setCancelled(true);
                        ((Server) e.getWhoClicked()).createInventory(null, 9, "Forest");
                        e.getWhoClicked().closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Desert")) {
                        e.setCancelled(true);
                        ((Server) e.getWhoClicked()).createInventory(null, 9, "Desert");
                        e.getWhoClicked().closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Savanna")) {
                        e.setCancelled(true);
                        ((Server) e.getWhoClicked()).createInventory(null, 9, "Savanna");
                        e.getWhoClicked().closeInventory();
                }
        }
}