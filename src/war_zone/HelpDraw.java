package war_zone;

import java.awt.*;

// Drawing class for a help page for the users gaming experience
public class HelpDraw {
	
	protected Rectangle backButton = new Rectangle(20, 20, 200, 50);
	
	public void draw(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font font1 = new Font("Helvetica", Font.BOLD, 30);
		g.setFont(font1);
		g2d.draw(backButton);
		g.drawString("Back", backButton.x + 65, backButton.y + 35);
		
		Font font = new Font("Serif", Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("War Zone Help Instructions", 400, 100);
		
		Font font2 = new Font("Serif", Font.PLAIN, 20);
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString("Press play to begin gaming. Press quit to exit out of application.", 380, 150);
		g.drawString("Once you begin playing kill as many enemy tank that come towards you, and finish them all to win the game.", 200, 200);
		g.drawString("You get 50 missiles in a tank, if you finish all of them without destroying all enemy tanks you lose the game.", 200, 250);
		g.drawString("Playing Controls:", 530, 300);
		g.drawString("Rotate Left = left key", 200, 350);
		g.drawString("Rotate Right = right key", 500, 350);
		g.drawString("Move Forward = up key", 800, 350);
		g.drawString("Move backward = down key", 400, 400);
		g.drawString("Fire missile = space key", 700, 400);
		
		
	}

}
