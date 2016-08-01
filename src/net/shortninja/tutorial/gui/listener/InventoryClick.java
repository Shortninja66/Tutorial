package net.shortninja.tutorial.gui.listener;

import net.shortninja.tutorial.gui.Tutorial;
import net.shortninja.tutorial.gui.player.UserManager;
import net.shortninja.tutorial.gui.player.attribute.AbstractGui;
import net.shortninja.tutorial.gui.player.attribute.AbstractGui.AbstractAction;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener
{
	private UserManager userManager = Tutorial.get().userManager;
	
	public InventoryClick()
	{
		Bukkit.getPluginManager().registerEvents(this, Tutorial.get());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		AbstractGui currentGui = userManager.get(player.getUniqueId()).getCurrentGui();
		
		if(event.getCurrentItem() == null || currentGui == null)
		{
			return;
		}
		
		AbstractAction action = currentGui.getAction(event.getSlot());
		
		if(action != null)
		{
			action.click(player);
		}
	}
}