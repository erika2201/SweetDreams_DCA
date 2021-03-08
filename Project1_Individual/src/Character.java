import processing.core.PApplet;
import processing.core.PImage;

public abstract class Character {

	protected int posX, posY;
	protected PApplet app;
	PImage player, enemy, baku;
	
	public Character(int posX, int posY, PApplet app) {
		this.posX =posX;
		this.posY =posY;
		this.app = app;
		player = app.loadImage("Player.png");
		enemy = app.loadImage("Enemy.png");
		baku = app.loadImage("Baku.png");
	}

	public abstract void draw (PApplet app);
	
	public abstract void mov (PApplet app);
}
