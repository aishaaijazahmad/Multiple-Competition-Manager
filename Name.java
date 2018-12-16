package trial;
/**
 * Software Engineering Foundations
 * Name class that returns the competitor name in different format depending on the programmer desire.
 * @author Khaled Alsabahi
 */
public class Name {
  private String firstName;
  private String middleName;
  private String lastName;
  
  //constructor to create object with a first and last name
  public Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
  }
  
  //constructor to create object with first, middle and last name
  //if there isn't a middle name, that parameter could be an empty String
  public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
}
  //constructor to create name from full name
  //in the format first name then space then last name
  //or first name then space then middle name then space then last name
  public Name(String fullName) 
  {
	  int spacePos1 = fullName.indexOf(' ');
	  if (spacePos1 >= 0) 
	  {
		  firstName = fullName.substring(0, spacePos1);
		  int spacePos2 = fullName.lastIndexOf(' ');
		  if (spacePos1 == spacePos2)
		  {
			  middleName = "";
			  lastName = fullName.substring(spacePos1 + 1, fullName.length());
		  }
		  else
		  {
			  middleName = fullName.substring(spacePos1+1, spacePos2);
			  lastName = fullName.substring(spacePos2 + 1);
		  }
	  }
	  else 
	  {
		  firstName = fullName;
		  middleName = "";
	      lastName = "";
	  

		}
	}
  
  //returns the first name
  	public String getFirstName() 
  	{
  		return firstName; 
  	}

  	public String getLastName() 
  	{
  		return lastName; 
  	}
  
  	//change the last name to the value provided in the parameter
  	public void setLastName(String ln) 
  	{
  		lastName = ln;
  	}

  	public String getIntialiest() 
  	{
  		String initials = "";
		// Divide the name by parts by spliting with ' '
		String[] parts = getFullName().split(" ");
		char initial;
		for (int i = 0; i < parts.length; i++) 
		{
			// Append First letter of each part to the string
			initial = parts[i].charAt(0);
			initials += initial;
		}
		// Convert into upper case
		return (initials.toUpperCase());
		
  }

  //returns the full name
  //either first name then space then last name
  //or first name then space then middle name then space
  //  and then last name
  public String getFullName() 
  {
	  String result = firstName + " ";
	  if (!middleName.equals("")) 
	  {
	    	result += middleName + " ";
	  }
	  result += lastName;
	  return result;
	 }
}