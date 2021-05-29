package com.dblur.tgConventorBot.definder;

import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotoDefinder {

    PhotoSize getMaxPhoto(Update update) { // находим экземпляр фото с максимальным размером
        PhotoSize maxPhoto = new PhotoSize();
        if (update.hasMessage() && update.getMessage().getPhoto() != null) {
            List<PhotoSize> photo = update.getMessage().getPhoto();
            List<Integer> sizeList = new ArrayList<>();

            for (int i = 0; i < photo.size(); i++) {
                Integer fileSize = update.getMessage().getPhoto().get(i).getFileSize();
                sizeList.add(fileSize);
            }
            int maxSize = Collections.max(sizeList);
            int indexOfMaxSize = sizeList.indexOf(maxSize);
            maxPhoto = photo.get(indexOfMaxSize);
        }
        return maxPhoto;
    }
}
