package com.dblur.tgConventorBot.bot;

import com.dblur.tgConventorBot.command.CommandContainer;
import com.dblur.tgConventorBot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dblur.tgConventorBot.command.CommandList.*;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public TelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        defineTypeOfMessage(update);
    }

    private void defineTypeOfMessage(Update update) {
        Message message = update.getMessage();
        if (update.hasMessage()) {
            if (message.getText() != null) {
                defineMessageLine(update);
            } else if (message.getDocument() != null) {
                defineDocumentType(update);
            } else if (message.getPhoto() != null) {
                getMaxPhoto(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    private void defineMessageLine(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            try {
                commandContainer.retrieveCommand(message).execute(update);
            } catch (Exception e) {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    private void defineDocumentType(Update update) {
        if (update.hasMessage() && update.getMessage().getDocument() != null) {
            Document document = update.getMessage().getDocument();
            String documentType = document.getMimeType();
            if (!documentType.contains("image/")) {
                commandContainer.retrieveCommand(NOT_IMAGE.getCommandName()).execute(update);
            }
        }
    }

    private void getMaxPhoto(Update update) { // находим экземпляр фото с максимальным размером
        if (update.hasMessage() && update.getMessage().getPhoto() != null) {
            List<PhotoSize> photo = update.getMessage().getPhoto();
            List<Integer> sizeList = new ArrayList<>();

            for (int i = 0; i < photo.size(); i++) {
                Integer fileSize = update.getMessage().getPhoto().get(i).getFileSize();
                sizeList.add(fileSize);
            }
            int maxSize = Collections.max(sizeList);
            int indexOfMaxSize = sizeList.indexOf(maxSize);
            Object maxPhoto = photo.get(indexOfMaxSize);
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}

