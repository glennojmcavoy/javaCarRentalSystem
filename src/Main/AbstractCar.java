package Main;
/**
 * 
 *  Implements all the common behaviour of small and large cars.
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractCar implements Car {

	private String RegNumber;
	private final int CONSUMPTION_RATE;
	private final int MAX_FUEL_CAPACITY;
	private int CurrentFuelLevel;
	private boolean IsRented = false;
	private String FirstRegComponent;
	private String SecondRegComponent;
	private Set<String> RegNoSet = new HashSet<String>(); //Stores registration numbers
	
	/**
	 * @param maxFuelCapacity
	 * @param consumptionRate
	 */
	public AbstractCar(int maxFuelCapacity, int consumptionRate) 
	{
		
		createRegNo();
		this.MAX_FUEL_CAPACITY = maxFuelCapacity;
		this.CurrentFuelLevel = MAX_FUEL_CAPACITY;
		this.CONSUMPTION_RATE = consumptionRate;
		
	}

	/**
	 * @return string representation of the object
	 */
	public String toString() 
	{
		
		return getRegNumber() + " - " + getFuelCapacity() + " - "
		+ getCurrentFuelLevel() + " - " + getIsRented() + " - " + getConsumptionRate();
		
	}
	
	/**
	 * @return number of litres consumed per kilometre driven
	 */
	public int getConsumptionRate() 
	{
		
		return CONSUMPTION_RATE;
		
	}
	
	/**
	 * @return the registration number of the vehicle
	 */
	public String getRegNumber() 
	{
		
		return RegNumber;
		
	}
	
	/**
	 * @return if care is rented or not
	 */
	public boolean getIsRented() 
	{
		
		return IsRented;
		
	}
	
	/**
	 * @param isrented
	 */
	public void setIsRented(boolean isrented) 
	{
		
		this.IsRented = isrented;
		
	}
	
	/**
	 * @return vehicle fuel capacity
	 */
	public int getFuelCapacity() 
	{
		
		return MAX_FUEL_CAPACITY;
		
	}
	
	/**
	 * @return current fuel level
	 */
	public int getCurrentFuelLevel() 
	{
		
		return CurrentFuelLevel;
		
	}
	
	/**
	 * @param newFuelLevel
	 */
	public void setCurrentFuelLevel(int newFuelLevel) 
	{
		
		 this.CurrentFuelLevel = newFuelLevel;
		
	}
	
	/**
	 * @return if fuel tank full or not
	 */
	public boolean isFuelTankFull() 
	{
		
		return ((MAX_FUEL_CAPACITY == CurrentFuelLevel) ? true : false);
				
	}
	
	/**
	 * @return number of litres of fuel added
	 */
	public int addFuel(int amountToAdd) //returns amount of fuel added
	{
		
		int difference = MAX_FUEL_CAPACITY - CurrentFuelLevel;
		
		if(amountToAdd >= difference) 
		{
			
			CurrentFuelLevel = MAX_FUEL_CAPACITY;
			
			return difference;
			
		}
		else 
		{
		
			CurrentFuelLevel += amountToAdd;
			
			return amountToAdd;
			
		}
		
	} 
		
	/**
	 * Creates a unique registration number
	 */
	private void createRegNo() 
	{
		
		String concat = "";
		
		do 
		{
			
		FirstRegComponent = createCharacter() + createCharacter() + createInteger() + createInteger();
		SecondRegComponent = createCharacter() + createCharacter() + createCharacter();
		
		concat = FirstRegComponent + " " + SecondRegComponent;
		
		}
		while(RegNoSet.contains(concat));
		
		
		RegNumber = concat;
		
	}
	
	/**
	 * @return a character from range A-Z
	 */
	private String createCharacter() 
	{
		
		return Character.toString((char)ThreadLocalRandom.current().nextInt(65, 90 + 1));
		
	}
	
	/**
	 * @return string representation of a int 0 - 9
	 */
	private String createInteger() 
	{
		
		return Character.toString((char)ThreadLocalRandom.current().nextInt(48, 57 + 1));
		
	}

	/**
	 * @return first part of regNo
	 */
	public String getFirstRegComponent() 
	{
		
		return FirstRegComponent;
		
	}
	
	/**
	 * @return second part of regNo
	 */
	public String getSecondRegComponent() 
	{
		
		return SecondRegComponent;
		
	}
	
}
