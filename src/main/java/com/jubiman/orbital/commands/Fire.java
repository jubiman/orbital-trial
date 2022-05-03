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
		if (args.length == 0) { // Set yourself on fire only if player
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.setFireTicks(60);
				sender.sendMessage("You set yourself on fire!");
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
				target.setFireTicks(60);
			}
			if (failed.size() != 0)
				sender.sendMessage("§cFailed to set " + failed + " on fire.");
			if (good.size() != 0 )
				sender.sendMessage("Set " + good + " on fire!");
			return true;
		}
		return false;
	}
}
