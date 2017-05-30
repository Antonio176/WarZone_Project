package war_zone;

import java.awt.*;



/*
 * This class represents a sprite tank that is the enemy
 */

public class EnemyTank extends Tank{

	public EnemyTank(String name, double x, double y, int angle) {
		super(name, x, y, angle);
		
	}
	
	// leftOrRight method
	public double leftOrRight(double x, double y){
		
		return (x - this.x) * Lookup.sin[A] - (y - this.y) * Lookup.cos[A];
	}

	// distanceTo method
	public double distanceTo(double x, double y){
		
		return (x - this.x) * Lookup.cos[A] + (y - this.y) * Lookup.sin[A];
	}
	
	// collision of tanks method
	public boolean hasCollidedWith(Tank t){ 
		return ((t.x <= x+w/2) && (t.x+t.w/2 >= x) && (t.y+t.h/2 >= y) && (t.y <= y+h/2));
	}
	
	
	// to be checked
	public void track(Tank p){
		if (leftOrRight(p.x, p.y) > 0) rotateLeftBy(1);
		if (leftOrRight(p.x, p.y) < 0) rotateRightBy(1);
		
	}
	
	public void chase(Tank p){
		track(p);
		if (distanceTo(p.x, p.y) > 300){
			moveForwardBy(1);
		}
		
		
	}
	
	
	

}
