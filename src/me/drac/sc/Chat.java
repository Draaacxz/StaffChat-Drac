package me.drac.sc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
	public Main plugin;

	public Chat(Main pl) {
		this.plugin = pl;
	}

	@EventHandler
	public void noChat(AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();

		String Prefix = "§d§l[S]";
		String msg = e.getMessage();

		if (Comando.Staff.contains(p)) {
			
			e.setCancelled(true);
			if (p.hasPermission("drac.sc.ver")) {
				
				for (Player Staff : Bukkit.getServer().getOnlinePlayers()) {
					
					if (Staff.hasPermission("drac.sc.ver")) {
						
						Staff.sendMessage(Prefix + " §f" + p.getDisplayName() + "§f: " + "§f" + msg);
						
					}
				}
			}
		}

	}

}
