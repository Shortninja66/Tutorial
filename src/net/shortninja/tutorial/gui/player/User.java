package net.shortninja.tutorial.gui.player;

import java.util.UUID;

import net.shortninja.tutorial.gui.player.attribute.AbstractGui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class User
{
	private UUID uuid;
	private AbstractGui currentGui;
	private boolean isOnline = true;
	
	public User(UUID uuid)
	{
		this.uuid = uuid;
	}
	
	public UUID getUuid()
	{
		return uuid;
	}
	
	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}
	
	public AbstractGui getCurrentGui()
	{
		return currentGui;
	}
	
	public boolean isOnline()
	{
		return isOnline;
	}
	
	public void setCurrentGui(AbstractGui currentGui)
	{
		this.currentGui = currentGui;
	}
	
	public void setOnline(boolean isOnline)
	{
		this.isOnline = isOnline;
	}
}