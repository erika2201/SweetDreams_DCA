import java.util.ArrayList;

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
	
	private int screenChange = 0;
	private int mil=0;
	private int s=0;
	private int m=0;
	private int score=0;
	private int defeat=0;

	Screen screen;
	Player player;
	Baku baku;
	PFont myFont;
	
	private ArrayList<Enemy> enemyList;
	
	
	@Override
	public void setup() {
		screen = new Screen(0, 0, this);
		player = new Player((width/2),600, this);
		enemyList = new ArrayList<Enemy>();
		baku = new Baku(0,0,this);
		
		myFont = createFont("Poppins-Regular.ttf", 20);
	}
	
	@Override
	public void draw() {
		drawScreen();
		drawButtonSelect();
		drawBacktHome();	
		time();
		score();
		
		drawEnemy();
		initEnemy();	
		
		drawPlayer();
		removeEnemy();
		
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
		case 4:
			screen.drawStatus(this);
			finishGame();
			break;
		default:
			break;
		}	
	}
	
	
	private void drawPlayer() {
		if (screenChange==1) {
			player.draw(this);
		}
	}
	
	private void initEnemy() {
		if(screenChange==0) {
			frameCount=0;
		}
		if(screenChange==1) {
			frameRate(60);
			if (frameCount == 120) {
				int posX = (int) random(-50, 10);
				enemyList.add(new Enemy(posX, 150, this));
				System.out.println(enemyList.size());
				frameCount = 0;
			}
		}
	}
	
	private void drawEnemy() {
		if(screenChange==1) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).draw(this);
			enemyList.get(i).mov(this);
			}
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
		if(screenChange== 1 || screenChange==2 || screenChange==3 || screenChange==4) {
			if(mouseX>41 && mouseX<116 && mouseY>35 && mouseY<53){
				strokeWeight(2);
				line(65, 60, 125, 60);;
				}
			}
	}
	
	//TEMPORAL
	private void time() {
		if(screenChange==1) {
			textFont(myFont);
			textAlign(CENTER, CENTER);
				if(mil<=59) {
					text(m+":"+s, 1110, 42);	
					mil = mil + 1;
					}else {
						s = s+1;
						mil= 0;
						m = 0;
						text(m+":"+s, 1110, 42);	
					}
				
				if(s>=59) {
					m = m+1;
					s=0;
					text(m+":"+s, 1110, 42);	
				}
			}
	}
	
	private void score() {
		text(score, 960, 42);
		
	}
	
	private void finishGame() {
		textFont(myFont);
		text(score,230,322);
		text(m+":"+s, 230, 367);
		text(defeat, 370,408);
		for (int i = 0; i < enemyList.size(); i++) {
			if (dist(baku.getPosX(), baku.getPosY(), enemyList.get(i).getPosX(), enemyList.get(i).getPosY())<50)  {
				defeat= defeat+1;
			}
		}
		
	}
	
	@Override
	public void keyPressed() {
		movPlayer();
	}
	
	private void movPlayer() {
		if (screenChange==1) {
			player.mov(this);
		}
	}
	
	@Override
	public void mousePressed() {
			selectButton();
			backHome();	
			shootBaku();
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
		if(screenChange== 1 || screenChange==2 || screenChange==3 || screenChange==4) {
			if(mouseX>41 && mouseX<116 && mouseY>35 && mouseY<53){
				screenChange=0;
				}
			}
		}
	
	private void shootBaku() {
		if(screenChange==1) {
		switch (mouseButton) {
		case LEFT:
			player.mousePressed();;
			break;
		default:
			break;
			}
		}
	}

	private void removeEnemy() {
		for (int i = 0; i < player.getBaku().size(); i++) {
			for (int j = 0; j < enemyList.size(); j++) {
			if (dist(player.getBaku().get(i).getPosX(), player.getBaku().get(i).getPosY(),
					enemyList.get(j).getPosX(), enemyList.get(j).getPosY())<50)  {
					enemyList.remove(j);
				}
			}
		
		}
	}
}
