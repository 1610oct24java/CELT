package com.revature.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	private static Logger log = Logger.getRootLogger();
	private String dashes = "\n==========================================================================================================================================================================";
	
	@Around("execution(* com.revature..*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Logger works so wtf");
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		String methodClass = signature.getDeclaringTypeName().toString();
		String method = signature.getName().toString();
		Object result;
		
		logDashes();
		
		log.trace(methodClass + " ==> " + method);
		Object[] args = pjp.getArgs();
		for(int i = 0; i < args.length; i++){
			log.trace("Argumetnt #"+i+": "+args[i]);
		}
		
		log.trace("Executing...");
		result = pjp.proceed();
		
		log.trace(methodClass + " ==> " + method + " - Exit\nReturning: " + result);

		logDashes();
		return result;
	}
	
	@AfterThrowing(pointcut="execution(* com.revature..*(..))", throwing="e")
	public void stackTraceLogging(Exception e){
		log.error(dashes);
		for(StackTraceElement st : e.getStackTrace()){
			log.error(st.getMethodName() + " at line " + st.getLineNumber());
		}
		log.error(dashes);
	}

	private void logDashes(){
		log.trace(dashes);
	}
}