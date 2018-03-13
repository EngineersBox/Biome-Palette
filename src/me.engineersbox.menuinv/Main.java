package me.engineersbox.menuinv;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.engineersbox.menuinv.InvConfig;

public class Main extends JavaPlugin implements Listener {
	
	static FileConfiguration config;
	static File cfile;
	
	//Global Strings
	public static String biome = "";
	public static String prefix = ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] ";
	public static Integer getB = 0;
	public static Integer chunkinfo = 0;
	public static String mater = "";
	public static String inv = null;
	
    public void onEnable() {
    	
    	if (!getDataFolder().exists()) {
    		getDataFolder().mkdirs();
    	}
    	
    	new InvConfig(this);
    	
    	Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new EventList(), this);
        
        getCommand("bp").setExecutor(new Commands());
        getCommand("bp help").setExecutor(new Commands());
        getCommand("bp tool").setExecutor(new Commands());
        getCommand("bp setbiome").setExecutor(new Commands());
        getCommand("bp getbiome").setExecutor(new Commands());
        getCommand("bp biomelist").setExecutor(new Commands());
        getCommand("bp chunkinfo").setExecutor(new Commands());
        getCommand("bp version").setExecutor(new Commands());
        getCommand("bp settings").setExecutor(new Commands());
        getCommand("bp add").setExecutor(new Commands());
        getCommand("bp reload").setExecutor(new Commands());
    }
 
    @Override
    public void onDisable() {
    	AbstractFile.save();
    }
    
}