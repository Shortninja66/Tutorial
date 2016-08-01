package net.shortninja.tutorial.gui.listener;

import java.util.UUID;

import net.shortninja.tutorial.gui.Tutorial;
import net.shortninja.tutorial.gui.player.UserManager;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener
{
	private UserManager userManager = Tutorial.get().userManager;
	
	public PlayerQuit()
	{
		Bukkit.getPluginManager().registerEvents(this, Tutorial.get());
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onJoin(PlayerQuitEvent event)
	{
		UUID uuid = event.getPlayer().getUniqueId();
		
		userManager.get(uuid).setOnline(false);
	}
}