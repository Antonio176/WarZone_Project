package war_zone;

public class BulletEnemy extends Tank{

	public BulletEnemy(String name, double x, double y, int angle) {
		super(name, x, y, angle);
		// TODO Auto-generated constructor stub
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
		return ((t.x <= x+w/5) && (t.x+t.w/5 >= x) && (t.y+t.h/5 >= y) && (t.y <= y+h/5));
	}
	

}
