package eu.vitaliy.testaspectjsecurity;

public class MySecurityException extends RuntimeException{

	private static final long serialVersionUID = 707427433839579666L;

	public MySecurityException() {
		super();
	}
	
	public MySecurityException(String className, String methodName, ERole requiredRole )
	{
		super("\nTo perform the method "+className + "." + methodName + " should have the right "+ requiredRole.toString());
		
	}
	
}
