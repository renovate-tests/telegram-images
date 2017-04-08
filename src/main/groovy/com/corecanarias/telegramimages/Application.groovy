package com.corecanarias.telegramimages

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

/**
 * TODO: Include javadoc
 */
@SpringBootApplication
class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot()
        bot.initialize()

//        new Application()
//                .configure(new SpringApplicationBuilder(Application.class))
//                .run(args);
    }
}
