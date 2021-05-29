package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.dblur.tgConventorBot.command.CommandList.*;

public class InformationCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String INFORMATION_MESSAGE = String.format("""
                    ✨<b>Информация:</b>✨

                    <b>Начать/закончить работу с ботом:</b>
                    ⚙ %s - запустить бота.
                    ⚙ %s - приостановить бота.

                    ⚙ <b>%s</b> - прочитать инструкцию по использованию.
                    ⚙ <b>%s</b> - посмотреть исходный код на Github.
                    ⚙ <b>%s</b> - прочая информация.""",
            START.getCommandName(),
            STOP.getCommandName(),
            HOW_TO_USE.getCommandName(),
            SOURCE_CODE.getCommandName(),
            ABOUT.getCommandName());

    public InformationCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), INFORMATION_MESSAGE, update);
    }
}
