package net.shortninja.tutorial.gui.player.attribute;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ColorGui extends AbstractGui
{
	public ColorGui(int slots, String title, Player player)
	{
		super(slots, title, player);
		
		AbstractAction action = (p) ->
		{
			player.closeInventory();
			player.sendMessage("hi");
		};
		
		for(short i = 0; i < 15; i++)
		{
			setItem(glassItem(i), i, action);
		}
	}
	
	private ItemStack glassItem(short data)
	{
		return new ItemStack(Material.STAINED_GLASS_PANE, 1, data);
	}
}