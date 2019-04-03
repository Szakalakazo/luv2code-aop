package com.luv2code.aopdemo.aspect.before;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.before.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n======>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        // display method args
        System.out.println("Method: " + methodSignature);

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object arg : args) {
            System.out.println(arg);

            if(arg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }
        }
    }
}