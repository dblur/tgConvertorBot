package com.dblur.tgConventorBot.command.commandsImpl;


import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String NO_MESSAGE = "❗ Я не понимаю данной команды. ❗\n"
            + "Чтобы использовать корректную команду - используйте кнопки в меню";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE, update);
    }
}
