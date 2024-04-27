package com.spangler.springfreecodecamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfiguration {

    /*
     * Ways to Annotate a Bean
     *
     * @Bean("beanName")
     *
     * @Bean
     * @Qualifier("qualifierName")
     *
     * @Bean
     * @Primary
     *
     */

    /*
     *
     * To scope components or services for a particular environment, use:
     *
     * @Profile("profileName")
     *
     */

    @Bean
    @Primary
    public FirstBeanClass primaryBeanClass() {
        return new FirstBeanClass("Java Bean from Indonesia");
    }

    @Bean
    public FirstBeanClass secondaryBeanClass() {
        return new FirstBeanClass("Another Java Bean from Jamaica");
    }
}
