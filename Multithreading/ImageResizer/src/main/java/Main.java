import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static int newWidth = 300;
    public static String srcFolder = "/Users/User/Desktop/src";
    public static String dstFolder = "/Users/User/Desktop/dst";
    public static File srcDir = new File(srcFolder);

    public static File[] files = srcDir.listFiles();

    public static int cores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(cores);

        for (File file : files) {
            executorService.submit(new ImageResizer(file, newWidth, dstFolder, start));
        }
        executorService.shutdown();
    }
}
