package com.eminesezer.surveyapp.config;

import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration()
@EnableJpaRepositories(basePackages = {"com.eminesezer.surveyapp.repository"})
@EntityScan(basePackages = {"com.eminesezer.surveyapp.entity"})
@ComponentScan(basePackages = {"com.eminesezer.surveyapp.*"})
@EnableCaching
@EnableAsync
@EnableScheduling
public class CoreConfig {
    @Autowired
    private Environment env;

    @Bean
    public JdkRegexpMethodPointcut getJdkRegexpMethodPointcut() {
        JdkRegexpMethodPointcut jrm = new JdkRegexpMethodPointcut();
        jrm.setPatterns("com.eminesezer.surveyapp.controller.*Controller.*");
        return jrm;
    }
}
