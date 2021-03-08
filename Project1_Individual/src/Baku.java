import processing.core.PApplet;

public class Baku extends Character {

	public Baku(int posX, int posY, PApplet app) {
		super(posX, posY, app);
	}

	@Override
	public void draw(PApplet app) {
		app.imageMode(app.CENTER);
		app.image(baku, posX, posY);
		app.imageMode(app.CORNER);
		//mov(app);
	}

	@Override
	public void mov(PApplet app) {
		posY-=1;
	}
	
	
	public void setPosX() {
		this.posX = posX;

	}
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
