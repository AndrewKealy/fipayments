package com.neueda.payments.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepoLoggingAspect {

    @Pointcut("execution(* com.neueda.payments.repositories.*.* (..))")
    public void logRepoMethods() {}

    @Around("logRepoMethods()")
    public Object aroundRepoMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // do something BEFORE
        System.out.println("Starting repo method " + proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();

        // do something AFTER
        System.out.println("Exiting repo method");
        return result;
    }
}
