package net.shortninja.tutorial.abstraction.compatibility.v1_8;

import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.shortninja.tutorial.abstraction.compatibility.VersionHandler;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Handler_1_8_R1 implements VersionHandler
{
	@Override
	public void followPlayer(Player player, Entity entity)
	{
		Object craftEntity = ((CraftEntity) entity).getHandle();
		Location location = player.getLocation();
		
		((EntityInsentient) craftEntity).getNavigation().a(location.getBlockX(), location.getBlockY(), location.getBlockZ(), 1.0);
	}
}