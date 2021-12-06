/**
 *  A class that hold a dice box which stores three dices
 * @author Ryu Sonoda
 *
 */
public class DiceCup {
	private Dice dice1;
	private Dice dice2;
	private Dice dice3;
	
	/**
	 * Construct a dice box that stores three dices
	 */
	public DiceCup () {
		dice1 = new Dice();
		dice2 = new Dice();
		dice3 = new Dice();
	}
	
	/**
	 * Roll three dices in the dice box
	 */
	public void rollDices () {
		dice1.roll();
		dice2.roll();
		dice3.roll();
	}
	
	/**
	 * Check whether the all dices have the same pip
	 * @return true if the all dices have the same pip, false otherwise.
	 */
	public boolean arePipsSame() {
		return (dice1.getPip() == dice2.getPip()) && (dice1.getPip() == dice3.getPip());
	}
	
	/**
	 * Get the pip of the first dice
	 * @return the pip of the first dice
	 */
	public Dice getDice1() {
		return dice1;
	}
	
	/**
	 * Get the pip of the second dice
	 * @return the pip of the second dice
	 */
	public Dice getDice2() {
		return dice2;
	}
	
	/**
	 * Get the pip of the third dice
	 * @return the pip of the third dice
	 */
	public Dice getDice3() {
		return dice3;
	}

}
