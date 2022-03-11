package com.example.demo.advices;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class LoggingAdvice {

	@Before("execution(* com.example.demo.service.CurrencyConverterService.*(..))")
	public void logInfo(JoinPoint jp) {
		
		System.out.println(jp.getSignature().getName()+"Called");
		Object args[] =jp.getArgs();
		System.out.println("Argument : " + args[0]);
	}
	
}
