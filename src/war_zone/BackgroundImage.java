package war_zone;

import java.awt.*;

/*
 * This class is to create a battle field image in the game for playing
 */

public class BackgroundImage {
	
	   protected Image image;

	   protected double x;
	   protected double y;
	   protected double z;

	   int w;



	   public BackgroundImage(String filename, double x, double y, double z, int w)
	   {
	      image = Toolkit.getDefaultToolkit().getImage(filename);

	      this.x = x;
	      this.y = y;
	      this.z = z;

	      this.w = w;

	   }

	   // to be edited if needed
	   public void draw(Graphics g)
	   {
	      for(int i = 0; i < 50; i++) // edit

	         g.drawImage(image, (int)(x - Camera2D.x/z) + w*i, (int)(y - Camera2D.y), null);
	   }


}
