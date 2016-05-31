package net.shortninja.tutorial.abstraction.compatibility;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface VersionHandler
{
	public void followPlayer(Player player, Entity entity);
}