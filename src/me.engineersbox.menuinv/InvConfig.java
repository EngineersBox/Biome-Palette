package me.engineersbox.menuinv;

import me.engineersbox.menuinv.Main;

public class InvConfig extends AbstractFile{

	public InvConfig(Main main) {
		
		super(main, "invconfig.yml");
		
	}

	public static void newInv(String block , String biome, String name) {
		config.set(biome, "");
		config.set(block, "");
		config.set(name, "");
	}
	
}
