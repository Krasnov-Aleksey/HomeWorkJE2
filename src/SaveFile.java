import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
    public static void saveFile(String path, String text){
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
