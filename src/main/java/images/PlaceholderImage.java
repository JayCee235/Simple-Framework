package images;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class PlaceholderImage extends Image {
	private Color color;
	private int width, height;
	
	public PlaceholderImage(int width, int height) {
		this(Color.magenta, width, height);
	}
	
	public PlaceholderImage(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		g.setColor(color);
		int halfWidth = width/2;
		int halfHeight = height/2;
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLACK);
		g.fillRect(x + halfWidth, y, halfWidth, halfHeight);
		g.fillRect(x, y + halfHeight, halfWidth, halfHeight);
	}

}
