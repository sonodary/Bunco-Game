
public class BuncoGame {
	private int round;
	private DiceCup diceBox;
	private Player player;
	private Player house;

	/**
	 * Construct a Bunco game that stores a dice box, player and the house.
	 * @param diceBox
	 * @param player
	 * @param computer
	 */
	public BuncoGame (DiceCup diceBox, Player player, Player computer) {
		round = 1;
		this.diceBox = diceBox;
		this.player = player;
		house = computer;
	}
	
	/**
	 * Get the round 
	 * @return round, round the players are playing
	 */
	public int getRound () {
		return round;
	}

	/**
	 * Set the round as the user assigned
	 * @param num, the round the user want to set
	 */
	public void setRound (int num) {
		round = num;
	}
	
	/**
	 * Get the dice box
	 * @return dice box which hold three dice to use in the game
	 */
	public DiceCup getDiceBox () {
		return diceBox;
	}
	
	/**
	 * Get the player
	 * @return user who plays the game
	 */
	public Player getPlayer () {
		return player;
	}
	
	/**
	 * Get the house
	 * @return house who plays the game with the user
	 */
	public Player getHouse() {
		return house;
	}
	
	/**
	 * Increment the round 
	 */
	public void incrementRound() {
		round++;
	}
	
	/**
	 * Check whether the dices are Bunco
	 * If a player rolls all three dice so that they match the corresponding round number. It is a Bunco
	 * @return true if it is a Bunco, false otherwise
	 */
	public boolean isABunco () {
		return round == diceBox.getDice1().getPip() && diceBox.arePipsSame();
	}
	
	/**
	 * Check whether the dices are a mini Bunco
	 * If a player rolls the three same pips in a different round, it is a mini Bunco
	 * @return true if it is a mini Bunco, false otherwise
	 */
	public boolean isAMiniBunco () {
		return diceBox.arePipsSame();
	}
	
	/**
	 * Check whether any dices match the round
	 * @return true if it is any dices match the round, false otherwise
	 */
	public boolean isContinue () {
		return diceBox.getDice1().getPip() == round || diceBox.getDice2().getPip() == round || diceBox.getDice3().getPip() == round; 
	}
	
	/**
	 * Play a round for one player
	 * As long as at least dice matches the round, the player keeps playing.
	 * If it is a Bunco,  
	 * @param ply, the player who plays the round
	 */
	public void playRound (Player ply) {
		do {
			diceBox.rollDices();
			//Display what dices the player got
			System.out.println(ply.getUserName() +  " got " + diceBox.getDice1().getPip() + ", " + diceBox.getDice2().getPip() + ", " + diceBox.getDice3().getPip());
			//21 points are awarded for a Bunco, and end the round
			if (isABunco()) {
				ply.setScore(ply.getScore() + 21);
			}
			//Five points are awarded for a mini Bunco
			else if (isAMiniBunco ()) {
				ply.setScore(ply.getScore() + 5);
			}
			//One point is awarded for each target number rolled successfully
			else if (isContinue()) {
				if (diceBox.getDice1().getPip() == round) {
					ply.setScore(ply.getScore() + 1);
				}
				if (diceBox.getDice2().getPip() == round) {
					ply.setScore(ply.getScore() + 1);
				}
				if (diceBox.getDice3().getPip() == round) {
					ply.setScore(ply.getScore() + 1);
				}
			}	
			//Display the current score when any dices do not match the round and finish their turn
			else {
				System.out.println(ply.getUserName() + "\'s" + " score: " + ply.getScore());
				break;
			}		
			//Display the current score
			System.out.println(ply.getUserName() + "\'s" + " score: " + ply.getScore());
		} while (isContinue() || isAMiniBunco ());
	}
	
	/**
	 * If the player's score is higher, the player is a winner
	 * If the house's score is higher, the house is winner
	 * Otherwise, it is even
	 * @return current winner of the game. If no one wins, return null
	 */
	public String currenWinner () {
		if (player.getScore() > house.getScore()) {
			player.incrementWinCount();;
			return player.getUserName();
		}
		else if (player.getScore() < house.getScore()){
			house.incrementWinCount();;
			return house.getUserName();
		}
		else {
			return null;
		}
	}
}
