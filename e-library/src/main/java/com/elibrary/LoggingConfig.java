package com.elibrary;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingConfig {
	
	private Logger LOGGER=LoggerFactory.getLogger(this.getClass());
	
	@Before("within(com.elibrary.controller.LibrarianController) && execution(public * *(..))")
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		LOGGER.info("==>Inside "+joinPoint.toString());
	}
}
