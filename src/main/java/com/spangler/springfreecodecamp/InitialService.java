package com.spangler.springfreecodecamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:database.properties")
@PropertySources({
        @PropertySource("classpath:database.properties"),
        @PropertySource("classpath:infra.properties"),
})
public class InitialService {

    private final FirstBeanClass firstBeanClass;
    private final Environment environmentVariables;

    @Value("404 Error")
    private String defaultErrorMessage;

    @Value("${database.profile.name}")
    private String databaseNameFromAnotherEnvFile;

    @Value("${app.region}")
    private String regionValue;

    /*
     * The below method is called Field Injection (Type of Dependency Injection), which is not recommended.
     *
     * @Autowired
     * private final FirstBeanClass firstBeanClass;
     *
     */

    // This method is called Constructor Injection.
    @Autowired
    public InitialService(
//            @Qualifier("secondary") FirstBeanClass firstBeanClass
            FirstBeanClass firstBeanClass,
            Environment environmentVariables
    ) {
        this.firstBeanClass = firstBeanClass;
        this.environmentVariables = environmentVariables;
    }

    /*
     * The third type of Injection is called Method Injection.
     *
     * @Autowired
     * public void injectDependenciesViaMethodInjection(FirstBeanClass firstBeanClass) {
     *      this.firstBeanClass = firstBeanClass;
     * }
     *
     */

    public String printServiceData() {
        return "Service receives Bean instance via Dependency Injection and able to print >> " + firstBeanClass.printFieldValue();
    }

    public String getCurrentJavaVersion() {
        return environmentVariables.getProperty("java.version");
    }

    public String getCurrentOsName() {
        return environmentVariables.getProperty("os.name");
    }

    // Return the environment variable set in application.yml files
    public String getCustomEnvironmentVariable() {
        return environmentVariables.getProperty("spring.application.name");
    }

    public String getDatabaseNameFromAnotherEnvFile() {
        return databaseNameFromAnotherEnvFile;
    }

    public String getDefaultErrorMessage() {
        return defaultErrorMessage;
    }

    public String getRegionValue() {
        return regionValue;
    }
}

