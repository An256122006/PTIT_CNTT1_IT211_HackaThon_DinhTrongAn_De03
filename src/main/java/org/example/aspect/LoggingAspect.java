package org.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* org.example.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("Method: {} ",joinPoint.getSignature().getName());
    }
}
