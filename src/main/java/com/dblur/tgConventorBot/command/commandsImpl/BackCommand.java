package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BackCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private static final String BACK_MESSAGE = "Загрузите файлы для конвертации или выберите нужный раздел";

    public BackCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), BACK_MESSAGE, update);
    }
}
