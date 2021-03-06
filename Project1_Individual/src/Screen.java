import processing.core.PApplet;
import processing.core.PImage;

public class Screen {

	private int x, y;
	private PApplet app;
	PImage home, game, instructions, aboutGame, status;

	public Screen(int x, int y, PApplet app) {
		this.x = x;
		this.y = y;
		home = app.loadImage("Home.png");
		game = app.loadImage("Game.png");
		instructions = app.loadImage("Instructions.png");
		status = app.loadImage("Status.png");
		aboutGame = app.loadImage("AboutGame.png");
	}

	public void drawHome (PApplet app) {
			app.image(home, x, y);
		}
	
	public void drawGame(PApplet app) {
			app.image(game, x, y);
		}
	
	public void drawInstru(PApplet app) {
		app.image(instructions, x, y);
	}
	
	public void drawAbout(PApplet app) {
		app.image(aboutGame, x, y);
	}
	
	public void drawStatus(PApplet app) {
		app.image(status, x, y);
	}
}

