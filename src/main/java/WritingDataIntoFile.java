import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WritingDataIntoFile {
    public void write(String fileName, List<String> resultSet){
        Path path = Path.of(System.getProperty("user.dir")+fileName);
        try {
            Files.write(path,resultSet);
            System.out.println("Writing ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
