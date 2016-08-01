package net.shortninja.tutorial.gui.player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager
{
	private static Map<UUID, User> users = new HashMap<UUID, User>();
	
	public User get(UUID uuid)
	{
		return users.get(uuid);
	}
	
	public boolean has(UUID uuid)
	{
		return users.containsKey(uuid);
	}
	
	public void add(User user)
	{
		users.put(user.getUuid(), user);
	}
	
	public void remove(UUID uuid)
	{
		users.remove(uuid);
	}
}