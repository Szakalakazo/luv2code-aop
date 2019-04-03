package com.luv2code.aopdemo.aspect.returning;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class AfterReturningAdvice {


    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(
            JoinPoint joinPoint, List<Account> result) {


        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n+++++++ Executing after returning on method: " + method);

        System.out.println("Result before modification is: " + result);


        // convert thr account names to uppercase
        convertAccountToUpperCase(result);

        System.out.println("Result after modification is: " + result);


    }

    private void convertAccountToUpperCase(List<Account> result) {

        for (Account next : result) {
            next.setName(next.getName().toUpperCase());
            next.setLevel(next.getLevel().toUpperCase());
        }
    }
}






























