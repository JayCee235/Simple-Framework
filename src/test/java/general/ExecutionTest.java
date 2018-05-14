package general;

import java.awt.Color;
import java.io.IOException;

import display.Window;
import images.ImageLibrary;
import images.Sprite;

public class ExecutionTest {
	public static void main(String[] args) throws IOException {
		Window w = new Window();
		w.display();
		
		ImageLibrary lib = ImageLibrary.getLibrary();
		
		lib.addPlaceholderImage("temp", 50, 50);
		lib.addPlaceholderColorImage("temp2", Color.green, 50, 50);
		lib.loadImage("purple", "C:\\Users\\caudeljn\\Documents\\sprites\\Backgrounds\\purple.png");
		
		Sprite sprite = new Sprite(lib.getImage("temp"), 10, 10);
		Sprite sprite2 = new Sprite(lib.getImage("temp2"), 100, 100);
		Sprite purple = new Sprite(lib.getImage("purple"), 50, 50);

		w.setBackgroundColor(Color.BLUE);
		w.drawSprite(sprite);
		w.drawSprite(sprite2);
		w.drawSprite(purple);
		
		w.refresh();
	}
}
