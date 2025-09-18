package com.learn.aop.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("com.learn.aop.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.beanPackageConfig()") // when
	public void logMethodCallBeforeExecution(JoinPoint JoinPoint) {
		logger.info("Before Aspect - Method is called - {} is called with arguments: {}", JoinPoint,
				JoinPoint.getArgs()); // what
	}

	@After("com.learn.aop.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()") // when
	public void logMethodCallAfterExecution(JoinPoint JoinPoint) {
		logger.info("After Aspect - {} has executed", JoinPoint); // what
	}

	@AfterThrowing(pointcut = "com.learn.aop.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", throwing = "exception") // when
	public void logMethodCallAfterThrowExecution(JoinPoint JoinPoint, Exception exception) {
		logger.info("After Throwing Aspect - {} has thrown an exception {}", JoinPoint, exception); // what
	}

	@AfterReturning(pointcut = "com.learn.aop.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", returning = "resultValue") // when
	public void logMethodCallAfterReturingExecution(JoinPoint JoinPoint, Object resultValue) {
		logger.info("After Returing Aspect - {} has returnd {}", JoinPoint, resultValue); // what
	}
}
