package com.example.demo.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@EnableAspectJAutoProxy
@Aspect
@Component
public class Proflier {

//	@Around("execution(* com.example.demo.service.CurrencyConverterService.*(..))")
//	public Object esttimateTime(ProceedingJoinPoint pjp) throws Throwable {
//		
//		System.out.println("Brfore Calling Method"+pjp.getSignature().getName()+"Called");
//		Object args[] =pjp.getArgs();
//		System.out.println("Argument to the method : " + args[0]);
//		
//		Object obj =pjp.proceed();
//		
//		System.out.println(" Method Completed Result := " + obj);
//		Double value =(Double) obj;		
//		return value -1.0;
//	}
	
	@Around("execution(* com.example.demo.service.CurrencyConverterService.*(..))")
	public Object esttimateTime(ProceedingJoinPoint pjp) throws Throwable {
		
		StopWatch watch = new StopWatch();
		watch.start();
		Object obj = pjp.proceed();
		watch.stop();
		System.out.println("Time Taken To complete in Milli seconds:="+watch.getTotalTimeMillis());
		return obj;
	}
	
	
}
