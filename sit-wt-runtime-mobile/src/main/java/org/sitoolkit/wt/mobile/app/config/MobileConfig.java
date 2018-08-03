package org.sitoolkit.wt.mobile.app.config;

import org.sitoolkit.wt.mobile.domain.MobileDriverManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileConfig {

    @Bean
    public MobileDriverManager mobileDriverManager() {
        return new MobileDriverManager();
    }

}
