package fileService;

import org.telegram.telegrambots.meta.api.objects.PhotoSize;

public interface FileService {
    String getFilePath(final PhotoSize photo);
}
