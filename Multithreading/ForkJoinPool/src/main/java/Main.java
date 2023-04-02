import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String URL = "https://skillbox.ru/";
    private static final int COUNT_DEFAULT_SLASH = URL.length() - URL.replace("/", "").length();

    public static void main(String[] args) {
        ReferenceParser referenceParser = new ReferenceParser(URL);

        System.out.println("Запись началась...");
        long start = System.currentTimeMillis();

        ForkJoinPool joinPool = new ForkJoinPool();
        joinPool.invoke(referenceParser);
        referenceParser.getSortedLinks().stream().map(Main :: getStringWithTabs).forEach(Main::writer);

        long end = System.currentTimeMillis();

        System.out.printf("Запись завершена. \nЗатраченное время %d сек.", (end - start)/1000);
    }

    private static String getStringWithTabs(String line) {
        int countSlash = line.length() - line.replace("/", "").length();
        if(countSlash < COUNT_DEFAULT_SLASH){
            return "".concat(line);
        }
        return "\t".repeat(Math.max(0, countSlash - COUNT_DEFAULT_SLASH)).concat(line);
    }

    private static void writer(String line) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/sitemap.txt", true)) {
            fileWriter.write(line.concat("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
