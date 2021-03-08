import processing.core.PApplet;

public class Enemy extends Character {

	private boolean isMov;
	
	public Enemy(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		isMov = true;
	}

	@Override
	public void draw(PApplet app) {
		app.imageMode(app.CENTER);
		app.image(enemy, posX, posY);
		app.imageMode(app.CORNER);
		mov(app);
	}

	@Override
	public void mov(PApplet app) {
		if (isMov) {
			posX+=1;
		}

	}
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	

}
