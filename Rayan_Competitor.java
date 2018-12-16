package trial;
import java.util.Arrays;

/**
 * Swimmer Competitor class this class hold details of the competitor
 * 
 * @author Rayan Salah
 */
public class Rayan_Competitor extends Super_Competitor {

	/**
	 * Creates a competitor object with values specified in the parameters
	 * 
	 * @param num number of the competitor
	 * @param fN  first name of the competitor
	 * @param mN  middle name of the competitor
	 * @param lN  last name of the competitor
	 * @param le  level of the competitor
	 * @param cou country of the competitor
	 * @param aGe age of the competitor
	 * @param w   weight of the competitor
	 */

	private int number;
	private Name name;
	private String level;
	private String country;
	private int age;
	private double weight;// weight in kg
	public int[] scoreCatg; // score catgory 1,2,3,4,5

	/**
	 * Constructor 
	 * @param number
	 * @param name
	 * @param level
	 * @param country
	 * @param age
	 * @param weight
	 * @param scoreCatg
	 */
	public Rayan_Competitor(int number, Name name, String level, String country, int age, double weight,
			int[] scoreCatg) {
		super(number, name, level);
		this.number = number;
		this.name = name;
		this.level = level;
		this.country = country;
		this.age = age;
		this.weight = weight;
		this.scoreCatg = scoreCatg;
	}

	// instance variables

	/**
	 * returns the competitor number
	 * 
	 * @return the number
	 */

	public int getSnum() {
		return number;
	}
	/** To set the scores 
	 * @see Super_Competitor#setScores(int[])
	 */
	public void setScores(int[] scores) {
		this.scoreCatg = scores;
	}

	/**
	 * returns the competitor name
	 * 
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * returns the competitor level
	 * 
	 * @return the level
	 */
	public String getlevel() {
		return level;
	}

	/**
	 * returns the competitor country
	 * 
	 * @return the country
	 */
	public String getcountry() {
		return country;
	}

	/**
	 * returns the competitor age
	 * 
	 * @return the age
	 */
	public int getage() {
		return age;
	}

	/**
	 * returns the competitor weight
	 * 
	 * @return the weight
	 */
	public double getweight() {
		return weight;
	}

	// traverse list of qualifications, returning details as a String
	// demonstrates traversing array using array length
	// and adding details of each array element to a String
	public int[] getScoreCatg() {

		return scoreCatg;

	}

	/**
	 * This method returns the Score Array of the Competitor.
	 * 
	 * @return The compScore Array.
	 */
	public int[] getScoreArray() {

		return scoreCatg;

	}

	/**
	 * returns the competitor maxScore
	 * 
	 * @return the maxScore
	 */
	// returns the maximum score
	// ALGORITHM
	// assumes first score is the maximum
	// for each score,
	// if it is greater than the maximum
	// make it the maximum
	public int getMaxcat() {
		int max = scoreCatg[0];
		for (int i = 1; i < 5; i++) {
			if (scoreCatg[i] > max) {
				max = scoreCatg[i];
			}
		}
		return max;
	}

	/**
	 * returns the overall score of the competitor
	 * 
	 * @return the overall score
	 */
	// return the average score of the maximum score and the minimum score

	public double getOverallScore() {
		double total = 0;

		total = this.getMaxcat() + this.getMincatScore();
		return total / 2;

	}

	/**
	 * returns the competitor minScore
	 * 
	 * @return the minScore
	 */
	// returns the minimum score
	// ALGORITHM
	// assumes first score is the minimum
	// for each score,
	// if it is less than the minimum
	// make it the minimum
	public int getMincatScore() {
		int min = scoreCatg[0];
		for (int i = 1; i < 5; i++) {
			if (scoreCatg[i] < min) {
				min = scoreCatg[i];
			}
		}
		return min;
	}

	/**
	 * returns the full the details of the competitor
	 * 
	 * @return the full the details of the competitor
	 */

	public String getFullDetails() {

		return "Full details for " + Integer.toString(this.getSnum()) + '\n' + "Competitor name " + name.getFullName()
				+ ", " + "country " + country + "." + '\n' + name.getFirstName() + " is a " + level + " aged " + age
				+ " and has an overall score of " + Double.toString(this.getOverallScore()) + "."
				+ " and has maximum score " + this.getMaxcat() + " and has minimum score " + this.getMincatScore()
				+ " received these scores : " + Arrays.toString(this.getScoreCatg());
	}

	@Override
	public int compareTo(Super_Competitor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
