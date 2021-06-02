package com.dblur.tgConventorBot.bot;

import com.dblur.tgConventorBot.command.CommandContainer;
import com.dblur.tgConventorBot.definder.MessageDefinder;
import com.dblur.tgConventorBot.service.SendBotMessageServiceImpl;
import fileService.FileService;
import fileService.FileServiceImpl;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    FileService fileService;

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public TelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
        this.fileService = new FileServiceImpl();
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        MessageDefinder messageDefinder = new MessageDefinder();
        update.getUpdateId();
        messageDefinder.defineTypeOfMessage(update, this);
        String photo = fileService.getFilePath(update.getMessage().getPhoto().get(2));
        downloadPhoto(photo);
    }

    private File downloadPhoto(final String filePath) {
        try {
            return downloadFile(filePath);
        } catch (final TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
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

