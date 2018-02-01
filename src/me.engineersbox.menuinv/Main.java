package me.engineersbox.menuinv;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	static FileConfiguration config;
	static File cfile;
	
	//Global Strings
	public static String biome = "";
	public static String prefix = ChatColor.DARK_RED + "[" + ChatColor.GOLD + "BlockPalette" + ChatColor.DARK_RED + "] ";
	public static Integer getB = 0;
	public static Integer chunkinfo = 0;
	
    @Override
    public void onEnable() {
    	
    	config = getConfig();
    	config.options().copyDefaults(true);
    	saveConfig();
    	cfile = new File(getDataFolder(), "config.yml");
    	
        Bukkit.getServer().getPluginManager().registerEvents(new EventList(), this);
        
        getCommand("bp").setExecutor(new Commands());
        getCommand("bp help").setExecutor(new Commands());
        getCommand("bp tool").setExecutor(new Commands());
        getCommand("bp setbiome").setExecutor(new Commands());
        getCommand("bp getbiome").setExecutor(new Commands());
        getCommand("bp biomelist").setExecutor(new Commands());
        getCommand("bp chunkinfo").setExecutor(new Commands());
        getCommand("bp version").setExecutor(new Commands());
        getCommand("bp reload").setExecutor(new Commands());
    }
 
    @Override
    public void onDisable() {
     
    }
    
}