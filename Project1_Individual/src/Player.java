import processing.core.PApplet;
import processing.core.PImage;

public class Player {

	private int posX, posY;
	private boolean isMov;
	private PApplet app;
	PImage player;
	
	public Player(int posX, int posY, boolean isMov, PApplet app) {
		this.posX = app.width/2;
		this.posY = 600;
		isMov = true;
		this.app = app;
		player = app.loadImage("Player.png");
	}
	
	public void drawHinaki(PApplet app){
		app.imageMode(app.CENTER);
		app.image(player, posX, posY);
		app.imageMode(app.CORNER);
		}
	
	public void movPlayer(PApplet app) {
		switch (app.key) {
		case 'a' :
			this.posX-= 100;
			if (this.posX<100) {
				this.posX=100;
			}
			break;
			
		case 'd' :
			this.posX+= 100;
			if (this.posX>1100) {
				this.posX=1100;
			}
			break;
		default:
			break;
		}
	}

}

