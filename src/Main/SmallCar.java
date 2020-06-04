package Main;
/**
 * 
 *  This class represents a small car
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

public final class SmallCar extends AbstractCar {

	private static final int MAX_FUEL_CAPACITY = 49;
	private static final int CONSUMPTION_RATE = 20;
	
	public SmallCar() 
	{
		
		super(MAX_FUEL_CAPACITY, CONSUMPTION_RATE);

	}
	
	/**
	 * @param distanceDriven
	 * @return amount of fuel consumed for a particular journey
	 */
	@Override
	public int drive(int distanceDriven) 
	{
		
		if(getIsRented() && getCurrentFuelLevel() > 0) //must be rented to be driven
		{

			int fuelConsumption = ((distanceDriven + (CONSUMPTION_RATE - 1))/CONSUMPTION_RATE);
			
			setCurrentFuelLevel(getCurrentFuelLevel() - fuelConsumption); 
				
			return fuelConsumption;

		}
				
		return 0;
		
	}

	/**
	 * @return a string representation of current object
	 */
	@Override
	public String toString()
	{
		
		return super.toString() + " - " + getTypeOfCar();
		
	}
	
	/**
	 * @return the type of vehicle
	 */
	@Override
	public String getTypeOfCar() {

		return "small";
		
	}
	
	/**
	 * 
	 * @param smallCar
	 * @return a small car object
	 */
	public static AbstractCar valueOf(String smallCar)
	{
		
		final String[] parts = smallCar.split(" - ");
		
		//final String name = parts[0].equals("null") ? null : parts[0];
		
		final int currentFuelLevel = Integer.parseInt(parts[2]);
		final boolean isRented = Boolean.valueOf(parts[3]);
		
		AbstractCar car = new SmallCar();
		car.setCurrentFuelLevel(currentFuelLevel);
		car.setIsRented(isRented);
		
		return car;
		
	}
	
}
