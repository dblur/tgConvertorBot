package com.dblur.tgConventorBot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message, Update update);
}
