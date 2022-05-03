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
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) { // Explode yourself
				player.getWorld().createExplosion(player.getLocation(), 8);
				return true;
			}
			ArrayList<String> failed = new ArrayList<>();
			for (String arg : args) {
				Player target = Bukkit.getPlayer(arg);
				if (target == null) {
					failed.add(arg);
					continue;
				}
				target.getWorld().createExplosion(target.getLocation(), 8);
			}
			if (failed.size() != 0) {
				player.sendMessage("§cFailed to explode: " + failed);
			}
			return true;
		}
		return false;
	}
}
