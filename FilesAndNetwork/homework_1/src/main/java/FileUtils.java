
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};

    public static long calculateFolderSize(String path) {
        try {
            Path folderPath = Path.of(path);
            long size = Files.walk(folderPath)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
            return size;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = ((double) size) / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value * 100) / 100. + " " + sizeMultipliers[i] + (i > 0 ? "b" : "");
            }
        }
        return "Very big!";
    }
}
