package eu.vitaliy.testaspectjsecurity;

public class ClassA {
	
	public void mWithoutPermission()
	{
		System.out.println("Method ClassA.mWithoutPermission()");
	}
	
	@Allow({ ERole.USER, ERole.ADMIN})
	public void mUserAndAdmin()
	{
		System.out.println("Method ClassA.mUser()");
	}
	
	@Allow(ERole.ADMIN)
	public void mAdmin()
	{
		System.out.println("Method ClassA.mAdmin()");
	}
}
