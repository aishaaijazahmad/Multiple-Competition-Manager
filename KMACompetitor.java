package trial;
/**
 * Software Engineering Foundations KMACompetitor class that returns the
 * competitor name, level, country, number,score. With overall score
 * calculation, data formating and maximum & minimum score methods.
 * 
 * @author Khaled AlSabahi
 */
public class KMACompetitor extends Super_Competitor {

	// Instance variables
	private int compNumber;
	private Name compName;
	private String level;
	private String country;
	private String firstN;
	private String Letters;
	private int[] Scores;

	private int Max = 5;

	/**
	 * Creates a Competitor object with values specified in the parameters
	 * 
	 * @param CN    the competitor number
	 * @param cName the competitor name
	 * @param lvl   the competitor level
	 * @param con   the competitor country
	 * @param f     the competitor first name
	 * @param l     the competitor full name initials
	 * @param S     the competitor scores
	 */
	public KMACompetitor(int compNumber, Name compName, String level, String country, String firstN, String Letters,
			int[] Scores) {

		super(compNumber, compName, level);
		this.compNumber = compNumber;
		this.compName = compName;
		this.level = level;
		this.country = country;
		this.firstN = firstN;
		this.Letters = Letters;
		this.Scores = Scores;

	}

	/**
	 * returns the competitor score
	 * 
	 * @return the Scores
	 */
	public int[] getScoreArray() {
		return Scores;
	}

	/**
	 * returns the competitor name
	 * 
	 * @return compName
	 */
	public Name getCompName() {
		return compName;
	}

	/**
	 * returns the competitor level
	 * 
	 * @return level
	 */
	public String getCompLevel() {
		return level;
	}

	/**
	 * returns the competitor country
	 * 
	 * @return country
	 */
	public String getCompCountry() {
		return country;
	}

	/**
	 * returns the competitor number
	 * 
	 * @return comNumber
	 */
	public int getCompNumber() {
		return compNumber;
	}

	/**
	 * Calculate the overall score depending on the competitor level for e.g. if the
	 * competitor scored 5 in a row and his an EXPERT reward him with an extra 0.5
	 * point for each streak
	 * 
	 * @param overallScore the competitor overall scores
	 * @return overallScore the overallScore
	 */
	public double getOverallScore() {

		double overallScore = 0;
		for (int i = 0; i < Scores.length; i++) {

			if (i == 0) {
				overallScore = Scores[i] * 0.1;
			}

			else {
				overallScore += Scores[i] * 0.1;
			}

			if (i != 0 && Scores[i] == Scores[i - 1] && Scores[i - 1] == 5 && level.equals("EXPERT")) {

				overallScore += 0.5;

			} else if (i != 0 && Scores[i] == Scores[i - 1] && Scores[i - 1] == 5 && level.equals("NOVIC")) {

				overallScore += 0.3;
			}

			overallScore += overallScore;

		}

		if (level.equals("EXPERT")) {
			overallScore = overallScore / (Scores.length * 1.84);
		} else if (level.equals("NOVIC")) {
			overallScore = overallScore / (Scores.length * 1.59);
		} else {
			overallScore = overallScore / (Scores.length * 1.24);
		}

		return overallScore;

	}

	/**
	 * Calculate the maximum overall score of the competitors
	 * 
	 * @param max the competitor maximum overall score
	 * @return max the maximum overallScore
	 */
	public double getMaxOS(double max) {
		for (int i = 0; Scores[0] == Scores[i]; i++) {
			max = getOverallScore();
		}
		if (getOverallScore() > max) {
			max = getOverallScore();
		}
		return max;
	}

	/**
	 * Calculate the frequency of the obtained scores of the competitors
	 * 
	 * @return s the array of frequencies
	 */
	public int[] getFrequency() {
		int[] s = new int[Scores.length + 1];
		for (int i = 0; i < s.length; i++) {
			s[i] = 0;
		}
		for (int i = 0; i < Scores.length; i++) {

			if (Scores[i] == Max) {
				s[5]++;
			}

			else if (Scores[i] == Max - 1) {
				s[4]++;
			}

			else if (Scores[i] == Max - 2) {
				s[3]++;
			} else if (Scores[i] == Max - 3) {
				s[2]++;
			} else if (Scores[i] == Max - 4) {
				s[1]++;
			} else {
				s[0]++;
			}
		}
		return s;
	}

	/**
	 * returns the competitor full details
	 * 
	 * @return the fullN
	 */
	public String getFullDetails() {

		String fullN = "\nFull details for " + compNumber + ":\nCompetitor Number: " + compNumber + ", name "
				+ compName.getFullName() + ", country " + country + ".\n" + firstN + " is an " + level
				+ " player that recived these scores : " + Scores[0] + "," + Scores[1] + "," + Scores[2] + ","
				+ Scores[3] + "," + Scores[4] + "\nThis gives " + firstN + " an overall score of "
				+ String.format("%.1f", getOverallScore()) + ".";

		return fullN;

	}

	/**
	 * returns the competitor details to to output it in the competitors list
	 * 
	 * @return the list
	 */
	public String getList() {

		String list = String.format("%-5d", compNumber) + String.format("%-26s", compName.getFullName())
				+ String.format("%-13s", country) + String.format("%-6s", level) + String.format("%9s", Scores[0]) + " "
				+ Scores[1] + " " + Scores[2] + " " + Scores[3] + " " + Scores[4]
				+ String.format("%8.1f", getOverallScore());
		return list;

	}

	/**
	 * returns the competitor list in string format
	 * 
	 * @return the formated list String.format(getList(), 0)
	 */
	public String toString() {

		return String.format(getList(), 0);

	}

	/**
	 * returns the competitor first name
	 * 
	 * @return firstN
	 */
	public String getFirstName() {
		return firstN;
	}
	
	/** To set the scores 
	 * @see Super_Competitor#setScores(int[])
	 */

	public void setScores(int[] scores) {
		this.Scores = scores;
	}

	@Override
	public int compareTo(Super_Competitor o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
