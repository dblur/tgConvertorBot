package com.dblur.tgConventorBot.command.commandsImpl;

import com.dblur.tgConventorBot.command.Command;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AboutBotCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private final static String ABOUT_MESSAGE = """
            Мы не храним какую-либо присланную информацию на серверах бота или в открытом доступе.
            Использование бота разрешено в любых целях.

            За присланную и сконвертированию информацию на изображениях автор бота не несет никакой ответсвенности.

            <b>Авторское право созданного бота принадлежит @dimka_blur</b>""";

    public AboutBotCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), ABOUT_MESSAGE, update);
    }
}
