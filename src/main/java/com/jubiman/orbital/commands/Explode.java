package com.jubiman.orbital.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Explode implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) { // Explode yourself only if player
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.getWorld().createExplosion(player.getLocation(), 8);
				sender.sendMessage("You exploded yourself!");
				return true;
			}
		}
		else {
			ArrayList<String> failed = new ArrayList<>();
			ArrayList<String> good = new ArrayList<>();
			for (String arg : args) {
				Player target = Bukkit.getPlayer(arg);
				if (target == null) {
					failed.add(arg);
					continue;
				}
				good.add(arg);
				target.getWorld().createExplosion(target.getLocation(), 8);
			}
			if (failed.size() != 0)
				sender.sendMessage("§cFailed to explode " + failed);
			if (good.size() != 0 )
				sender.sendMessage("Exploded " + good + "!");
			return true;
		}
		return false;
	}
}
