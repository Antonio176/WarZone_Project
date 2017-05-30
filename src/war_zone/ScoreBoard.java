package war_zone;

import java.awt.*;



/*
 * This class displays a score board for the user to see
 */

public class ScoreBoard {
	
	Score score;
	protected Rectangle playButton = new Rectangle(1100, 650, 70, 30);
	protected Rectangle pauseButton = new Rectangle(1200, 650, 70, 30);
	
	
	public ScoreBoard(Score score){
		
		this.score = score;
	}
	
	
	public void draw(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font font1 = new Font("Helvetica", Font.BOLD, 12);
		g.setFont(font1);
		g2d.draw(pauseButton);
		g.drawString("Pause", pauseButton.x + 20 , pauseButton.y + 20);
		g2d.draw(playButton);
		g.drawString("Play", playButton.x + 20 , playButton.y + 20);
		
		
		Font font = new Font ("Serif", Font.BOLD, 25); 
		
		g.setFont (font);
		g.setColor(Color.WHITE);
	    g.drawString("Score: " + score.getScore() + "",  10, 30);
	    g.drawString("Tanks Remaining: " + score.getTanksLeft() + "", 1000, 30);
	    g.drawString("Bullets Remaining: " + score.getBulletsLeft() + "", 1000, 60);
		
		
		
		
	}

}
