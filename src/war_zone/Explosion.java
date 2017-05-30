package war_zone;

public class Explosion extends Tank{

	public Explosion(String name, double x, double y, int angle) {
		super(name, x, y, angle);
		
	}
	
	// leftOrRight method
	public double leftOrRight(double x, double y){
		return (x - this.x) * Lookup.sin[A] - (y - this.y) * Lookup.cos[A];
	}

	// to be checked
	public void track(Tank p){
		if (leftOrRight(p.x, p.y) > 0) rotateLeftBy(1);
		if (leftOrRight(p.x, p.y) < 0) rotateRightBy(1);
	}

	// distanceTo method
	public double distanceTo(double x, double y){
		return (x - this.x) * Lookup.cos[A] + (y - this.y) * Lookup.sin[A];
	}
	
	public void chase(Tank p){
		track(p);
		if (distanceTo(p.x, p.y) > 0){
			moveForwardBy(3);
		}
			
	}
	// chase method
	public void chase(EnemyTank p){
		track(p);
		if (distanceTo(p.x, p.y) > 10){
			moveForwardBy(5);
		}
			
	}
	

}
