package me.drac.sc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable() {

		Bukkit.getConsoleSender().sendMessage("§a[Dra§dcStaff§a] §aPlugin Habilitado!");

		registrarComandos();
		registrarEventos();
	}

	public void registrarEventos() {

		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new Chat(this), this);
	}

	public void registrarComandos() {

		getCommand("sc").setExecutor(new Comando(this));
		
	}

	public void onDisable() {

		Bukkit.getConsoleSender().sendMessage("§a[Dra§dcStaff§a] §cPlugin Desabilitado!");

	}
	
}
