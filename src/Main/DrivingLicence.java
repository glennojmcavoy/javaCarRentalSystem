package Main;
/**
	@author b6006281
	@version 1.0 24/10/2019
*/

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public final class DrivingLicence {

	private static Map<String,Integer> LicenceNumberMap = new HashMap<String,Integer>();
	
	private final String LicenceNumber;
	private String Initials;
	private String YearOfIssue;
	private int SerialNumber;
	private final Date DateOfIssue;
	private final boolean IsFull;
	
	/**
	 * @param dateOfIssue
	 * @param isFull
	 * @param name
	 */
	public DrivingLicence(Date dateOfIssue, boolean isFull, Name name) 
	{
		
		this.DateOfIssue = dateOfIssue;
		this.IsFull = isFull;
		this.LicenceNumber = generateLicenceNumber(name, dateOfIssue);
		
	}

	/**
	 * @return a string representation of the current object
	 */
	public String toString()
	{
		
		return getLicenceHeldFor() + " - " + getIsFull() +" - " + getLicenceNumber() + " - " + getDateOfIssue();
		
	}
	
	
	/**
	 * 
	 * @param n - a name object
	 * @param doi - the date driving licence issued
	 * @return the generated licence number
	 */
	public String generateLicenceNumber(Name n, Date doi) 
	{

		Initials = n.getFirstname().substring(0,1) + n.getSurname().substring(0,1);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(doi);
		YearOfIssue =  Integer.toString(calendar.get(Calendar.YEAR));
		
		String penultimate = Initials + "-" + YearOfIssue + "-";
		
		if(LicenceNumberMap.containsKey(penultimate)) 
		{
			
			SerialNumber = LicenceNumberMap.get(penultimate) + 1;	
			LicenceNumberMap.put(penultimate, SerialNumber);
			
		}
		else 
		{
			
			LicenceNumberMap.put(penultimate, 1);
			SerialNumber = 1;
			
		}
		
		return penultimate + Integer.toString(SerialNumber);

	}
	
	/**
	 * @return years licence held for
	 */
	public int getLicenceHeldFor() 
	{
		
		LocalDate issueDate = DateOfIssue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();//conversion to local date
		return Period.between(issueDate,LocalDate.now()).getYears();
		
	}

	/**
	 * @return date driving licence issued
	 */
	public String getDateOfIssue() 
	{
		
		Calendar c = Calendar.getInstance();
		c.setTime(DateOfIssue);
		return  c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH);

	}
 
	/**
	 * @return whether cars tank is full or not
	 */
	public boolean getIsFull() 
	{
		  
		return IsFull;
		    
	}

	/**
	 * @return licence number of vehicle
	 */
	public String getLicenceNumber() 
	{
		  
		return LicenceNumber; 
		    
	}

	/**
	 * @return initials of owner of driving licence
	 */
	public String getInitials() 
	{
		  
		return Initials;
		    
	}

	/**
	 * @return year licence issued
	 */
	public String getYearOfIssue() 
	{
		  
		return YearOfIssue;
		    
	}

	/**
	 * @return the serial number of licence
	 */
	public int getSerialNumber() 
	{
		  
		return SerialNumber;
		    
	}

	
}
