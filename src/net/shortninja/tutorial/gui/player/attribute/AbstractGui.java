package net.shortninja.tutorial.gui.player.attribute;

import java.util.HashMap;
import java.util.Map;

import net.shortninja.tutorial.gui.Tutorial;
import net.shortninja.tutorial.gui.player.UserManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractGui
{
	private UserManager userManager = Tutorial.get().userManager;
	private Inventory inventory;
	private Map<Integer, AbstractAction> actions = new HashMap<Integer, AbstractAction>();
	
	public AbstractGui(int slots, String title, Player player)
	{
		this.inventory = Bukkit.createInventory(null, slots, title);
		
		player.openInventory(getInventory());
		userManager.get(player.getUniqueId()).setCurrentGui(this);
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}
	
	public AbstractAction getAction(int slot)
	{
		return actions.get(slot);
	}
	
	public void setItem(ItemStack item, int slot, AbstractAction action)
	{
		inventory.setItem(slot, item);
		actions.put(slot, action);
	}
	
	public interface AbstractAction
	{
		void click(Player player);
	}
}