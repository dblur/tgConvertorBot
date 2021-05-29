package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HowToUseCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String HOW_TO_USE_MESSAGE = """
            ❗ Для создания PDF документа необходимо прислать боту исходные картинки. ❗
            
            📃 После нужно будет выбрать: создание общего PDF документа, либо отдельно на каждую картинку.
            📃 Далее необходимо будет написать название документа.
            
            ⌛ Создание документа может занимать какое-то время. 
            Возможно нужно будет немного подождать. 
            Все зависит от нагрузки.
            
            ❗ <b>В случае возникновения проблем, свяжитесь с автором - @dimka_blur</b> ❗""";

    public HowToUseCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HOW_TO_USE_MESSAGE, update);
    }
}
