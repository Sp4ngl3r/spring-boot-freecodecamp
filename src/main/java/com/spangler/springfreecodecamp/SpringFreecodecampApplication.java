package com.spangler.springfreecodecamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFreecodecampApplication {

    public static void main(String[] args) {

        /*
         * Following code is used to set the profile inside the Spring Application
         *
         * SpringApplication app = new SpringApplication(SpringFreecodecampApplication.class);
         * app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
         * ConfigurableApplicationContext configurableApplicationContext = app.run(args);
         *
         */

//        We can access the Bean Class either with the method name or any specified name
//        FirstBeanClass firstBeanClass = configurableApplicationContext.
//                getBean("firstBeanClass", FirstBeanClass.class);
//        or
//        FirstBeanClass firstBeanClass = configurableApplicationContext.
//                getBean("initialBean", FirstBeanClass.class);

//        ConfigurableApplicationContext configurableApplicationContext =
//                SpringApplication.run(SpringFreecodecampApplication.class, args);

//        InitialService initialService = configurableApplicationContext.getBean(InitialService.class);
//
//        System.out.println(initialService.printServiceData());
//
//        System.out.println("The Current Java version -> " + initialService.getCurrentJavaVersion());
//        System.out.println("The Current OS -> " + initialService.getCurrentOsName());
//        System.out.println("The Application Name stored in application.yml -> " + initialService.getCustomEnvironmentVariable());
//        System.out.println("The Database name stored in different env file -> " + initialService.getDatabaseNameFromAnotherEnvFile());
//        System.out.println("The Default error message -> " + initialService.getDefaultErrorMessage());
//        System.out.println("The App Region set in infra.properties -> " + initialService.getRegionValue());

        SpringApplication.run(SpringFreecodecampApplication.class);
    }
}
