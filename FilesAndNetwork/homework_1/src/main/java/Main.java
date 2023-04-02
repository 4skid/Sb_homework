import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь до папки: ");
        String folderPath = reader.readLine();
        long size = FileUtils.calculateFolderSize(folderPath);
        System.out.println("Размер папки " + folderPath + " составляет "
                + FileUtils.getHumanReadableSize(size));
    }
}
