package eu.vitaliy.testaspectjsecurity2;

import eu.vitaliy.testaspectjsecurity.ERole;
import eu.vitaliy.testaspectjsecurity.Allow;

@Allow(ERole.USER)
public class ClassB {
	

	public void mUser1()
	{
		System.out.println("Method ClassB.mUser1()");
	}
	
	public void mUser2()
	{
		System.out.println("Metoda ClassB.mUser2()");
		mAdmin();
	}
	
	@Allow(ERole.ADMIN)
	private void mAdmin()
	{
		System.out.println("Metoda ClassB.mAdmin()");
	}
}
