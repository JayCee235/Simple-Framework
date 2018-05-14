package images;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.NoSuchResourceException;

public class ImageLibraryTest {
	
	@Test
	public void testGetLibrary() {
		ImageLibrary lib = ImageLibrary.getLibrary();
		assertTrue(lib != null);
	}
	
	@Test
	public void testAddPlaceholderImage() {
		ImageLibrary lib = ImageLibrary.getLibrary();
		lib.addPlaceholderImage("test", 10, 10);
		Image img = lib.getImage("test");
		assertTrue(img != null);
	}
	
	@Test
	public void testOverrideImage() {
		ImageLibrary lib = ImageLibrary.getLibrary();
		lib.addPlaceholderImage("test", 10, 10);
		Image img = lib.getImage("test");
		lib.addPlaceholderImage("test", 10, 10);
		Image img2 = lib.getImage("test");
		assertFalse(img == img2);
	}
	
	@Test
	public void testErrorOnGetNoImage() {
		ImageLibrary lib = ImageLibrary.getLibrary();
		try {
			lib.getImage("notLoaded");
		} catch (NoSuchResourceException e) {
			return;
		}
		fail();
	}
}
