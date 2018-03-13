package me.engineersbox.menuinv;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import me.engineersbox.menuinv.Main;

public class AbstractFile {
	
	protected Main main;
	private static File file;
	protected static FileConfiguration config;
	
	public AbstractFile(Main main, String filename) {
		this.main = main;
		AbstractFile.file = new File(main.getDataFolder(), filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		AbstractFile.config = YamlConfiguration.loadConfiguration(file);
	}
	
	public static void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
