package trial;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CompetitorsList 
{
/////////////////////////////////////////////////////////////////////////////////
	
	private int[] frequency = new int[6];
	private ArrayList<KMACompetitor> CompetitorsList;
	
	//Array list to store all the competitor 
	private ArrayList<Super_Competitor> SupCompList;

	//Creates a new object in the CompetitorsList class
	 
/////////////////////////////////////////////////////////////////////////////////
	public CompetitorsList() 
	{
		// CompetitorsList = new ArrayList<KMACompetitor> ();
		SupCompList = new ArrayList<Super_Competitor>();
	}

/////////////////////////////////////////////////////////////////////////////////
	
	//Creates and returns the table of competitors
	public String getTableOfCompetitors() 
	{
		String report = "Competitor:                    Country       Level          Scores      Overall \n";
		report += "----------------------------   ------       -------       ---------    ------- \n";
		for (Super_Competitor c : SupCompList) {
			report += c.getShortDetails() + "\n";
		}
		return report;
	}
	
/////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Method to display the short details
	 * @param result
	 * @return
	 */
	public String findShortDetails(int result)
	{
		for (Super_Competitor c : SupCompList) 
		{
			if (c.getNum() == result) 
			{
				return c.getShortDetails();
			}
		}
		return "Not Found !";
	}
	
	/**
	 * Method to display the full details
	 * @param result
	 * @return
	 */
	
	public String findFullDetails(int result) 
	{
		for (Super_Competitor c : SupCompList) 
		{
			if (c.getNum() == result) 
			{
				return c.getFullDetails();
			}
		}
		return "Not Found !";
	}

/////////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns information of the competitor that got the maximum score
	 * 
	 * @return Max the competitor with the Max score
	 */
	public String getMaxScore() {
		double maxScore = 0;
		String name = "";
		boolean ok = false;
		String Max = "";
		for (Super_Competitor c : SupCompList) {
			double s = c.getOverallScore();
			String n = c.getName().getFullName();
			if (s > maxScore) {
				maxScore = s;
				name = n;
			} else if (s == maxScore) {
				name += "\n" + n;
				ok = true;
			}
		}
		if (ok == false) {
			Max = "\nThe Competitor with the highest score is " + name + " with an Overall Score of "
					+ String.format("%.1f", maxScore) + ".";
		} else if (ok == true) {
			Max = "\nCompetitors with the highest scores are \n" + name
					+ "\nHighest Overall score attained-- " + String.format("%.1f", maxScore) + ".";
		}
		return Max;
	}

/////////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns information of the competitor that got the minimum score
	 * 
	 * @return Min the competitor with the Min score
	 */
	public String getMinScore() {
		double minScore = 5;
		String name = "";
		boolean ok = false;
		String Min = "";
		for (Super_Competitor c : SupCompList) {
			double s = c.getOverallScore();
			String n = c.getName().getFullName();
			if (s < minScore) {
				minScore = s;
				name = n;
			} else if (s == minScore) {
				name += "\n" + n;
				ok = true;
			}
		}
		if (ok == false) {
			Min = "\nThe Competitor with the Lowest score is " + name + " with an Overall Score of "
					+ String.format("%.1f", minScore) + ".\n";
		} else if (ok == true) {
			Min = "\nCompetitors with the Lowest scores are \n" + name
					+ "Lighest Overall score attained-- " + String.format("%.1f", minScore) + ".\n";
		}
		return Min;
	}

/////////////////////////////////////////////////////////////////////////////////

	/**
	 * Writes supplied text to file
	 * 
	 * @param filename the name of the file to be written to
	 * @param report   the text to be written to the file
	 */
	public void writeToFile(String filename, String report, String statistic) 
	{

		FileWriter fw;
		try {
			fw = new FileWriter(filename);
			fw.write(report + statistic);
			fw.close();
		}
		// message and stop if file not found
		catch (FileNotFoundException fnf) {
			System.out.println(filename + " not found ");
			System.exit(0);
		}
		// stack trace here because we don't expect to come here
		catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Khaled's Read Method.
	/**
	 * Reads file with given name, extracting competitor data, creating competitor
	 * objects and adding them to the list of competitors Blank lines are skipped
	 * Validation for integer year, missing items
	 * 
	 * @param filename the name of the input file
	 */
	public void readFile(String filename) {
		try {
			File f = new File(filename);
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				// read first line and process it
				String inputLine = scanner.nextLine();
				if (inputLine.length() != 0) {// ignored if blank line
					processLine(inputLine);
				}

			}
		}
		// if the file is not found, stop with system exit
		catch (FileNotFoundException fnf) {
			System.out.println(filename + " not found ");
			System.exit(0);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Khaled's Process Method.
	/**
	 * Processes line, extracts data, creates Competitor object and adds to list
	 * Checks for non-numeric competitor number and missing items Will still crash
	 * if name entered without a space
	 * 
	 * @param line the line to be processed
	 */
	private void processLine(String line) 
	{
		try 
		{
			String parts[] = line.split(",");

			int cn = Integer.parseInt(parts[0]);
			Name name = new Name(parts[1]);
			String country = parts[2];
			String level = parts[3];

			int s1 = Integer.parseInt(parts[4]);
			int s2 = Integer.parseInt(parts[5]);
			int s3 = Integer.parseInt(parts[6]);
			int s4 = Integer.parseInt(parts[7]);
			int s5 = Integer.parseInt(parts[8]);
			int[] scores = { s1, s2, s3, s4, s5 };
			// create Competitor object and add to the list
			KMACompetitor khalidComp = new KMACompetitor(cn, name, level, country, name.getFirstName(),
					name.getIntialiest(), scores);
			// CompetitorsList.add(new KMACompetitor(cn, name.getFullName(), level, country,
			// name.getFirstName(), name.getIntialiest(), scores));
			SupCompList.add(khalidComp);

		}

		// for these two formatting errors, ignore lines in error and try and carry on

		// this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) 
		{
			String error = "Number conversion error in '" + line + "'  - " + nfe.getMessage();
			System.out.println(error);
		}
		// this catches missing items if only one or two items
		// other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) 
		{
			String error = "Not enough items in  : '" + line + "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Minu's Read Method.

	public void readFile_Minu(String filename) 
	{
		try 
		{
			File readF = new File(filename);
			Scanner scan = new Scanner(readF);
			while (scan.hasNextLine()) 
			{
				// To read the next line
				String inLine = scan.nextLine();
				if (inLine.length() != 0) 
				{
					// To store records into the competitor class
					storeInput_Minu(inLine);
				}

			}
			// Closes the file
			scan.close();
		} // When specified file is not found
		catch (FileNotFoundException e) 
		{
			System.out.println(filename + " not found ");
			System.exit(0);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Minu's Process Method.
	public void storeInput_Minu(String line) 
	{
		try {
			// Dividing into parts by separating by comma
			String parts[] = line.split(",");
			int regNum = Integer.parseInt(parts[0]);
			Name name = new Name(parts[1]);
			String level = parts[2];
			int age = Integer.parseInt(parts[3]);
			// Validating the age and throwing an exception if condition doesn't satisfy
			if (age > 30 || age < 10) 
			{
				throw new ArrayIndexOutOfBoundsException("Invalid Age");
			}
			int scores[] = new int[Minu_Competitor.getNumScore()];
			int i = 0;
			while (i < Minu_Competitor.getNumScore()) 
			{
				scores[i] = Integer.parseInt(parts[i+4]);
			
				if (scores[i] > 5) 
				{
					// Validates that all the scores are below or equals to 5
					// Validating the scores
					throw new ArrayIndexOutOfBoundsException("Score must be in range 0-5");
				}
				i++;
			}
			SupCompList.add(new Minu_Competitor(regNum, name, level, age, scores));
		}
		// Handles the number format exception
		catch (NumberFormatException e) 
		{
			String error = "Number conversion error in '" + line + "'  - " + e.getMessage();
			System.out.println(error);
			// Handles array out of bound ,age ,scores of the competitor
		} 
		catch (ArrayIndexOutOfBoundsException ae) 
		{
			String error = "Please verify  : '" + line + "' index position : " + ae.getMessage();
			System.out.println(error);
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////

	//Rayan's Read Method.
	/**
	 * reads file with given name, extracting Competitor data, creating competitor
	 * objects and adding them to the list of competitors Blank lines are skipped
	 * Validation for integer year, missing items
	 * 
	 * @param filename the name of the input file
	 */
	public void readFile_Rayan(String filename) {
		try {
			File f = new File(filename);
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				// read first line and process it
				String inputLine = scanner.nextLine();
				if (inputLine.length() != 0) {// ignored if blank line
					processLine_Rayan(inputLine);
				}
			}
		}
		// if the file is not found, stop with system exit
		catch (FileNotFoundException fnf) {
			System.out.println(filename + " not found ");
			System.exit(0);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Rayan's Process Line.
	/**
	 * Processes line, extracts data, creates Competitor object and adds to list
	 * Checks for non-numeric year and missing items Will still crash if name
	 * entered without a space
	 * 
	 * @param line the line to be processed
	 */
	private void processLine_Rayan(String line) {
		String idnum = "";
		String agenum = "";
		String weightnum = "";

		try {
			String parts[] = line.split(",");
			idnum = parts[0];
			idnum = idnum.trim(); // remove any spaces
			int id = Integer.parseInt(idnum);
			Name name = new Name(parts[1]);

			String level = parts[2];
			String country = parts[3];
			agenum = parts[4];
			agenum = agenum.trim(); // remove any spaces
			int age = Integer.parseInt(agenum);
			weightnum = parts[5];
			weightnum = weightnum.trim(); // remove any spaces
			double weight = Double.parseDouble(weightnum);

			// get scores first as string [] then convert it to int [] using lambda
			// expression
			int scoreLength = parts.length - 6;

			String[] scoreNum = new String[scoreLength];

			System.arraycopy(parts, 6, scoreNum, 0, scoreLength);

			String[] co = scoreNum;

			int[] scores = new int[co.length];
			// Creates the integer array.

			for (int i = 0; i < co.length; i++) {
				scores[i] = Integer.parseInt(co[i]);

			}

			// create Competitor object and add to the list
			SupCompList.add(new Rayan_Competitor(id, name, level, country, age, weight, scores));

		}
		// ignore lines in error and try and carry on
		// this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + line + "' - " + nfe.getMessage();
			System.out.println(error);
		}
		// this catches missing items if only one or two items
		// other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in : '" + line + "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Aisha's Read Method.
	/**
	 * This method reads the given file, line by line, and processes each line.
	 * 
	 * @param filename is the name of the file to be read.
	 */
	public void readFile_Aiysha(String filename) 
	{
		try 
		{
			File f = new File(filename);
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) 
			{
				// read first line and process it
				String inputLine = scanner.nextLine();
				if (inputLine.length() != 0) 
				{
					// ignored if blank line
					processLine_Aisha(inputLine);
				}
			} // scanner.close();
		}
		// if the file is not found, stop with system exit
		catch (FileNotFoundException fnf) 
		{
			System.out.println(filename + " not found.");
			System.exit(0);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	//Aisha's Process Method.
	/**
	 * This method is invoked by readFile and is given each line to separate and
	 * initialize them via relevant variables.
	 * 
	 * @param line is the single line of text from the .csv file.
	 */
	private void processLine_Aisha(String line) 
	{
		try 
		{
			String parts[] = line.split(",");
			int cNum = Integer.parseInt(parts[0]); // 0th element is cNum
			String name = parts[1]; // 1st element is cName
			Name cName = new Name(name);
			String cLevel = parts[2].trim(); // 2nd element is cLevel
			String cPosition = parts[3]; // 3rd element is cPosition
			int cAge = Integer.parseInt(parts[4].trim()); // 4th element is cAge
			String Gender = parts[5].trim(); // 5th element is cGender
			char cGender = Gender.charAt(0);

			Aisha_Competitor c = new Aisha_Competitor(cNum, cName, cLevel, cPosition, cAge, cGender);

			// get scores as integer values
			String scores[] = parts[6].split(" "); // 6th element is cScores
			int[] cScores;
			cScores = new int[Aisha_Competitor.No_of_Scores];
			for (int i = 0; i < scores.length; i++) {
				cScores[i] = Integer.parseInt(scores[i]);
				c.addScore(cScores[i]);
			}
			SupCompList.add(c);
		}
		// ignore lines in error and try and carry on
		// this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) 
		{
			String error = "Number conversion error in '" + line + "' - " + nfe.getMessage();
			System.out.println(error);
		}
		// this catches missing items if only one or two items
		// other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) 
		{
			String error = "Not enough items in : '" + line + "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Look up an id and return the corresponding staff details.
	 * 
	 * @param idThe id to be looked up.
	 * @return The details corresponding to the id, null if none
	 */
	public Super_Competitor findById(int id) {
		for (Super_Competitor s : SupCompList) {
			if (s.getNum() == id) {
				return s;
			}
		}
		return null;
	}
	
/////////////////////////////////////////////////////////////////////////////////

	//Method called when a choice is made regarding the category.
	public String makeAChoice(String Choice)
	{
		String report = "";
		if(Choice.equals("Swimmer"))
		{
			for(Object obj : SupCompList)
			{
				if(obj instanceof Rayan_Competitor)
				{
					report += ((Rayan_Competitor) obj).getShortDetails();
				}
			}
		}
		else if(Choice.equals("Chess"))
		{
			for(Object obj : SupCompList)
			{
				if(obj instanceof Minu_Competitor)
				{			
					report += ((Minu_Competitor) obj).getShortDetails();
				}
			}
		}
		else if(Choice.equals("Gaming"))
			for(Object obj : SupCompList)
			{
				if(obj instanceof KMACompetitor)
				{
					report += ((KMACompetitor) obj).getShortDetails();
				}
			}
		else if(Choice.equals("Basketball"))
			for(Object obj : SupCompList)
			{
				if(obj instanceof Aisha_Competitor)
				{
					report += ((Aisha_Competitor) obj).getShortDetails();
				}
			}
		else report = "Nothing!";
		
		return report;
	}
	
/////////////////////////////////////////////////////////////////////////////////

	//Method to list all competitor's Short Details.
	public String listAllComp()
	{
		String list = "";
		for (Super_Competitor c : SupCompList)
		{
			list += c.getShortDetails() + "\n";
		}
		return list + "\n";
	}

/////////////////////////////////////////////////////////////////////////////////
	
	//sort list by competitor number
	public void sortByCN() 
	{
		Collections.sort(SupCompList, new idComparator());
	}

/////////////////////////////////////////////////////////////////////////////////

	//sort list by name
	public void sortByName() 
	{
		Collections.sort(SupCompList, new nameComparator());
	}

/////////////////////////////////////////////////////////////////////////////////

	//sort list by overall scores
	public void sortByOS() 
	{
		Collections.sort(SupCompList, new OSComparator());
	}

/////////////////////////////////////////////////////////////////////////////////
}
