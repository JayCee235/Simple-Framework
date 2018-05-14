package images;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import exceptions.NoSuchResourceException;

public class ImageLibrary {
	private static ImageLibrary imageLibrary;
	
	private Map<String, Image> library;
	
	public static ImageLibrary getLibrary() {
		if (imageLibrary == null) {
			imageLibrary = new ImageLibrary();
		}
		return imageLibrary;
	}
	
	private ImageLibrary() {
		this.library = new HashMap<String, Image>();
	}
	
	public void loadImage(String name, String path) throws IOException {
		try {
			Image img = new FileImage(path);
			library.put(name, img);
		} catch (IOException e) {
			throw new IOException("Couldn't load " + path);
		}
	}
	
	public void addPlaceholderImage(String name, int width, int height) {
		Image img = new PlaceholderImage(width, height);
		library.put(name, img);
	}
	
	public void addPlaceholderColorImage(String name, Color color, int width, int height) {
		Image img = new PlaceholderImage(color, width, height);
		library.put(name, img);
	}
	
	public void unloadImage(String name) {
		library.remove(name);
	}
	
	public Image getImage(String name) {
		Image out = library.get(name);
		if (out == null) {
			throw new NoSuchResourceException("No image matching \"" + name + "\"");
		}
		return out;
	}
}
