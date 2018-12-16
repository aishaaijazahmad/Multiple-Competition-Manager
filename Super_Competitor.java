package trial;

public abstract class Super_Competitor implements Comparable<Super_Competitor> 
{
/////////////////////////////////////////////////////////////////////////////////

	private int compNum;
	private Name compName;
	private String compLevel;
	private String Letters;
	
/////////////////////////////////////////////////////////////////////////////////
	
	public Super_Competitor(int compNum, Name compName, String compLevel) 
	{
		this.compNum = compNum;
		this.compName = compName;
		this.compLevel = compLevel;
	}
	
/////////////////////////////////////////////////////////////////////////////////

	public int getNum()
	{
		return compNum;
	}
	public Name getName()
	{
		return compName;
	}
	public String getLevel()
	{
		return compLevel;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	public void setName(Name compName) 
	{
		this.compName = compName;
	}
	public void setNum(int compNum)
	{
		this.compNum = compNum;
	}  
	public void setLevel(String compLevel) 
	{
		this.compLevel = compLevel; 
	} 
	
/////////////////////////////////////////////////////////////////////////////////

	public String getShortDetails()
	{
		Letters = compName.getIntialiest();
		String Short = "\nCN: " + compNum + " (" + Letters + ") has an overall score of "+ String.format ("%.1f", getOverallScore())+".\n";
		return Short;
	}

/////////////////////////////////////////////////////////////////////////////////

	public abstract double getOverallScore();
	public abstract String getFullDetails();
	public abstract int[] getScoreArray();
	public abstract void setScores(int[] scores);
	
/////////////////////////////////////////////////////////////////////////////////	
}
