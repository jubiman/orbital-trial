package com.jubiman.orbital;

import com.jubiman.orbital.commands.Explode;
import com.jubiman.orbital.commands.Fire;
import com.jubiman.orbital.commands.Lightning;
import org.bukkit.plugin.java.JavaPlugin;

public final class Orbital extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		this.getCommand("fire").setExecutor(new Fire());
		this.getCommand("lightning").setExecutor(new Lightning());
		this.getCommand("smite").setExecutor(new Lightning());
		this.getCommand("explode").setExecutor(new Explode());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
