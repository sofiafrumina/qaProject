package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestDataLoader {

    public static List<String> loadUrlsFromFile(String relativeFilePath) throws IOException {
        Path absolutePath = Paths.get(relativeFilePath);

        // Проверяем, существует ли файл
        if (!Files.exists(absolutePath)) {
            throw new IOException("Файл не найден: " + absolutePath.toString());
        }

        // Создаем ObjectMapper для чтения JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Чтение JSON файла и преобразование его в список строк
        List<String> urls = objectMapper.readValue(new File(absolutePath.toString()), List.class);

        // Выводим каждую строку в консоль
        for (String url : urls) {
            System.out.println(url);
        }

        return urls;
    }
}