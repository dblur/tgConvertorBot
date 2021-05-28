package com.dblur.tgConventorBot.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("noCommand"),
    NOT_IMAGE("noImage"),
    UNKNOWN("unknownCommand");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }


}
