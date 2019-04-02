package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from spring container
        AccountDAO accountDAO =
                context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO =
                context.getBean("membershipDAO", MembershipDAO.class);


        // call  the spring method
        Account myAccount = new Account();
        accountDAO.addAccount(myAccount, true);
        accountDAO.doWork();

        // call the accountDAMO getters/setters
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        membershipDAO.addSilly();
        membershipDAO.goToSleep();


        // close the context
        context.close();

    }
}
