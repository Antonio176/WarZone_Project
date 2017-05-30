package war_zone;

/*
 *  This class is to keep track of score
 */

public class Score {
	
	   protected int points = 0;
	   protected int tanksLeft = 20;
	   protected int bulletsLeft = 50;
	   
	   // probably wont use
	   public void reset(){
	      points = 0;
	      tanksLeft = 20;
	      bulletsLeft = 50;
	   }
	   // get score
	  public int getScore(){
	      return points;
	   }
	  // get tanks that are left 
	   public int getTanksLeft(){
	      return tanksLeft;
	   }
	   // get bullets that are left
	   public int getBulletsLeft(){
		   return bulletsLeft;
	   }
	   // increment score 
	   public void incrementScore(int increment){
	      points += increment;
	   }
	   // decrement tanks 
	   public void decrementTanks(){
	      tanksLeft--;
	   }
	   // decrement bullets 
	   public void decrementBullets(){
		   bulletsLeft--;
	   }
	   // determine when game is won
	   public boolean GameIsWon(){
	      return tanksLeft <= 0;
	   }
	   // determine when game is lost
	   public boolean GameIsLost(){
		   return bulletsLeft == 0;
	   }

}
