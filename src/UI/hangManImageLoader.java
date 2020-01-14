package UI;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class hangManImageLoader extends JLabel {

    private int preferredWidth;

    private int preferredHeight;

    private final String IMAGE_BASE_NAME;

    private final String IMAGE_DIRECTORY;

    private final String IMAGE_TYPE;

    private String path;

    private BufferedImage image;




    public hangManImageLoader(String imageBaseName, String imageDirectory, String imageType) {

        preferredHeight = 272;
        preferredWidth = 282;

        IMAGE_BASE_NAME = imageBaseName;
        IMAGE_DIRECTORY = imageDirectory;
        IMAGE_TYPE = imageType;

        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        path = IMAGE_DIRECTORY + IMAGE_BASE_NAME + "_0" + IMAGE_TYPE;
        image = loadImage(path);
    }

    private BufferedImage loadImage(String imagePath){

        BufferedImage img = null;

        try{
            img = ImageIO.read(new File(imagePath));
        }

        catch (IOException ex){

            System.err.println("loadimage() : Error: Image at " + imagePath + " could not be found");
            System.exit(1);
        }

        return img;

    }

}
