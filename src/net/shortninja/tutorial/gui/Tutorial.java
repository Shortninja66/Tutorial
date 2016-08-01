package net.shortninja.tutorial.gui;

import net.shortninja.tutorial.gui.listener.InventoryClick;
import net.shortninja.tutorial.gui.listener.InventoryClose;
import net.shortninja.tutorial.gui.listener.PlayerJoin;
import net.shortninja.tutorial.gui.listener.PlayerQuit;
import net.shortninja.tutorial.gui.player.User;
import net.shortninja.tutorial.gui.player.UserManager;
import net.shortninja.tutorial.gui.player.attribute.ColorGui;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin
{
	private static Tutorial plugin;
	public UserManager userManager;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		userManager = new UserManager();
		new InventoryClick();
		new InventoryClose();
		new PlayerJoin();
		new PlayerQuit();
		load();
	}
	
	@Override
	public void onDisable()
	{
		plugin = null;
		userManager = null;
	}
	
	public static Tutorial get()
	{
		return plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(label.equalsIgnoreCase("test") && sender instanceof Player)
		{
			new ColorGui(27, "Colors", (Player) sender);
		}
		
		return true;
	}
	
	private void load()
	{
		for(Player player : Bukkit.getOnlinePlayers())
		{
			userManager.add(new User(player.getUniqueId()));
		}
	}
}