package com.pgleon.cboot;

import com.pgleon.cboot.config.EmbeddedJettyConfig;
import com.pgleon.cboot.config.CBootWebMvcConfig;
import org.springframework.context.annotation.Import;

@Import({EmbeddedJettyConfig.class, CBootWebMvcConfig.class})
public class BaseApplication {
    static {
        System.setProperty("dubbo.application.logger", "slf4j");
    }

}
