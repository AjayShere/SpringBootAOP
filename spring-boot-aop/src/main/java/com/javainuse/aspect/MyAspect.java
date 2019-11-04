package com.javainuse.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Around(value = "@annotation(com.javainuse.interfac.customAnnotation)")
	public Object testAspectcall(ProceedingJoinPoint pjp) throws Throwable {
		long stratTime=System.currentTimeMillis();
		Object obj=pjp.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println("Method name"+pjp.getSignature()+" time taken to execute : "+(endTime-stratTime));
		System.out.println("After method: ");

		//System.out.println("Before method:  testAspectcall" + joinPoint.getSignature());
		return obj;

	}

}
