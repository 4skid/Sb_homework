import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable {

    private File file;
    private int newWidth;
    private String dstFolder;

    private long start;

    public ImageResizer(File file, int newWidth, String dstFolder, long start) {
        this.file = file;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            BufferedImage image = ImageIO.read(file);
            if (image != null) {
                BufferedImage newImage = Scalr.resize(image, Scalr.Method.QUALITY, newWidth);
                File opFile = new File(file.getName());
                ImageIO.write(image, file.getName(), opFile);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finished after start: " + (System.currentTimeMillis() - start) + " ms");
    }
}
