package war_zone;

import java.awt.*;

public class GameOver {
	
	protected Rectangle backButton = new Rectangle(20, 20, 200, 50);
	
	public void draw(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		Font font1 = new Font("Helvetica", Font.BOLD, 30);
		g.setFont(font1);
		g2d.draw(backButton);
		g.drawString("Back", backButton.x + 65, backButton.y + 35);
		
		Font font = new Font("Helvetica", Font.BOLD, 100);
		
		// draw a game over string in the middle of the screen
		g.setFont (font);
		g.setColor(Color.WHITE);
		g.drawString("Game Over", 400, 350);
		g.drawString("You Lost", 450, 450);
		
		
	}

}
