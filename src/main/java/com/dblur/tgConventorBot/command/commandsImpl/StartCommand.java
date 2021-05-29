package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.dblur.tgConventorBot.command.CommandList.*;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = String.format("""
                    Прикрепите файл изображения, чтобы начать конвертацию в PDF.

                    Для более подробной информации перейдите во вкладку <b>"%s"</b>""",
            INFORMATION.getCommandName());

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE, update);
    }
}
