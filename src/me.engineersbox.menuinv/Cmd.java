package me.engineersbox.menuinv;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

 
public class Cmd implements CommandExecutor {
        public static Inventory bp = Bukkit.createInventory(null, 9, "Block Biome Palette");
        // The first parameter, is the inventory owner. I make it null to let everyone use it.
        //The second parameter, is the slots in a inventory. Must be a multiple of 9. Can be up to 54.
        //The third parameter, is the inventory name. This will accept chat colors
        static {
                bp.setItem(0, new ItemStack(Material.DIRT, 1));
                bp.setItem(8, new ItemStack(Material.GOLD_BLOCK, 1));
        }
        @EventHandler
        public void onInventoryClick(InventoryClickEvent event) {
        	Player player = (Player) event.getWhoClicked(); // The player that clicked the item
        	ItemStack clicked = event.getCurrentItem(); // The item that was clicked
        	Inventory inventory = event.getInventory(); // The inventory that was clicked in
        	if (inventory.getName().equals(bp.getName())) { // The inventory is our custom Inventory
        		if (clicked.getType() == Material.DIRT) { // The item that the player clicked it dirt
        			event.setCancelled(true); // Make it so the dirt is back in its original spot
        			player.closeInventory(); // Closes there inventory
        			player.getInventory().addItem(new ItemStack(Material.DIRT, 1)); // Adds dirt
        		}
        	}
        }
		@Override
		public boolean onCommand(CommandSender sender, Command arg1, String label, String[] arg3) {
			if (label.equalsIgnoreCase("blockpalette")) {
				
				Player player = (Player) sender;
				player.openInventory(bp);
				return true;
			}
			return false;
		}
}