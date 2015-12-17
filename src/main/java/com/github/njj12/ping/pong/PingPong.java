package com.github.njj12.ping.pong;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PingPong extends JavaPlugin implements Listener {

	public static String prefix = "PingPong";

	/*
	 *   github first upload test plugin
	 */

	public void onEnable() {

		getCommand("ping").setExecutor(new Other());

	}
}