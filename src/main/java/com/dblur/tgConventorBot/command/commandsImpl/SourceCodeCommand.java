package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SourceCodeCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String DESCRIPTION_COURSE_CODE_MESSAGE = "Ссылка на репозиторий с кодом ⬇";
    public static final String COURSE_CODE_MESSAGE = "github.com/dblur/tgConvertorBot";

    public SourceCodeCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), DESCRIPTION_COURSE_CODE_MESSAGE, update);
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), COURSE_CODE_MESSAGE, update);
    }
}
