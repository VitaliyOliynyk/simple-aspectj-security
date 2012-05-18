package eu.vitaliy.testaspectjsecurity;

import java.util.HashSet;
import java.util.Set;

public class PermissionStore {

	private static Set<ERole> permissions = new HashSet<ERole>();
	
	public static void addPermission(ERole role)
	{
		permissions.add(role);
	}
	
	public static boolean check(ERole role)
	{
		return permissions.contains(role);	
	}
}
