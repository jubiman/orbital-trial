package com.jubiman.orbital.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Lightning implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) { // Smite yourself only if player
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.getWorld().strikeLightning(player.getLocation());
				sender.sendMessage("You struck yourself with lightning!");
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
				target.getWorld().strikeLightning(target.getLocation());
			}
			if (failed.size() != 0)
				sender.sendMessage("§cFailed to smite " + failed);
				if (good.size() != 0 )
					sender.sendMessage("Struck " + good + " with lightning!");
			return true;
		}
		return false;
	}
}
