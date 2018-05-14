package images;
public class Sprite {
	public Image image;
	public int x, y, layer;
	
	public Sprite(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.layer = 0;
	}
}
