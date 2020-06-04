package Main;
/**
 * 
 *  This class represents a large car
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

public final class LargeCar extends AbstractCar {

	private static final int MAX_FUEL_CAPACITY = 60;
	private static final int UNDER_FIFTY_CONSUMPTION_RATE = 10;
	private final int OVER_FIFTY_CONSUMPTION_RATE = 15;
	
	public LargeCar() 
	{
		
		super(MAX_FUEL_CAPACITY, UNDER_FIFTY_CONSUMPTION_RATE);

	}

	/**
	 * @param distanceDriven
	 * @return amount of fuel consumed for a particular journey
	 */
	@Override
	public int drive(int distanceDriven) 
	{
		
		if(getIsRented() && getCurrentFuelLevel() > 0) 
		{

			int fuelConsumption = 0;
			
			if(distanceDriven <= 50) 
			{
				
				fuelConsumption = ((distanceDriven + (UNDER_FIFTY_CONSUMPTION_RATE - 1))/UNDER_FIFTY_CONSUMPTION_RATE);
				
			}
			else 
			{
					
				fuelConsumption = (((50 + (UNDER_FIFTY_CONSUMPTION_RATE - 1)) / UNDER_FIFTY_CONSUMPTION_RATE) + ((distanceDriven - 50 + (OVER_FIFTY_CONSUMPTION_RATE - 1))/OVER_FIFTY_CONSUMPTION_RATE));
				
			}
			
			setCurrentFuelLevel(getCurrentFuelLevel()-fuelConsumption); 
				
			return fuelConsumption;

		}
		
		return 0; //no journey has been taken
		
	}

	/**
	 * @return the fuel consumed per kilometre when the journey has reached over 50km
	 */
	public int getOverFiftyConsumptionRate()
	{
		
		return OVER_FIFTY_CONSUMPTION_RATE;
	}
	
	/**
	 * @return a string representation of current object
	 */
	public String toString() 
	{
		
		return super.toString() + " - " + getTypeOfCar()  + " - " + getOverFiftyConsumptionRate();
		
	}
	
	/**
	 * @return the type of vehicle
	 */
	@Override
	public String getTypeOfCar() 
	{

		return "large";
		
	}

	
	public static AbstractCar valueOf(String largeCar)
	{
		
		final String[] parts = largeCar.split(" - ");
		
		final int currentFuelLevel = Integer.parseInt(parts[2]);
		final boolean isRented = Boolean.valueOf(parts[3]);
		
		AbstractCar car = new LargeCar();
		car.setCurrentFuelLevel(currentFuelLevel);
		car.setIsRented(isRented);
		
		return car;
		
	}
	
}
