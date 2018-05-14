package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import images.Image;
import images.Sprite;

public class Canvas extends JComponent {
	private List<Sprite> sprites;
	
	private Color backgroundColor;
	
	public Canvas() {
		this.sprites = new LinkedList<Sprite>();
	}
	
	public void addSprite(Sprite sprite) {
		int spriteLayer = sprite.layer;
		int index = getLastIndexOfLayer(spriteLayer);
		sprites.add(index, sprite);
	}
	
	private int getLastIndexOfLayer(int layer) {
		int current = 0;
		while (current < sprites.size() && sprites.get(current).layer <= layer) {
			current++;
		}
		return current;
	}
	
	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}
	
	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		fillBackground(g);
		drawSprites(g);
	}
	
	private void fillBackground(Graphics g) {
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}
	
	private void drawSprites(Graphics g) {
		for(int i = 0; i < sprites.size(); i++) {
			Sprite sprite = sprites.get(i);
			Image img = sprite.image;
			img.draw(g, sprite.x, sprite.y);
		}
	}
	
	public void setSize(int width, int height) {
		Dimension size = new Dimension(width, height);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
	}
	
	public List<Sprite> getListOfSprites() {
		return sprites.subList(0, sprites.size());
	}
}
