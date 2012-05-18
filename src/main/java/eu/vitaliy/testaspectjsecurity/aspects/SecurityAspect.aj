package eu.vitaliy.testaspectjsecurity.aspects;
import eu.vitaliy.testaspectjsecurity.Allow;
public aspect SecurityAspect {
	
	private SecurityAspectHelper helper =  new SecurityAspectHelper();
	
	pointcut byMethod() : execution(@Allow * *.*(..)) ;
	
	pointcut byClass() : execution(*  @Allow *.*(..)) 
		&&  !execution(@Allow * *.*(..));
	
	
	before() : byMethod(){
		helper.beforeMethod(thisJoinPoint);
	}
	
	before() : byClass(){
		helper.beforeClass(thisJoinPoint);
	}
}
