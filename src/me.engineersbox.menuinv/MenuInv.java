package me.engineersbox.menuinv;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class MenuInv extends JavaPlugin implements Listener {
	
        private Menu menu;
        
        public void onEnable() {
                menu = new Menu(this);
                Bukkit.getServer().getPluginManager().registerEvents(this, this);
        }
        
        @SuppressWarnings("deprecation")
		@EventHandler
    	public void onPlayerUse(PlayerInteractEvent event){
    	    Player p = event.getPlayer();
    	 
    	    if(p.getItemInHand().getType() == Material.BLAZE_POWDER){
    	    	menu.show(event.getPlayer());
    	    }
    	}
}
