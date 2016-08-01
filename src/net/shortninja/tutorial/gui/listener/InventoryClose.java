package net.shortninja.tutorial.gui.listener;

import net.shortninja.tutorial.gui.Tutorial;
import net.shortninja.tutorial.gui.player.UserManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener
{
	private UserManager userManager = Tutorial.get().userManager;
	
	public InventoryClose()
	{
		Bukkit.getPluginManager().registerEvents(this, Tutorial.get());
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onClose(InventoryCloseEvent event)
	{
		Player player = (Player) event.getPlayer();
		
		userManager.get(player.getUniqueId()).setCurrentGui(null);
	}
}