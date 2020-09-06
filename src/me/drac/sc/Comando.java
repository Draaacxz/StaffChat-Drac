package me.drac.sc;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {

	public Main plugin;

	public Comando(Main pl) {
		this.plugin = pl;
	}

	public static ArrayList<Player> Staff = new ArrayList<Player>();

	String Ativado = "§aVocê entrou no chat da §dSTAFF§a!";
	String Desativado = "§cVocê saiu do chat da §dSTAFF§c!";
	String Perm = "§cVocê precisa ser do grupo §eAjudante §cou superior para executar este comando.";

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cApenas para §7jogadores§c!");
				return true;
			}
			

			if (args.length == 0) {
				if (!p.hasPermission("drac.sc.use")) {
					p.sendMessage(Perm);
					return true;
				}
				
			}
			

			if (args.length == 0) {
				
				if (Staff.contains(p)) {
					
					Staff.remove(p);
					p.sendMessage(Desativado);
					
					return true;
					
				} else {
					
					Staff.add(p);
					p.sendMessage(Ativado);
					
				}
				
				if (args.length >= 1) {
					
					p.sendMessage("§cUse: /sc.");
					
					return true;
					
				}
			}
		}
		
		return false;
		
	}

}
