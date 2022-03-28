package com.springbootproject.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerMethodExecutionTimeAspect {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerMethodExecutionTimeAspect.class.getSimpleName());
    private static final String METHOD_NAME_EXECUTION_TIME_FORMAT = "{} in {} took {} milliseconds to execute.";
    
    @Around("within(com.springbootproject.controller..*) && bean(*Controller)")
    public Object logControllerMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        String methodName = joinPoint.getSignature().getName();
        Class<?> targetClass = joinPoint.getTarget().getClass();

        LOG.info(METHOD_NAME_EXECUTION_TIME_FORMAT, methodName, targetClass, executionTime);

        return proceed;
    }
}
