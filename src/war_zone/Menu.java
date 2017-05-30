package war_zone;

import java.awt.*;



public class Menu {
	
	protected Rectangle playButton; 
	protected Rectangle introButton; // edit
	protected Rectangle quitButton;
	
	protected Image image;
	
	
	
	public Menu(String name){
		
		image = Toolkit.getDefaultToolkit().getImage("../img/" + name + ".png");
		
		
		playButton = new Rectangle(500+60, 200, 200, 50);
		introButton = new Rectangle(500+60, 300, 200, 50);
		quitButton = new Rectangle(500+60, 400, 200, 50);
		

	}
	
	public void draw(Graphics g){
		
		g.drawImage(image, 0, 0, 1300, 700, null);
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font font = new Font("Helvetica", Font.BOLD, 60);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("WAR ZONE", 500, 100); // game title for menu
		
		Font font1 = new Font("Helvetica", Font.BOLD, 30);
		g.setFont(font1);
		g2d.draw(playButton);
		g.drawString("Play", playButton.x + 65, playButton.y + 35);
		g2d.draw(introButton);
		g.drawString("Help", introButton.x + 65, introButton.y + 35);
		g2d.draw(quitButton);
		g.drawString("Quit", quitButton.x + 65, quitButton.y + 35);
		
		
		
	}

}
