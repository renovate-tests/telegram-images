package com.corecanarias.telegramimages

import org.springframework.stereotype.Component

import javax.ws.rs.GET
import javax.ws.rs.Path

/**
 * TODO: Include javadoc
 */
@Component
@Path("/hello")
class RestExample {

    @GET
    public String message() {
        return "Hello ";
    }
}
