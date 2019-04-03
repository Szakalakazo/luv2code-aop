package com.luv2code.aopdemo.aspect.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.luv2code.aopdemo.aspect.before.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("\n======>>>> Logging to cloud in async fashion");
    }
}