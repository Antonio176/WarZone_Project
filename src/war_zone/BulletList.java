package war_zone;

import java.util.ArrayList;




public class BulletList {
	
	protected ArrayList<Bullet> missiles;
	
	public BulletList(){
		missiles = new ArrayList<>();
	}
	
	public ArrayList getMissiles() {
        return missiles;
    }
	
	// fireFrom method
	public void fireFrom(Tank t) {
        missiles.add(new Bullet("missile", t.x, t.y, t.A));
    }
	
	


	
	
	
	
	
	
}
