package com.jubiman.orbital.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fire implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) { // Set yourself on fire
				player.setFireTicks(60);
				return true;
			}
			ArrayList<String> failed = new ArrayList<>();
			for (String arg : args) {
				Player target = Bukkit.getPlayer(arg);
				if (target == null) {
					failed.add(arg);
					continue;
				}
				target.setFireTicks(60);
			}
			if (failed.size() != 0) {
				player.sendMessage("§cFailed to set on fire: " + failed);
			}
			return true;
		}
		return false;
	}
}
