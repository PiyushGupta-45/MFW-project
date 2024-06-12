
package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demo.service.*.*(..))")
    public void logBeforeServiceMethods(JoinPoint joinPoint) {
        logger.info("Before calling service method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.service.*.*(..))", returning = "result")
    public void logAfterServiceMethods(JoinPoint joinPoint, Object result) {
        logger.info("After calling service method: {}. Returned value: {}", joinPoint.getSignature().getName(), result);
    }

    @Before("execution(* com.example.demo.dao.*.*(..))")
    public void logBeforeDaoMethods(JoinPoint joinPoint) {
        logger.info("Before calling DAO method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.dao.*.*(..))", returning = "result")
    public void logAfterDaoMethods(JoinPoint joinPoint, Object result) {
        logger.info("After calling DAO method: {}. Returned value: {}", joinPoint.getSignature().getName(), result);
    }

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        logger.info("Before calling controller method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.controller.*.*(..))", returning = "result")
    public void logAfterControllerMethods(JoinPoint joinPoint, Object result) {
        logger.info("After calling controller method: {}. Returned value: {}", joinPoint.getSignature().getName(), result);
    }
}
