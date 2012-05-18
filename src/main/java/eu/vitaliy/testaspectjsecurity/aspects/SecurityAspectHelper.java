package eu.vitaliy.testaspectjsecurity.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import eu.vitaliy.testaspectjsecurity.Allow;
import eu.vitaliy.testaspectjsecurity.ERole;
import eu.vitaliy.testaspectjsecurity.PermissionStore;
import eu.vitaliy.testaspectjsecurity.MySecurityException;
enum ESecurytyType
{
	CLASS, METHOD
}

public class SecurityAspectHelper {
	

	void beforeMethod(JoinPoint pointcut)
	{
        before(pointcut, ESecurytyType.METHOD);
	}

	void beforeClass(JoinPoint pointcut)
	{
        before(pointcut, ESecurytyType.CLASS);
	}
	
	@SuppressWarnings("unchecked")
	void before(JoinPoint pointcut, ESecurytyType securytyType)
	{
		MethodSignature methodSignature = (MethodSignature) pointcut.getSignature();
		Method method = methodSignature.getMethod();
        System.out.println("#beforeMethod"+method.getName());
		Class clazz = pointcut.getTarget().getClass();
		Allow allow = null;
		if(securytyType == ESecurytyType.CLASS)
		{
			allow  = (Allow) clazz.getAnnotation(Allow.class);
		}else{
			allow = method.getAnnotation(Allow.class);
		}
		
		ERole[] role =  allow.value();
		for(ERole r : role)
		{
			if(!PermissionStore.check(r))
			{
				throw new MySecurityException( clazz.getName(),  method.getName(), r);
			}
		}
	
	}
	
}
