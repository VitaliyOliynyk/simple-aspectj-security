package eu.vitaliy.testaspectjsecurity;

import eu.vitaliy.testaspectjsecurity2.ClassB;

public class Main {
	public static void main(String[] args)
	{
		
		PermissionStore.addPermission(ERole.USER);
		PermissionStore.addPermission(ERole.ADMIN);
		
		ClassA a = new ClassA();
		a.mUserAndAdmin();
		a.mWithoutPermission();
		a.mAdmin();
		
		
		ClassB b = new ClassB();
		b.mUser1();
		b.mUser2();
		
	}
}
