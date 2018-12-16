package trial;

/**
 * This Class stores details of each competitor Calculation on overall score is
 * done in this ChessCompetitor class * @author Minu
 *
 */
public class Minu_Competitor extends Super_Competitor {

	private int regNumber;
	private Name competitorName;
	private int competitorAge;
	private String competitorLevel;
	
	// Size of the array is given as fixed
	private static final int Num_Score = 5;
	private int[] scores;

	/**
	 * Constructor to initialize
	 * 
	 * @param regNumber
	 * @param competitorName
	 * @param competitorAge
	 * @param competitorLevel
	 * @param scores
	 */
	public Minu_Competitor(int regNumber, Name competitorName, String competitorLevel, int competitorAge,
			int[] scores) {
		super(regNumber, competitorName, competitorLevel);
		this.regNumber = regNumber;
		this.competitorName = competitorName;
		this.competitorAge = competitorAge;
		this.competitorLevel = competitorLevel;
		this.scores = new int[Num_Score];
		this.scores = scores;
		
		

	}

	/**
	 * To get Competitor Level
	 * 
	 * @return int competitorLevel
	*/

	public int getCompetitorLevel() {

		switch (competitorLevel) {
		case "Novice":
			return 2;
		case "Competent":
			return 3;
		case "Proficient":
			return 4;
		case "Expert":
			return 5;
		default:
			return 0;
		}
	}

	/**
	 * Method to get registration number
	 * 
	 * @return regNumber
	 */
	public int getRegNumber() {
		return regNumber;
	}

	/**
	 * To set registration number
	 * 
	 * @param regNumber
	 */
	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}

	/**
	 * To get Competitor Name
	 * 
	 * @return competitorName
	 */
	public Name getCompetitorName() {
		return competitorName;
	}

	/**
	 * To set Competitor Name
	 * 
	 * @param competitorName
	 */
	public void setCompetitorName(Name competitorName) {
		this.competitorName = competitorName;
	}

	/**
	 * To get Competitor Age
	 * 
	 * @return competitorAge
	 */
	public int getCompetitorAge() {
		return competitorAge;
	}

	/**
	 * To set Competitor Age
	 * 
	 * @param competitorAge
	 */
	public void setCompetitorAge(int competitorAge) {
		this.competitorAge = competitorAge;
	}

	/**
	 * To set Competitor level
	 * 
	 * @param level
	 */
	public void setCompetitorLevel(String level) {
		this.competitorLevel = competitorLevel.valueOf(level);

	}

	/**
	 * To get the score
	 * 
	 * @return scores
	 */
	public int[] getScoreArray() {
		return scores;
	}

	/**
	 * To set the scores
	 * 
	 * @param scores
	 */
	public void setScores(int[] scores) {
		this.scores = scores;
	}

	/**
	 * To access the size of the array from other class
	 * 
	 * @return Num_Score
	 */
	public static int getNumScore() {
		return Num_Score;
	}

	/**
	 * Returns the integer array in string format for printing it .
	 * 
	 * @return report.substring(0, report.length() - 1)
	 */
	public String getScoresToPrint() {
		String report = "";
		// Iterate till the end of the array
		for (int scoreIndex = 0; scoreIndex < Num_Score; scoreIndex++) {
			// Append each element of array into the string
			report += scores[scoreIndex] + " ";
		}
		// report.length() - 1 is used to eliminate the last space that is appended from
		// the above for loop
		return report.substring(0, report.length() - 1);

	}

	/**
	 * To get the average score of the competitor
	 * 
	 * @param avrgIndex
	 * @return (double) total / avrgIndex
	 */
	public double getAveScore(int avrgIndex) {
		int total = 0;
		// scoreSort is used to sort the array
		// Sorting technique used is bubble sort
		scoreSort(scores);
		// For retrieving the highest score
		for (int scoreIndex = Num_Score - 1; scoreIndex >= Num_Score - avrgIndex; scoreIndex--) {
			total += scores[scoreIndex];
		}
		// avrgIndex is the value corresponding to enum
		// avrgIndex ranges from 2 to 5
		return (double) total / avrgIndex;
	}

	/**
	 * To sort the array of scores Bubble sort is used for sorting
	 * 
	 * @param scores
	 */
	public void scoreSort(int[] scores) {
		int tempVar = 0;
		for (int i = 0; i < Num_Score; i++) {
			for (int j = 1; j < (Num_Score - i); j++) {
				if (scores[j - 1] > scores[j]) {
					// Swap the elements
					tempVar = scores[j - 1];
					scores[j - 1] = scores[j];
					scores[j] = tempVar;
				}
			}
		}

	}

	/**
	 * To get the overall Score
	 * 
	 * @return
	 */
	public double getOverallScore() {
		int level = getCompetitorLevel();
		double avegScore = getAveScore(level);

		return avegScore;
	}

	/**
	 * To get the category of the candidate
	 * 
	 * @return category
	 */
	public String getCompCategry() {
		String category = "";
		if (10 < getCompetitorAge() && 20 > getCompetitorAge()) {
			category = "Junior";
		} else if (20 <= getCompetitorAge() && 30 > getCompetitorAge()) {
			category = "Senior";
		} else {
			category = "unknown/invalid";
		}
		return category;
	}

	/**
	 * To get the full details of the competitor for printing on users choice
	 * 
	 * @return report
	 */
	public String getFullDetails()

	{
		String report = "\n\nFull Details Of Competitor : \n\n";
		report += "Competitor Number :" + getRegNumber();
		report += "\nCompetitor Name   :" + getCompetitorName().getFullName();
		// Replaced the space with comma
		report += "\nScores Obtained   :" + getScoresToPrint().replace(' ', ',');
		report += "\nAge category      :" + getCompCategry() + "\n";
		report += "\n" + getCompetitorName().getFirstName() + " is a " + getCompetitorLevel();
		report += " Aged " + getCompetitorAge() + " competitor with overall score of ";
		// Overall score is rounded of to 2 decimal places
		report += String.format("%-1.2f", getOverallScore());
		return report;
	}

	@Override
	public int compareTo(Super_Competitor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
