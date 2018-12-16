package trial;

public class CompetitorsManager 
{
/////////////////////////////////////////////////////////////////////////////////

	private CompetitorsList allCompetitors;
	
	public CompetitorsManager() 
	{
		allCompetitors = new CompetitorsList();
	}

/////////////////////////////////////////////////////////////////////////////////

	public void run() 
	{	
	   //==================================FILES=======================================================================
		allCompetitors.readFile("C:\\Users\\Aisha Aijaz Ahmad\\Desktop\\Khaled.csv");
		allCompetitors.readFile_Minu("C:\\Users\\Aisha Aijaz Ahmad\\Desktop\\Minu.csv");
		allCompetitors.readFile_Rayan("C:\\Users\\Aisha Aijaz Ahmad\\Desktop\\Rayan.csv");
		allCompetitors.readFile_Aiysha("C:\\Users\\Aisha Aijaz Ahmad\\Desktop\\Aisha.csv");
	  //============================================================================================================

        allCompetitors.getTableOfCompetitors();
               
	}
/////////////////////////////////////////////////////////////////////////////////
}