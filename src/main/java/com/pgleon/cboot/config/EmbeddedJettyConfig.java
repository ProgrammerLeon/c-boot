package com.pgleon.cboot.config;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Slf4jRequestLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: leon
 * @Date: 2019-06-27 09:36
 * @Description:
 */
@Configuration
public class EmbeddedJettyConfig {

    private static final Logger logger = LoggerFactory.getLogger(EmbeddedJettyConfig.class);

    private static final JettyServerCustomizer USE_SLF4J_REQUEST_LOG =
            (server) -> {
                server.setRequestLog(new Slf4jRequestLog() {{
                    super.setPreferProxiedForAddress(true);
                    super.setLogLatency(true);
                    super.setLogServer(true);
                    super.setLogTimeZone("GMT+8");
                }});
                server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
            };

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            if (factory instanceof JettyServletWebServerFactory) {
                ((JettyServletWebServerFactory) factory).addServerCustomizers(USE_SLF4J_REQUEST_LOG);
            } else {
                throw new IllegalArgumentException(
                        "Expected a Jetty container factory but encountered "
                                + factory.getClass());
            }

        };
    }


}