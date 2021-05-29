package com.dblur.tgConventorBot.service;

import com.dblur.tgConventorBot.bot.TelegramBot;
import com.dblur.tgConventorBot.menu.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final TelegramBot tgBot;
    public Update update;

    @Autowired
    public SendBotMessageServiceImpl(TelegramBot tgBot) {
        this.tgBot = tgBot;
    }

    public SendBotMessageServiceImpl(TelegramBot tgBot, Update update) {
        this.tgBot = tgBot;
        this.update = update;
    }

    @Override
    public void sendMessage(String chatId, String message, Update update) {
        MainMenu mainMenu = new MainMenu();
        ReplyKeyboardMarkup menu = mainMenu.menu(update);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(menu);

        try {
            tgBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
