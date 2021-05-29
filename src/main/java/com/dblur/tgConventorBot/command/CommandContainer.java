package com.dblur.tgConventorBot.command;

import com.dblur.tgConventorBot.command.commandsImpl.*;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.dblur.tgConventorBot.command.CommandList.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(INFORMATION.getCommandName(), new InformationCommand(sendBotMessageService))
                .put(BACK.getCommandName(), new BackCommand(sendBotMessageService))

                .put(ABOUT.getCommandName(), new AboutBotCommand(sendBotMessageService))
                .put(SOURCE_CODE.getCommandName(), new SourceCodeCommand(sendBotMessageService))
                .put(HOW_TO_USE.getCommandName(), new HowToUseCommand(sendBotMessageService))

                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(NOT_IMAGE.getCommandName(), new NotImageCommand(sendBotMessageService))
                .build();
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.get(commandIdentifier);
    }
}
