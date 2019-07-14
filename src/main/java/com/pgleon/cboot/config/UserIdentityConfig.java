package com.pgleon.cboot.config;

import com.pgleon.cboot.service.UserIdentityService;
import com.pgleon.cboot.service.impl.UserIdentityServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: leon
 * @Date: 2019-07-14 15:43
 * @Description:
 */
@Configuration
@ConditionalOnMissingBean(UserIdentityService.class)
public class UserIdentityConfig {
    @Bean
    public UserIdentityService userIdentityService() {
        return new UserIdentityServiceImpl();
    }
}
