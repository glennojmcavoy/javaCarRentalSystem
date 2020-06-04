package Main;
/**
 * 
 *  This is an interface contract for a car
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

public interface Car {

	/**
	 * @return the registration number of the car
	 */
	public String getRegNumber(); 
	
	/**
	 * @return the number of litres of fuel the car can hold
	 */
	public int getFuelCapacity();
	
	/**
	 * @return the number of litres of fuel currently being held by the car
	 */
	public int getCurrentFuelLevel();
	
	/**
	 * @return a boolean value of whether the fuel tank is full or not
	 */
	public boolean isFuelTankFull();
	
	/**
	 * @param amount
	 * @return a the number of litres of fuel added to the car
	 */
	public int addFuel(int amount); 
	
	/**
	 * @param distanceDriven
	 * @return the number of litres of fuel consumed on the journey
	 */
	public int drive(int distanceDriven);
	
	/**
	 * @return a boolean value of whether car is rented or not
	 */
	public boolean getIsRented();
	
	/**
	 * @return type of car
	 */
	public String getTypeOfCar();
	
	
}
