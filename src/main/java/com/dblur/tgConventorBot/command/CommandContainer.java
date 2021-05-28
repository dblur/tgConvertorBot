package com.dblur.tgConventorBot.command;

import com.dblur.tgConventorBot.command.commandsImpl.*;
import com.dblur.tgConventorBot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.dblur.tgConventorBot.command.CommandName.*;


public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(NOT_IMAGE.getCommandName(), new NotImageCommand(sendBotMessageService))
                .put(UNKNOWN.getCommandName(), new UnknownCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
