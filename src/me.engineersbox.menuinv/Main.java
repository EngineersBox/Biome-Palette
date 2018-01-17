package me.engineersbox.menuinv;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		
		this.getLogger().info("BlockPalette Enabled");
	     
        getCommand("blockpalette").setExecutor(new Cmd());
		
	}
	
}
