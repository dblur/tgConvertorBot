package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = """
            ✨<b>Помощь:</b>✨

            <b>Если возникли трудности с работоспособностью бота. Или есть пожелания и предложения:</b>
            @dimka_blur - написать автору""";

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE, update);
    }
}
