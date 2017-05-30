package war_zone;

public class Lookup {
	
	final static double[] cos = calcCos();
	final static double[] sin = calcSin();
	
	public static double[] calcSin(){
		double[] sin = new double[360];
		for (int i=0; i < sin.length; i++ ){
			sin[i] = Math.sin(i*Math.PI/180);
		}
		return sin;
	}
	
	public static double[] calcCos(){
		double[] cos = new double[360];
		for (int i=0; i < cos.length; i++ ){
			cos[i] = Math.cos(i*Math.PI/180);
		}
		return cos;
	}
	
}
