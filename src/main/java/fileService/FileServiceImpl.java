package fileService;

import com.dblur.tgConventorBot.bot.TelegramBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.objects.File;

@Service
public class FileServiceImpl implements FileService  { //TODO решить проблему с получением файлов

    @Override
    public String getFilePath(final PhotoSize photo) {
//        if (photo.getFilePath() != null) {
//            return photo.getFilePath();
//        }
//        final GetFile getFileMethod = new GetFile();
//        getFileMethod.setFileId(photo.getFileId());
//        try {
//            final File file = execute(getFileMethod);
//            return file.getFilePath();
//        } catch (final TelegramApiException e) {
//            e.printStackTrace();
//        }
        return null;
    }
//
//    private File execute(GetFile getFileMethod) throws TelegramApiException {
//        return TelegramBot.execute(getFileMethod);
//    }
}
