/**
 * A class for a dice
 * @author Ryu Sonoda
 */

import java.util.Random;

public class Dice {
	private int pip;
	private Random random;
	
	/**
	 * Construct a dice that stores its pip
	 */
	public Dice () {
		random = new Random();
		pip = random.nextInt(6) + 1;
	}
	
	/**
	 * Roll a dice and the pip between 1 and 6 is generated randomly
	 */
	public void roll () {
		pip = random.nextInt(6) + 1;
	}
	
	/**
	 * Get the pip
	 * @return pip, a random number from 1 to 6
	 */
	public int getPip() {
		return pip;
	}

}
