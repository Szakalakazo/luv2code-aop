package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.aopdemo")
public class DemoConfig {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(DemoConfig.class);


    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);





}
