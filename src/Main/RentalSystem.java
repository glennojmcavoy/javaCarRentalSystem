package Main;
/**
 * 
 *  This class acts as the rental system, controlling who can rent a car and under what conditions they are allowed to do so.
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RentalSystem 
{
	
	private List<AbstractCar> ListOfCarsAvailable = new LinkedList<AbstractCar>();//List of Cars Available
	private Map<Person,AbstractCar> ListOfRentedCars = new HashMap<Person,AbstractCar>();//Map of cars rented <(String) DrivingLicenceNumber --> AbstractCar>
	
	public RentalSystem() 
	{
		
		for (int i = 0; i < 10; i++) //create 10 large cars
		{
			
			AbstractCar largeCar = new LargeCar();
			ListOfCarsAvailable.add(largeCar);
			
		}
		
		for (int i = 0; i < 20; i++) //create 20 small cars
		{
			
			AbstractCar smallCar = new SmallCar();
			ListOfCarsAvailable.add(smallCar);
			
		}
		
	}
	
	public String toString()
	{
		
		return ListOfCarsAvailable.toString() + " - " + ListOfRentedCars.toString();
		
	}
	
	/**
	 * @param typeOfCar
	 * @return number of cars, of a certain type, available to rent
	 */
	public int getNumberOfAvailableCars(String typeOfCar)
	{
		
		int counter = 0;
		
		for(AbstractCar car : ListOfCarsAvailable) 
		{
			
			if(typeOfCar.equals(car.getTypeOfCar())) 
			{
				
				counter++;
				
			}
			
		}
		
		return counter;
		
	}
	
	/**
	 * @return collection of Abstract cars currently rented out.
	 */
	public Collection<AbstractCar> getRentedCars()
	{
	 
		return new ArrayList<AbstractCar>(ListOfRentedCars.values());
		
	}
	
	/**
	 * @param person
	 * @return an AbstractCar object which is being rented out by the specified person
	 */
	public AbstractCar getCar(Person person)
	{
		
		if(ListOfRentedCars.containsKey(person)) 
		{
			
			return ListOfRentedCars.get(person);
					
		}
		
		return null;
		
	}
	
	/**
	 * @param per
	 * @param dl
	 * @param typeOfCar
	 * @return whether a car was issued or not
	 */
	public boolean issueCar(Person per, DrivingLicence dl, String typeOfCar)
	{

		if(!dl.getIsFull()) 
		{
			return false;
		}
		
		if(typeOfCar.equals("small") && per.getAge() >= 20 && dl.getLicenceHeldFor() >= 1 
				&& !(ListOfRentedCars.containsKey(per))) 
		{
			
			boolean foundCar = false;
			
				for(AbstractCar car : ListOfCarsAvailable)
				{

					if(car.getTypeOfCar().equals("small")) 
					{
							
						ListOfCarsAvailable.remove(car);
						car.setIsRented(true);
						car.setCurrentFuelLevel(car.getFuelCapacity());
						ListOfRentedCars.put(per, car);
						foundCar = true;
						break;
							
					}
					
				}
				
				if(foundCar)
				{
					
					return true;
					
				}

				
		}
		else if(typeOfCar.equals("large") && per.getAge() >= 25 && dl.getLicenceHeldFor() >= 5 
				&& !(ListOfRentedCars.containsKey(per)))
		{
		
			boolean foundCar = false;
			
			for(AbstractCar car : ListOfCarsAvailable)
			{
				
				if(car.getTypeOfCar().equals("large")) 
				{
						
					ListOfCarsAvailable.remove(car);
					car.setIsRented(true);
					car.setCurrentFuelLevel(car.getFuelCapacity());
					ListOfRentedCars.put(per, car);
					foundCar = true;	
					break;
					
				}
					
			}
			
			if(foundCar)
			{
				
				return true;
				
			}
			
		}

		return false;
	
	}
	
	/**
	 * @param per
	 * @return numerical value of fuel required to fill the car
	 */
	public int terminateRental(Person per)
	{

		if(ListOfRentedCars.containsKey(per)) 
		{
			
			AbstractCar car = ListOfRentedCars.remove(per);
			car.setIsRented(false);
			ListOfCarsAvailable.add(car);
			
			return car.getFuelCapacity() - car.getCurrentFuelLevel();
			
		}

		
		return 0;
		
	}
	
}
