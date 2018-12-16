package trial;
import java.util.Comparator;

public class nameComparator implements Comparator<Super_Competitor>
{	
/////////////////////////////////////////////////////////////////////////////////

	 public int compare (Super_Competitor c1, Super_Competitor c2) 
	 {
		 String n1 = c1.getName().getFullName();
		 String n2 = c2.getName().getFullName();
		 return n1.compareTo(n2);
	 }

/////////////////////////////////////////////////////////////////////////////////
}
