package net.shortninja.tutorial.abstraction;

import net.shortninja.tutorial.abstraction.compatibility.VersionHandler;
import net.shortninja.tutorial.abstraction.compatibility.v1_7.Handler_1_7_R1;
import net.shortninja.tutorial.abstraction.compatibility.v1_7.Handler_1_7_R2;
import net.shortninja.tutorial.abstraction.compatibility.v1_7.Handler_1_7_R3;
import net.shortninja.tutorial.abstraction.compatibility.v1_7.Handler_1_7_R4;
import net.shortninja.tutorial.abstraction.compatibility.v1_8.Handler_1_8_R1;
import net.shortninja.tutorial.abstraction.compatibility.v1_8.Handler_1_8_R2;
import net.shortninja.tutorial.abstraction.compatibility.v1_8.Handler_1_8_R3;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin
{
	private static Tutorial plugin;
	private VersionHandler versionHandler;
	private String uuid;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		getServerVersion();
	}
	
	public void onDisabe()
	{
		plugin = null;
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
			Player player = (Player) sender;
			Location location = player.getLocation();
			Entity entity = null;
			
			if(uuid == null)
			{
				entity = location.getWorld().spawnCreature(location, EntityType.WOLF);
				uuid = entity.getUniqueId().toString();
			}else
			{
				for(Entity e : location.getWorld().getEntities())
				{
					if(e.getUniqueId().toString().equals(uuid))
					{
						entity = e;
						break;
					}
				}
			}
			
			versionHandler.followPlayer(player, entity);
		}
		
		return true;
	}
	
	private void getServerVersion()
	{
		String version = Bukkit.getServer().getClass().getPackage().getName();
		
		version = version.substring(version.lastIndexOf('.') + 1);
		
		switch(version)
		{
			case "v1_7_R1":
				versionHandler = new Handler_1_7_R1();
				break;
			case "v1_7_R2":
				versionHandler = new Handler_1_7_R2();
				break;
			case "v1_7_R3":
				versionHandler = new Handler_1_7_R3();
				break;
			case "v1_7_R4":
				versionHandler = new Handler_1_7_R4();
				break;
			case "v1_8_R1":
				versionHandler = new Handler_1_8_R1();
				break;
			case "v1_8_R2":
				versionHandler = new Handler_1_8_R2();
				break;
			case "v1_8_R3":
				versionHandler = new Handler_1_8_R3();
				break;
		}
		
		if(versionHandler == null)
		{
			// This version is not supported.
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
}
