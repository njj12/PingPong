package com.github.njj12.ping.pong;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Other implements CommandExecutor {

	public String parm = "pingpong.cmd.use";

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("can't use from console");
			return true;
		}

		Player p = (Player) sender;

		if (!p.hasPermission(parm)) {
			p.sendMessage("§4pong");
			p.playSound(p.getLocation(), Sound.LAVA_POP, 100F, 100F);
			return true;
		}

		switch (args.length) {

		case 0:
			p.sendMessage("§a[yourping]:§3 " + getPing(p));
			break;
		case 1:
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				p.sendMessage("§3" + args[0] + " is offline");

			} else {
				p.sendMessage("§a[" + target.getName() + "'s ping]:§3 "
						+ getPing(target));
			}
			break;

		default:
			p.sendMessage("§7/ping <player's name>");
			break;
		}

		return true;
	}

	public int getPing(Player p) {

		return ((CraftPlayer) p).getHandle().ping;
	}

}