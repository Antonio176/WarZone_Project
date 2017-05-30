package war_zone;

import java.awt.*;


/*
 * This class represents a bullet or missile weapon for the tank
 */

public class Bullet extends Tank{
	
	// constructor 
	public Bullet(String name, double x, double y, int angle) {
		super(name, x, y, angle);
		
	}
	
	// missile launch method 
	public void shoot(int speed, Tank t){
	
		x += speed * Math.cos(Math.toRadians(A));
		y += speed * Math.sin(Math.toRadians(A));
		
		if (x > 600 && y > 600){
            visible = false;
		}
	}
	
	// collision of tanks method
	public boolean hasCollidedWith(Tank t){ 
		return ((t.x <= x+w/8) && (t.x+t.w/8 >= x) && (t.y+t.h/6 >= y) && (t.y <= y+h/6));
	}
	
	
	
	
}
