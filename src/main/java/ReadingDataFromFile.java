import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadingDataFromFile {
    private List<String> firstSet;
    private List<String> secondSet;

    public ReadingDataFromFile() {
        firstSet = new ArrayList<>();
        secondSet = new ArrayList<>();
    }

    public void reading(String fileName){
        Path path = Path.of(System.getProperty("user.dir")+fileName);
        try {
            final List<String> list = Files.readAllLines(path);
            int firstSize = Integer.parseInt(list.get(0));
            int secondSize = Integer.parseInt(list.get(firstSize+1));
            for(int i=0;i<firstSize;i++){
                firstSet.add(list.get(i+1));
            }
            for (int i=0;i<secondSize;i++){
                secondSet.add(list.get(i+firstSize+2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFirstSet(){
        return firstSet;
    }

    public List<String> getSecondSet(){
        return secondSet;
    }
}
