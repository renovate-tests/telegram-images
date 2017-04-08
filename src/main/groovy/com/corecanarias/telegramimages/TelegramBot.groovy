package com.corecanarias.telegramimages

import java.util.logging.Level;
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.logging.BotLogger

/**
 * TODO: Include javadoc
 */
class TelegramBot {

    void initialize() {
        BotLogger.setLevel(Level.INFO)
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new TelegramHelloBot())
    }
}
