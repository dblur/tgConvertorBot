package com.dblur.tgConventorBot.definder;

import com.dblur.tgConventorBot.bot.TelegramBot;
import com.dblur.tgConventorBot.command.CommandContainer;
import com.dblur.tgConventorBot.service.SendBotMessageServiceImpl;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dblur.tgConventorBot.command.CommandList.NO;
import static com.dblur.tgConventorBot.command.CommandList.NOT_IMAGE;

public class MessageDefinder {

    PhotoDefinder photoDefinder = new PhotoDefinder();

    public void defineTypeOfMessage(Update update, TelegramBot tgBot) {
        CommandContainer commandContainer = new CommandContainer(new SendBotMessageServiceImpl(tgBot));
        Message message = update.getMessage();
        if (update.hasMessage()) {
            if (message.getText() != null) {
                defineMessageLine(update, tgBot);
            } else if (message.getDocument() != null) {
                defineDocumentType(update, tgBot);
            } else if (message.getPhoto() != null) {
                photoDefinder.getMaxPhoto(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    private void defineMessageLine(Update update, TelegramBot tgBot) {
        CommandContainer commandContainer = new CommandContainer(new SendBotMessageServiceImpl(tgBot));
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            try {
                commandContainer.retrieveCommand(message).execute(update);
            } catch (Exception e) {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    private void defineDocumentType(Update update, TelegramBot tgBot) {
        CommandContainer commandContainer = new CommandContainer(new SendBotMessageServiceImpl(tgBot));
        if (update.hasMessage() && update.getMessage().getDocument() != null) {
            Document document = update.getMessage().getDocument();
            String documentType = document.getMimeType();
            if (!documentType.contains("image/")) {
                commandContainer.retrieveCommand(NOT_IMAGE.getCommandName()).execute(update);
            }
        }
    }
}
