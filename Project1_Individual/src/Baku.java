import processing.core.PApplet;

public class Baku extends Character {

	public Baku(int posX, int posY, PApplet app) {
		super(posX, posY, app);
	}

	@Override
	public void draw(PApplet app) {
		mov(app);
	}

	@Override
	public void mov(PApplet app) {
		app.imageMode(app.CENTER);
		app.image(baku, posX, posY);
		app.imageMode(app.CORNER);
		posY-=20;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
