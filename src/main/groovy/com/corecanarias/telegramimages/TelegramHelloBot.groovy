package com.corecanarias.telegramimages

import org.telegram.telegrambots.api.methods.GetFile
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Message
import org.telegram.telegrambots.api.objects.PhotoSize
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.api.objects.File as TelegramFile

/**
 * TODO: Include javadoc
 */
class TelegramHelloBot extends TelegramLongPollingBot {
    private Img42Uploader img42Uploader = new Img42Uploader()

    @Override
    void onUpdateReceived(Update update) {

        if(update.hasMessage()) {
            Message message = update.getMessage();
            if(message.getPhoto() != null) {
                GetFile getFileRequest = new GetFile();
                PhotoSize photo = message.getPhoto().last()
                getFileRequest.setFileId(photo.getFileId());
                TelegramFile file = getFile(getFileRequest);

                File downloadedFile = img42Uploader.downloadImage("https://api.telegram.org/file/bot261215121:AAEZPdCKPMKx-UBBqNPaXtJZjKSSKsfBe_Q/${file.filePath}")
                String url = img42Uploader.uploadImage(downloadedFile.absolutePath)
                SendMessage msg = new SendMessage();
                msg.setChatId(message.getChatId().toString());

                println "*************************************"
                println "google url: ${url} click"
                println "*************************************"
                println "*************************************"
                println "*************************************"
                msg.setText("google url: ${url} click");
                sendMessage(msg)

            }
            if(message.hasText()) {
                println message
                SendMessage msg = new SendMessage();
                msg.enableMarkdown(true);
                msg.setChatId(message.getChatId().toString());

                msg.setText("google url:  click");
                sendMessage(msg)
            }
        }
    }

    @Override
    String getBotUsername() {
        return "ReverseImageCanariasBot"
    }

    @Override
    String getBotToken() {
        return "261215121:AAEZPdCKPMKx-UBBqNPaXtJZjKSSKsfBe_Q"
    }
}
