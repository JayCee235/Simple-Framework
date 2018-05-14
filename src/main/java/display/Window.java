package display;

import java.awt.Color;

import javax.swing.JFrame;

import images.Sprite;

public class Window {
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Window() {
		this("New Window", 400, 300);
	}
	
	public Window(String title, int width, int height) {
		this.frame = new JFrame();
		this.canvas = new Canvas();
		
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle(title);
		this.setSize(width, height);
		frame.setLocationRelativeTo(null);
	}
	
	public void display() {
		frame.setVisible(true);
	}
	
	public void drawSprite(Sprite sprite) {
		canvas.addSprite(sprite);
	}
	
	public void stopDrawingSprite(Sprite sprite) {
		canvas.removeSprite(sprite);
	}
	
	public void setBackgroundColor(Color color) {
		canvas.setBackgroundColor(color);
	}
	
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		frame.setTitle(title);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		this.canvas.setSize(width, height);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		this.canvas.setSize(width, height);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		this.canvas.setSize(width, height);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	public void refresh() {
		canvas.repaint();
	}
	
}
