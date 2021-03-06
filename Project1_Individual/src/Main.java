import processing.core.PApplet;
import processing.core.PFont;
public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	@Override
	public void settings() {
		size(1200,700);
	}
	
	//INSTANCES
	Screen screen;
	Player player;
	
	//VAR
	private int screenChange = 0;
	
	//LOADFONTPOPPINS
	PFont myFont;
	
	@Override
	public void setup() {
		screen = new Screen(0, 0, this);
		player = new Player(0,0,true, this);
		myFont = createFont("Poppins-Regular.ttf", 20);
	}
	
	@Override
	public void draw() {
		drawScreen();
		drawPlayer();
		drawButtonSelect();
		drawBacktHome();	
		drawDataGame();
		//println(mouseX,mouseY);
	}
	
	private void drawScreen() {
		switch (screenChange) {
		case 0:
			screen.drawHome(this);
			break;
		case 1:
			screen.drawGame(this);
			break;
		case 2:
			screen.drawInstru(this);
			break;	
		case 3:
			screen.drawAbout(this);
			break;
		default:
			break;
		}	
	}
	
	
	private void drawPlayer() {
		if (screenChange==1) {
			player.drawHinaki(this);
		}
	}
	
	private void drawButtonSelect() {
		if (screenChange==0) {
			if(mouseX>427 && mouseX<770 && mouseY>267 && mouseY<331) {
				rectMode(CENTER);
				noFill();
				stroke(255,208,128);
				strokeWeight(3);
				rect(600, 298, 345, 65,12);
				}
			if(mouseX>427 && mouseX<770 && mouseY>358 && mouseY<422) {
				rectMode(CENTER);
				noFill();
				stroke(255,208,128);
				strokeWeight(3);
				rect(600, 390, 345, 65,12);
				}
			if(mouseX>427 && mouseX<770 && mouseY>449 && mouseY<513) {
				rectMode(CENTER);
				noFill();
				stroke(255,208,128);
				strokeWeight(3);
				rect(600, 480, 345, 65,12);
				}
		}
	}
	
	private void drawBacktHome() {
		if(screenChange== 1 || screenChange==2 || screenChange==3) {
			if(mouseX>41 && mouseX<116 && mouseY>35 && mouseY<53){
				strokeWeight(2);
				line(65, 60, 125, 60);;
				}
			}
	}
	
	//TEMPORAL
	private void drawDataGame() {
		if(screenChange==1) {
			textFont(myFont);
			textAlign(CENTER, CENTER);
		    text("10", 1100, 42);
		    text("10", 960, 42);
		}
	}
	
	@Override
	public void keyPressed() {
		movPlayer();
	}
	
	private void movPlayer() {
		if (screenChange==1) {
			player.movPlayer(this);
		}
	}
	
	@Override
	public void mousePressed() {
		selectButton();
		backHome();
	}
	
	private void selectButton() {
		if(screenChange==0) {
			if(mouseX>427 && mouseX<770 && mouseY>267 && mouseY<331) {
				screenChange=1;
				}
			if(mouseX>427 && mouseX<770 && mouseY>358 && mouseY<422){
				screenChange=2;
				}
			if(mouseX>427 && mouseX<770 && mouseY>449 && mouseY<513){
				screenChange=3;
				}
			}
	}
	
	private void backHome() {
		if(screenChange== 1 || screenChange==2 || screenChange==3) {
			if(mouseX>41 && mouseX<116 && mouseY>35 && mouseY<53){
				screenChange=0;
				}
			}
		}
}