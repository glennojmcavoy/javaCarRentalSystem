package Main;
/**
 * 
 *  Class to hold information on peoples names
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

import java.util.Objects;

public class Name {

	private final String Forename;
	private final String Surname;
	
	/**
	 * @param forename
	 * @param surname
	 */
	public Name(String forename, String surname) 
	{
		
		this.Forename = forename;
		this.Surname = surname;
		
	}

	/**
	 * @return first name of person
	 */
	public String getFirstname() 
	{
		
		return this.Forename;
		
	}
	
	/**
	 * @return surname of person
	 */
	public String getSurname() 
	{
		
		return this.Surname;
		
	}
	
	/**
	 * @return the string representation of the current object
	 */
	@Override
	public String toString()
	{
		
		return getFirstname() + " - " + getSurname();
		
	}
	
	public static Name valueOf(String name)
	{
		
		String split[] = name.split(" - ");
		
		Name n = new Name(split[0],split[1]);
		
		return n;
		
	}
	
	/**
	 * @return if two objects are equal or not
	 */
	@Override
	public boolean equals(Object obj) 
	{
		
		if(obj instanceof Name) 
		{
			
			Name comparator = (Name) obj;
			
			if(comparator.getFirstname().equals(this.getFirstname()) 
			   && comparator.getSurname().equals(this.getSurname())) 
			{
			
				return true;
				
			}
							
		}
		
		return false;
		
	}
	
	/**
	 * @return hash code of object
	 */
	@Override
	public int hashCode() 
	{

		return Objects.hash(getFirstname(), getSurname());

	}
	
}
