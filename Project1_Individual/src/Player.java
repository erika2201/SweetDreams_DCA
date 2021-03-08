import processing.core.PApplet;
public class Player extends Character {

	public Player(int posX, int posY, PApplet app) {
		super(posX, posY, app);
	}

	@Override
	public void draw(PApplet app) {
		app.imageMode(app.CENTER);
		app.image(player, posX, posY);
		app.imageMode(app.CORNER);
	}

	@Override
	public void mov(PApplet app) {
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
		case 'w' :
			this.posY-= 50;
			if (this.posY<550) {
				this.posY=550;
			}
			break;
			
		case 's' :
			this.posY+= 50;
			if (this.posY>600) {
				this.posY=600;
			}
			break;
		default:
			break;
		}
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
