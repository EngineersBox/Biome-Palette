package me.engineersbox.menuinv;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new EventList(), this);
        getCommand("bp").setExecutor(new Commands());
        getCommand("bp help").setExecutor(new Commands());
        getCommand("bp tool").setExecutor(new Commands());
    }
 
    @Override
    public void onDisable() {
     
    }
 
}