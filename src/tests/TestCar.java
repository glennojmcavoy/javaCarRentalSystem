package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Main.AbstractCar;
import Main.LargeCar;
import Main.SmallCar;

public class TestCar {

	@Test
	public void test() {
		
		AbstractCar largeTest = new LargeCar();
		
		AbstractCar smallTest = new SmallCar();
		
		largeTest.setCurrentFuelLevel(50);
		smallTest.setCurrentFuelLevel(48);
		assertEquals(largeTest.getCurrentFuelLevel() == 50,true);
		assertEquals(smallTest.getCurrentFuelLevel() == 48,true);
		assertEquals(largeTest.addFuel(10) == 10,true);
		assertEquals(smallTest.addFuel(6) == 1,true);
		assertEquals(largeTest.getFuelCapacity() == 60,true);
		assertEquals(smallTest.getFuelCapacity() == 49,true);
		assertEquals(largeTest.isFuelTankFull() == true, true);
		assertEquals(smallTest.isFuelTankFull() == true, true);
		assertEquals(((LargeCar) largeTest).getOverFiftyConsumptionRate() == 15, true);
		assertEquals((largeTest).getConsumptionRate() == 10, true);
		assertEquals(smallTest.getConsumptionRate() == 20, true);
		assertEquals(smallTest.getTypeOfCar() == "small", true);
		assertEquals(largeTest.getTypeOfCar() == "large", true);
		
	}

}
