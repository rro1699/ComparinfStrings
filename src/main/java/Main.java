public class Main {
    public static void main(String[] args) {


        ReadingDataFromFile readingDataFromFile = new ReadingDataFromFile();
        readingDataFromFile.reading("/input.txt");
        MatchingString matchingString = new MatchingString();
        matchingString.matching(readingDataFromFile.getFirstSet(),readingDataFromFile.getSecondSet());
        WritingDataIntoFile writingDataIntoFile = new WritingDataIntoFile();
        writingDataIntoFile.write("/output.txt",matchingString.getResultSet());
    }
}
