package images;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import display.Canvas;

public class CanvasTest {
	@Test
	public void testSpriteLayers() {
		Sprite first = new Sprite(null, 10, 10);
		first.layer = 1;
		
		Sprite second = new Sprite(null, 20, 20);
		second.layer = 2;
		
		Sprite third = new Sprite(null, 30, 30);
		third.layer = 3;
		
		Canvas c = new Canvas();
		c.addSprite(second);
		c.addSprite(first);
		c.addSprite(third);
		
		List<Sprite> sprites = c.getListOfSprites();
		
		assertEquals(first, sprites.get(0));
		assertEquals(second, sprites.get(1));
		assertEquals(third, sprites.get(2));
	}
	
	@Test
	public void testSpriteRemoval() {
		Sprite first = new Sprite(null, 10, 10);
		first.layer = 1;
		
		Sprite second = new Sprite(null, 20, 20);
		second.layer = 2;
		
		Sprite third = new Sprite(null, 30, 30);
		third.layer = 3;
		
		Canvas c = new Canvas();
		c.addSprite(first);
		c.addSprite(second);
		c.addSprite(third);
		
		List<Sprite> sprites = c.getListOfSprites();
		assertEquals(first, sprites.get(0));
		assertEquals(second, sprites.get(1));
		assertEquals(third, sprites.get(2));
		
		c.removeSprite(second);
		
		sprites = c.getListOfSprites();
		assertEquals(first, sprites.get(0));
		assertEquals(third, sprites.get(1));
		assertFalse(sprites.contains(second));
	}
}
