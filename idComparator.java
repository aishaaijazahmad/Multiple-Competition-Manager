package trial;

import java.util.Comparator;

public class idComparator implements Comparator<Super_Competitor> 
{
	public int compare (Super_Competitor c1, Super_Competitor c2) 
	{
		double t1 = c1.getNum();
		double t2 = c2.getNum();
		if (t1> t2) return 1;
		else if (t1 < t2) return -1;
		else return 0; 
	}
}