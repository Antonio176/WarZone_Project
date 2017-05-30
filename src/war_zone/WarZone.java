package war_zone;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;



/*
 *   This class is the main game Applet
 * 
 */

public class WarZone extends Applet implements Runnable, KeyListener{
	
	// Color to use for screen clearing
	Color background = Color.white;
	
	// OffSreen image and its Graphics Context
	Image    offscreen_image;
	Graphics offscreen_g;
	
	// Sprites
	Tank tank = new Tank("tank", 500, 250, 0);
	
	EnemyTank[] eTanks = new EnemyTank[21]; // make size of 20
	
	BulletList bulletList = new BulletList(); 
	
	ArrayList<Bullet> missiles = bulletList.getMissiles();
	
	Explosion[] explosions = new Explosion[21];
	
	Explosion explosion = new Explosion("explosion", 500, 0, 0); // make size of 20

	// boolean variables for key listener or other uses
	boolean leftPressed = false;
	boolean rightPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	boolean	spacePressed = false; // to fire
	static boolean pausePressed = false;
	static boolean playPressed = false;
	
	AudioClip tank_firing;
	AudioClip tank_moving;
	AudioClip tank_explosion;
	static AudioClip startup_menu;
	
	// for score board game
	Score score;
	ScoreBoard score_board;
	GameOver g_over;
	GameOver2 g_over2;
	
	Color color;
	
	// score variables
	int numEnemy = 20;
	
	// Number of miliseconds between frames 
	private static final int duration = 15;
	
	// thread game execution loop
	Thread timer;
	
	// Menu Class
	Menu menu; 
	
	// Introduction class
	HelpDraw help;
	
	// for the menu window
	protected static enum STATE{
		MENU,
		GAME,
		HELP,
		GAMEOVER,
		GAMEWON
	};
	
	protected static STATE State = STATE.MENU;
	
	public void init (){
		
		setSize(new Dimension(1300,700));
		color = new Color(0,102,0); // dark green
		//setBackground(color);
		setBackground(Color.BLACK);
		
	    // Setup Offscreen Buffer
	    setupDoubleBuffering();
	    
	    initialize();
	    
	    // Add the focus for the Applet
	    requestFocus();

	    // Add KeyListener to the Applet
	    addKeyListener(this);

	    addMouseListener(new MenuMouseInput());
	    // Create thread for the main loop
	    timer = new Thread(this);

	    // Start thread for the main loop
	    // timer.start();
	    
	    
	}
	
	
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}
	
	public void run (){
		// to be edited
		while(true){
			
			// can only pause and play once
			if (!pausePressed || playPressed){
				
				playersInput();
				
				moveGameObjects();
				
				updateMissiles();
				
				handleCollisions();
			
			}
			repaint(); // Ask OS to call paint
			wait(duration);
			
		}
		
	}
	
	public void initialize(){
		
		menu = new Menu("menu");
		
		help = new HelpDraw();
		
		score = new Score();
		
		g_over = new GameOver();
		g_over2 = new GameOver2();
		
		score_board = new ScoreBoard(score);
		
		
		tank_firing = getAudioClip (getCodeBase(), "../sounds/tank_firing.wav");
		tank_moving = getAudioClip (getCodeBase(), "../sounds/tank_moving.wav");
		tank_explosion = getAudioClip (getCodeBase(), "../sounds/explosion.wav");
		startup_menu = getAudioClip (getCodeBase(), "../sounds/startup_menu.wav");
		
		if (State == STATE.MENU){
			startup_menu.loop();
		}
	
		// on screen coor's
		eTanks[0] = new EnemyTank("tank2", 10, 50, 0);
		eTanks[1] = new EnemyTank("tank2", 650, 20, 0);
		// out of screen coor's up side
		eTanks[2] = new EnemyTank("tank2", 100, -300, 0);
		eTanks[3] = new EnemyTank("tank2", 300, -800, 0);
		eTanks[4] = new EnemyTank("tank2", 1500, -1300, 0);
		eTanks[5] = new EnemyTank("tank2", 800, -1000, 0);
		eTanks[6] = new EnemyTank("tank2", 0, -1600, 0);
		// out of screen coor's left side
		eTanks[7] = new EnemyTank("tank2", -500, 200, 0);
		eTanks[8] = new EnemyTank("tank2", -1000, 700, 0);
		eTanks[9] = new EnemyTank("tank2", -1500, 100, 0);
		eTanks[10] = new EnemyTank("tank2", -800, 1000, 0);
		// out of screen coor's down side 
		eTanks[11] = new EnemyTank("tank2", 1300, 900, 0);
		eTanks[12] = new EnemyTank("tank2", 800, 1300, 0);
		eTanks[13] = new EnemyTank("tank2", 1000, 800, 0);
		eTanks[14] = new EnemyTank("tank2", 0, 1900, 0);
		eTanks[15] = new EnemyTank("tank2", 500, 2100, 0);
		// out of screen coor's right side
		eTanks[16] = new EnemyTank("tank2", 2500, 0, 0);
		eTanks[17] = new EnemyTank("tank2", 2600, -100, 0);
		eTanks[18] = new EnemyTank("tank2", 2000, 300, 0);
		eTanks[19] = new EnemyTank("tank2", 3000, 500, 0);
		eTanks[20] = new EnemyTank("tank2", 21000, 600, 0); // last tank
		// on screen coor's
		explosions[0] = new Explosion("explosion", 10, 50, 0);
		explosions[1] = new Explosion("explosion", 650, 20, 0);
		// out of screen coor's up side
		explosions[2] = new Explosion("explosion", 100, -300, 0);
		explosions[3] = new Explosion("explosion", 300, -800, 0);
		explosions[4] = new Explosion("explosion", 1500, -1300, 0);
		explosions[5] = new Explosion("explosion", 800, -1000, 0);
		explosions[6] = new Explosion("explosion", 0, -1600, 0);
		// out of screen coor's left side
		explosions[7] = new Explosion("explosion", -500, 200, 0);
		explosions[8] = new Explosion("explosion", -1000, 700, 0);
		explosions[9] = new Explosion("explosion", -1500, 100, 0);
		explosions[10] = new Explosion("explosion", -800, 1000, 0);
		// out of screen coor's down side 
		explosions[11] = new Explosion("explosion", 1300, 900, 0);
		explosions[12] = new Explosion("explosion", 800, 1300, 0);
		explosions[13] = new Explosion("explosion", 1000, 800, 0);
		explosions[14] = new Explosion("explosion", 0, 1900, 0);
		explosions[15] = new Explosion("explosion", 500, 2100, 0);
		// out of screen coor's right side
		explosions[16] = new Explosion("explosion", 2500, 0, 0);
		explosions[17] = new Explosion("explosion", 2600, -100, 0);
		explosions[18] = new Explosion("explosion", 2000, 300, 0);
		explosions[19] = new Explosion("explosion", 3000, 500, 0); 
		explosions[20] = new Explosion("explosion", 21000, 600, 0); // last tank
		
	}
	
	public void playersInput(){
		
		// users tank control
		if (leftPressed){
			tank.rotateLeftBy(4);
			
		}
		if (rightPressed) {
			tank.rotateRightBy(4);
		
		}
		if (upPressed) {
			tank.moveForwardBy(8);
			
		}
		if (downPressed){
			tank.moveBackwardBy(4);
			
		}
		if (spacePressed){
			if(missiles.size() <= 50) {
				bulletList.fireFrom(tank);
			}
			score.decrementBullets();
			
		}
		
	}
	
	public void moveGameObjects(){
		if (State == STATE.GAME){
			for (int i = 0; i < eTanks.length; i++){
				if(eTanks[i].isVisible()){
					eTanks[i].chase(tank);
					explosions[i].chase(eTanks[i]);
				}
			}
		}
	}

	// to be edited
	public void handleCollisions(){
		if (score.GameIsLost()){
			WarZone.State = WarZone.STATE.GAMEOVER;
		}
		if (score.GameIsWon()){
			WarZone.State = WarZone.STATE.GAMEWON;
		}
		
		
	}
	
	public void setupDoubleBuffering(){
		offscreen_image = createImage(getWidth(), getHeight());
		offscreen_g     = offscreen_image.getGraphics();
	}
	
	public void update(Graphics g){
		offscreen_g.clearRect(0, 0, getWidth(), getHeight());
		paint(offscreen_g);
		g.drawImage(offscreen_image, 0, 0, null);
		
	}

	public void repaint(){
		Graphics g = getGraphics();
		update(g);
		g.dispose();
	}
	
	public static int LT = KeyEvent.VK_LEFT;
	public static int RT = KeyEvent.VK_RIGHT;
	public static int UP = KeyEvent.VK_UP;
	public static int DN = KeyEvent.VK_DOWN;
	public static int SPACE = KeyEvent.VK_SPACE; // fire missile
	public static int P = KeyEvent.VK_P; // pause game
	public static int C = KeyEvent.VK_C; // continue playing
	public static int Q = KeyEvent.VK_Q; // quit game
	public static int S = KeyEvent.VK_S; // start game
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keycode = e.getKeyCode();
		if (State == STATE.GAME){
			if (keycode == LT){
				leftPressed = true;
				
			}
		    if (keycode == RT){
		    	rightPressed = true;
		    	
		    }
		    if (keycode == UP){
		    	upPressed = true; 
		    	//tank_moving.play();
		    }
		    if (keycode == DN){
		    	downPressed = true;
		    	//tank_moving.play(); 
		    }
		    if (keycode == SPACE){
		    	
		    	spacePressed = true;
		    	tank_firing.play();
		    }
		    
		}
	    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int keycode = e.getKeyCode();
		
		if (keycode == LT){
			leftPressed = false;
		}
	    if (keycode == RT){
	    	rightPressed = false;
	    }
	    if (keycode == UP){
	    	upPressed = false;
	    	//tank_moving.stop();
	    	
	    }
	    if (keycode == DN){
	    	downPressed = false;
	    	//tank_moving.stop();
	    }
	    if (keycode == SPACE){
	    	spacePressed = false;
	    }
	    
	   
	}
	
	public void wait(int miliseconds){
		try{
			timer.sleep(miliseconds);
	    }
	    catch (InterruptedException ie){
	      
	    }
	}
	private void updateMissiles() {

        for (int i = 0; i < missiles.size(); i++) {

            Bullet m = missiles.get(i);

            if (m.isVisible()) {
                m.shoot(20, tank);
            } else {
                missiles.remove(i);
            }
        }
    }
	
	
	
	public void paint(Graphics g){
		
		
		
		// need to fix the explosion sound not sure where to put it
		if (State == STATE.GAME){
			score_board.draw(g);
			startup_menu.stop();
			for (Bullet m : missiles) {
				if (m.isVisible()) {
					m.draw(g);
				}
				
			}
			for (int i = 0; i < eTanks.length; i++){
				if (eTanks[i].hasCollidedWith(tank)){
					if (explosions[i].isVisible()){
						explosions[i].draw(g);
						tank_explosion.play();
					}
			
					tank.setVisible(false);
					eTanks[i].setVisible(false);
					explosions[i].setVisible(false);
					
				}
			
				if(eTanks[i].isVisible()){
					eTanks[i].draw(g);
					eTanks[20].setVisible(false); // this is to remove last element since it has a bug
				}
				if(tank.isVisible()){
					tank.draw(g);
				}
				
			}
			
			
			for (Bullet m : missiles) {
				for (int i = 0; i < eTanks.length; i++){
					if (m.hasCollidedWith(eTanks[i])){
						m.setVisible(false);
						eTanks[i].setVisible(false);
						explosions[i].setVisible(false);
						explosions[i].draw(g);
						tank_explosion.play();
						score.incrementScore(10); // increment score of user for the score board when bullet crashes to a enemy tank
						score.decrementTanks(); // decrement tank number for score board
						
						// deleted tank element from array
						for(int j=i+1; j < eTanks.length; j++){
							
							eTanks[j-1] = eTanks[j];
							explosions[j-1] = explosions[j];
							
				       }
						
					   // need to delete last element
			
					}
					
					
				}
			}
			
			
		} else if (State == STATE.MENU){
			
			menu.draw(g);
			score.reset();
			
		} else if (State == STATE.HELP){
			
			startup_menu.stop();
			help.draw(g);
		} else if (State == STATE.GAMEOVER){
			
			g_over.draw(g);
		} else if (State == STATE.GAMEWON){
			
			g_over2.draw(g);
		}
	}
	
}
