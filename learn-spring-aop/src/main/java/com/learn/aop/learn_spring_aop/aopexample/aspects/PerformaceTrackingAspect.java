package com.learn.aop.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformaceTrackingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Around("com.learn.aop.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotationConfig()")
	public Object findExcutionTime(ProceedingJoinPoint procedingJoinPoint) throws Throwable {
		long startTimer = System.currentTimeMillis();
		Object returnValue = procedingJoinPoint.proceed(); // Pointcut package start executed

		long endTimer = System.currentTimeMillis();
		long executionTime = endTimer - startTimer;

		logger.info("Around Aspect Track Time - {} Method executed in {}", procedingJoinPoint, executionTime);

		return returnValue;
	}
}
