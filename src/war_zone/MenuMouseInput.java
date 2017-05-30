package war_zone;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuMouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int dx = e.getX();
		int dy = e.getY();
		
		// play button mouse press 
		if (dx >= 560 && dx <= 760){
			if(dy >= 200 && dy <= 250){
				WarZone.State = WarZone.STATE.GAME; // play game war zone
			}
		}
		
		// Introduction button mouse press 
		 if (dx >= 560 && dx <= 760){
			if(dy >= 300 && dy <= 350){
				WarZone.State = WarZone.STATE.HELP;
			}
		}
		
		// quit button mouse press 
		if (dx >= 560 && dx <= 760){
			if(dy >= 400 && dy <= 450){
				System.exit(1); // exit game
			}
		}
		// back button mouse press   20,20,200,50
		if (dx >= 20 && dx <= 220){
			if(dy >= 20 && dy <= 70){
				WarZone.State = WarZone.STATE.MENU;
				WarZone.startup_menu.loop();
			}
		}
		// pause button mouse press 1200, 650, 70, 30
		if (dx >= 1200 && dx <= 1270){
			if(dy >= 650 && dy <= 680){
				WarZone.pausePressed = true;
				
			}
		}
		// play button mouse press 1100, 650, 70, 30
		if (dx >= 1100 && dx <= 1170){
			if(dy >= 650 && dy <= 680){
				WarZone.playPressed = true;
						
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
