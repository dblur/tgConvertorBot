package com.dblur.tgConventorBot.command;

public enum CommandList {

    START("/start"),
    STOP("/stop"),
    HELP("Помощь"),
    INFORMATION("Информация"),

    CANCEL("Отмена..."),
    BACK("Назад"),

    SOURCE_CODE("Исходный код"),
    HOW_TO_USE("Как использовать?"),
    ABOUT("О боте"),

    NO("noCommand"),
    NOT_IMAGE("noImage");

    private final String commandName;

    CommandList(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
