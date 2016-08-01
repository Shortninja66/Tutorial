package net.shortninja.tutorial.gui.listener;

import java.util.UUID;

import net.shortninja.tutorial.gui.Tutorial;
import net.shortninja.tutorial.gui.player.User;
import net.shortninja.tutorial.gui.player.UserManager;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener
{
	private UserManager userManager = Tutorial.get().userManager;
	
	public PlayerJoin()
	{
		Bukkit.getPluginManager().registerEvents(this, Tutorial.get());
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onJoin(PlayerJoinEvent event)
	{
		UUID uuid = event.getPlayer().getUniqueId();
		
		if(userManager.has(uuid))
		{
			userManager.get(uuid).setOnline(true);
		}else userManager.add(new User(uuid));
	}
}