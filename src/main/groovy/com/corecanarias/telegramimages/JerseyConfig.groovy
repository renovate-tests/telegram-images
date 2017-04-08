package com.corecanarias.telegramimages

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

/**
 * TODO: Include javadoc
 */
@Component
class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RestExample.class);
    }
}
