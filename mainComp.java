package trial;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class mainComp 
{
/////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) 
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("The application has started at "+sdf.format(cal.getTime())+ ".");
		
		New_GUI obj = new New_GUI();
		obj.showMainWindow();
	}
/////////////////////////////////////////////////////////////////////////////////
} //end main method