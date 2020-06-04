package Main;
/**
 * 
 *  Class used to represent a person and their attributes
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Person {

	private final Name Nameval;
	private final Date DOB;
	private final DrivingLicence DrivingLicence;
	
	/**
	 * @param name
	 * @param dob
	 * @param drivingLicence
	 */
	public Person(Name name, Date dob, DrivingLicence drivingLicence) 
	{
	
		this.Nameval = name;
		this.DOB = dob;
		this.DrivingLicence = drivingLicence; 
		
	}
	
	/**
	 * @return the string representation of the current object
	 */
	public String toString()
	{
		
		return getName() + " - " + getDOB() + " - " + getAge() + " - " + getDrivingLicence();
		
	}
	

	/**
	 * @return driving licence for person
	 */
	public DrivingLicence getDrivingLicence() 
	{
		
		return DrivingLicence;
		
	}
	
	/**
	 * @return the persons name
	 */
	public Name getName() 
	{
		
		return Nameval;
		
	}
	
	/**
	 * @return defensive copy of persons date of birth
	 */
	public String getDOB() 
	{
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTime(DOB);
		
		return c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH);
		
	}
	
	/**
	 * @return persons age
	 */
	public int getAge()
	{
		
		LocalDate birthday = DOB.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();//conversion to local date
		return Period.between(birthday,LocalDate.now()).getYears();
	
	}
	
	/**
	 * @return whether two person objects are equal or not
	 */
	public boolean equals(Object obj) 
	{
		if(obj instanceof Person) 
		{
			Person comparator = (Person) obj;
			if(comparator.getName().equals(this.getName()) && comparator.getDOB().equals(this.getDOB())) 
			{
			
				return true;
				
			}
			
		}
		return false;
		
	}
	
	/**
	 * @return hash code value of person
	 */
	@Override
	public int hashCode() 
	{

		return Objects.hash(getName(), getDOB());

	}
	
}
