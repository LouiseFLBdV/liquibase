package com.example.liquibase;

import com.example.liquibase.awsUtil.AmazonGetParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiquibaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquibaseApplication.class, args);
        System.out.println("--------------------------");
        System.out.println(AmazonGetParameter.getParameter("DBUserNames"));
        System.out.println("--------------------------");
    }

}
