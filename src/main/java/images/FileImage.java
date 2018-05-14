package images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileImage extends Image{
	private BufferedImage image;
	
	public FileImage(String pathToFile) throws IOException {
		File file = new File(pathToFile);
		image = ImageIO.read(file);
	}
	
	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
	}
	
	
}
