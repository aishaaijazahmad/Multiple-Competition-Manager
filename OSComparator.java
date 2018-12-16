package trial;
import java.util.Comparator;

public class OSComparator implements Comparator<Super_Competitor> 
{
/////////////////////////////////////////////////////////////////////////////////
	public int compare (Super_Competitor c1, Super_Competitor c2) 
	{
		double t1 = c1.getOverallScore();
		double t2 = c2.getOverallScore();
		if (t1< t2) return 1;
		else if (t1 > t2) return -1;
		else return 0; 
	}
/////////////////////////////////////////////////////////////////////////////////

}