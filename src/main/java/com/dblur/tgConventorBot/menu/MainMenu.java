package com.dblur.tgConventorBot.menu;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static com.dblur.tgConventorBot.command.CommandList.*;

public class MainMenu {

    private final String INFORMATION_BUTTON = INFORMATION.getCommandName();
    private final String HELP_BUTTON = HELP.getCommandName();
    private final String STOP_BUTTON = STOP.getCommandName();

    private final String CANCEL_BUTTON = CANCEL.getCommandName();
    private final String BACK_BUTTON = BACK.getCommandName();

    private final String SOURCE_CODE_BUTTON = SOURCE_CODE.getCommandName();
    private final String HOW_TO_USE_BUTTON = HOW_TO_USE.getCommandName();
    private final String ABOUT_BUTTON = ABOUT.getCommandName();
//    private String  = "";
//    private String  = "";
//    private String  = "";

    public ReplyKeyboardMarkup menu(Update update) {
        if (update.hasMessage() && update.getMessage().getText() != null) {
            String message = update.getMessage().getText().trim();

            if (message.equals(INFORMATION_BUTTON)) {
                return informationMenuButton();
            } else if (message.equals(BACK_BUTTON)) {
                return mainMenuButton();
            }
        }
        return mainMenuButton();
    }

    private ReplyKeyboardMarkup mainMenuButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add(INFORMATION_BUTTON);
        keyboard.add(row);

        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup informationMenuButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(HOW_TO_USE_BUTTON);
        keyboard.add(row);

        row = new KeyboardRow();
        row.add(SOURCE_CODE_BUTTON);
        keyboard.add(row);

        row = new KeyboardRow();
        row.add(ABOUT_BUTTON);
        row.add(BACK_BUTTON);
        keyboard.add(row);

        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }
}
