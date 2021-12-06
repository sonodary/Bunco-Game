/**
 * A class for Player who play games
 * @author Ryu Sonoda
 *
 */
public class Player {
	
	private String userName = "Computer";
	private int score;
	private int winCount;
	
		/** 
		 * Construct the player with parameter that stores the player's name, score, and winning count
		 * @param input, player's name
		 */
		public Player (String input) {
			userName = input;
			score = 0;
			winCount = 0;
		}
		
		/**
		 * Construct the player without parameter. Default name is Computer 
		 */
		public Player () {
			score = 0;
			winCount = 0;
		}
		
		/**
		 * Get the player's name
		 * @return the player's name
		 */
		public String getUserName() {
			return userName;
		}
		
		/**
		 * Get the score
		 * @return the score
		 */
		public int getScore() {
			return score;
		}
		
		/**
		 * Set the score 
		 * @param score, the score the user want to set
		 */
		public void setScore(int score) {
			this.score = score;
		}
		
		/**
		 * Reset the score to zero
		 */
		public void resetScore() {
			score = 0;
		}
		
		/**
		 * Get the number of winning of the player
		 * @return winCount
		 */
		public int getWinCount() {
			return winCount;
		}
		
		/**
		 * Increment the winning count
		 */
		public void incrementWinCount() {
			winCount++;
		}
		
}
