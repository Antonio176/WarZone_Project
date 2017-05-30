package war_zone;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;


/*
 * This class represents a tank
 */

public class Tank{
	
	//private Image image;
	BufferedImage bimg;
	protected double x;
	protected double y;
	protected double w;
	protected double h;
	
	
	int A; // angle
	
	// boolean variables
	boolean moving = false;
	boolean visible = true;
	
	public Tank(String name, double x, double y, int angle) {
		
		this.x = x;
		this.y = y;
		A = angle;
		
		try{
			bimg = ImageIO.read(new File("../img/" + name + ".png"));
			w = bimg.getWidth(); // get width
			h = bimg.getHeight(); // get height
			
			
		} catch (Exception e){
			
		}
		
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
	    this.visible = visible;
	}

	public void rotateLeftBy(int degrees){
		A -= degrees;
		if (A < 0 ){
			A += 360;
		}
		
		
	}
	public void rotateRightBy(int degrees){
		A += degrees;
		if (A > 359){
			A -= 360;
		}
		
		
	}
	public void moveForwardBy(int d){
		x += d * Lookup.cos[A];
		y += d * Lookup.sin[A];
		moving = true;
	}
	public void moveBackwardBy(int d){
		x -= d * Lookup.cos[A];
		y -= d * Lookup.sin[A];
	}
	
	// draw sprite based on rotation
	public void draw(Graphics g){
		
		double rotation = Math.toRadians(A);
		double locationX = bimg.getWidth()/2;
		double locationY = bimg.getHeight()/2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotation, locationX, locationY);  // for image rotation
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(op.filter(bimg, null), (int)(x), (int)(y), null);
		
	}
	
	

	
	

}
