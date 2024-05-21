package utiles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class testDataLoader {
    public static List<String> loadUrlsFromFile(String filePath) throws Exception {
        return Files.readAllLines(Paths.get(filePath));
    }
}
