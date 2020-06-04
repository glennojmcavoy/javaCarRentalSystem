package tests;
/**
 * 
 * This is the class where I did some testing.
 * 
	@author b6006281
	@version 1.0 24/10/2019
*/

import java.util.Calendar;
import java.util.Date;

import Main.AbstractCar;
import Main.DrivingLicence;
import Main.LargeCar;
import Main.Name;
import Main.Person;
import Main.RentalSystem;
import Main.SmallCar;

public class GenericPrintStatementTest {

	public static void main(String[] args) {
		
		//Add extra comments for things that aren't immediately obvious what they do
		//Provide j-unit tests and UML diagrams
		//check spec
		// ensure immutable
		// provide valueOf methods
		//if overriden equals check hc is as well.
		
		RentalSystem rent = new RentalSystem();
		
		Name name = new Name("Glenn","McAvoy");
		Name name1 = new Name("lenn","McAvoy");
		Name name2 = new Name("enn","McAvoy");
		Name name3 = new Name("nn","McAvoy");
		Name name4 = new Name("n","McAvoy");
		Name name5 = new Name("Glen","McAvoy");
		Name name6 = new Name("dob","McAvoy");
		Name name7 = new Name("ppp","McAvoy");
		Name name8 = new Name("ccc","McAvoy");
		Name name9 = new Name("lll","McAvoy");
		Name name10 = new Name("hhh","McAvoy");
		Name sameAsName = new Name("Glenn","McAvoy");
		

		Calendar calDOB = Calendar.getInstance();
		calDOB.clear();
		calDOB.set(1992, 02, 17);
		Date dob = calDOB.getTime();
		
		Calendar cDOI = Calendar.getInstance();
		cDOI.clear();
		cDOI.set(2000, 02, 17);
		Date doi = cDOI.getTime();
		
		
		DrivingLicence dl = new DrivingLicence(doi, true, name);
		DrivingLicence dl1 = new DrivingLicence(doi, true, name1);
		DrivingLicence dl2 = new DrivingLicence(doi, true, name2);
		DrivingLicence dl3 = new DrivingLicence(doi, true, name3);
		DrivingLicence dl4 = new DrivingLicence(doi, true, name4);
		DrivingLicence dl5 = new DrivingLicence(doi, true, name5);
		DrivingLicence dl6 = new DrivingLicence(doi, true, name6);
		DrivingLicence dl7 = new DrivingLicence(doi, true, name7);
		DrivingLicence dl8 = new DrivingLicence(doi, true, name8);
		DrivingLicence dl9 = new DrivingLicence(doi, true, name9);
		DrivingLicence dl10 = new DrivingLicence(doi, true, name10);
		DrivingLicence dl11 = new DrivingLicence(doi, true, new Name("Harley","McGlynn"));
		
		Person per = new Person(name, dob, dl);
		Person per1 = new Person(name1, dob, dl1);
		Person per2 = new Person(name2, dob, dl2);
		Person per3 = new Person(name3, dob, dl3);
		Person per4 = new Person(name4, dob, dl4);
		Person per5 = new Person(name5, dob, dl5);
		Person per6 = new Person(name6, dob, dl6);
		Person per7 = new Person(name7, dob, dl7);
		Person per8 = new Person(name8, dob, dl8);
		Person per9 = new Person(name9, dob, dl9);
		Person per10 = new Person(name10, dob, dl9);
		Person sameAsPer9 = new Person(name9, dob, dl9);
		Person per11 = new Person(new Name("Harley","McGlynn"),dob, dl11);
		
		System.out.println("TESTS");
		System.out.println("#### getNumberOfAvailableCars(typeOfCar) ####");
		System.out.println();
		System.out.println("Number of large cars available: " + rent.getNumberOfAvailableCars("large"));
		System.out.println("Number of small cars available: " + rent.getNumberOfAvailableCars("small"));
		System.out.println("\n");
		
		System.out.println("#### Big car method tests ####");
		System.out.println();
		System.out.println("Test issue: " + rent.issueCar(per, dl, "large"));
		System.out.println("Test getTypeOfCar: " + rent.getCar(per).getTypeOfCar());
		System.out.println("Test drive: Fuel used for journey: " + rent.getCar(per).drive(875));
		System.out.println("Test drive: Fuel used for journey: " + rent.getCar(per).drive(1));
		System.out.println("Test drive: Fuel used for journey: " + rent.getCar(per).drive(0));
		System.out.println("Test toString(): " + rent.getCar(per));
		System.out.println("Test valueOf(): " + LargeCar.valueOf(rent.getCar(per).toString()));
		System.out.println("Test terminate " + rent.terminateRental(per));
		System.out.println();
		
		System.out.println("#### Small car method tests ####");
		System.out.println();
		System.out.println("Test issue: " + rent.issueCar(per, dl, "small"));
		System.out.println("Test drive: Fuel used for journey: " + rent.getCar(per).drive(980));
		System.out.println("Test drive: Fuel used for journey: " + rent.getCar(per).drive(1));
		System.out.println("Test drive: Fuel used for journey: " + rent.getCar(per).drive(0));
		System.out.println("toString(): " + rent.getCar(per));
		System.out.println("valueOf(): " + SmallCar.valueOf(rent.getCar(per).toString()));
		System.out.println("Test terminate(person): " + rent.terminateRental(per));
		System.out.println();
		
		System.out.println("#### issueCar(person, drivingLicence, typeOfCar) method ####");//allows up to 10 large cars then stops
		System.out.println();
		rent.issueCar(per, dl, "large");
		rent.issueCar(per1, dl1, "large");
		rent.issueCar(per2, dl2, "large");
		rent.issueCar(per3, dl3, "large");
		rent.issueCar(per4, dl4, "large");
		rent.issueCar(per5, dl5, "large");
		rent.issueCar(per6, dl6, "large");
		rent.issueCar(per7, dl7, "large");
		rent.issueCar(per8, dl8, "large");
		System.out.println("Car issued: " + rent.issueCar(per9, dl9, "large"));
		System.out.println("Car issued: " + rent.issueCar(per10, dl10, "large"));
		System.out.println(rent.issueCar(per11, dl11, "small"));
		System.out.println();
		
		System.out.println("#### Test getRentedCars() ####");
		System.out.println();
		for(AbstractCar car : rent.getRentedCars())
		{
			
			System.out.println(car);
			
		}
		System.out.println();
		
		System.out.println("#### Test getting registration components ####");
		System.out.println();
		System.out.println("Reg No: " + rent.getCar(per9).getRegNumber());
		System.out.println("First reg component: " + rent.getCar(per9).getFirstRegComponent());
		System.out.println("Second reg component: " +rent.getCar(per9).getSecondRegComponent());
		System.out.println();
		
		System.out.println("#### Test Person methods ####");
		System.out.println();
		System.out.println(per.toString());
		System.out.println("Test equals - same name: " + per9.equals(sameAsPer9));
		System.out.println("per9 hashcode: " + per9.hashCode() + ", comparator hashcode: " + sameAsPer9.hashCode());
		System.out.println();
		System.out.println("Test equals - different name: " + per10.equals(per9)); 
		System.out.println("per10 hashcode: " + per10.hashCode() + ", comparator hashcode " + per9.hashCode());
		System.out.println();
		
		System.out.println("#### Test Name methods ####");
		System.out.println();
		System.out.println("Test equals, same name: " + name.equals(sameAsName)); 
		System.out.println("Name hashcode: " + name.hashCode() + " comparator: " + sameAsName.hashCode());
		System.out.println();
		System.out.println("Test equals, different name: " + name.equals(name1));
		System.out.println("Name hashcode: " + name.hashCode() + " comparator: " + name1.hashCode());
		System.out.println(name);
		System.out.println();
		
		System.out.println("#### Test Driving Licence ####");
		System.out.println();
		System.out.println(dl.toString());
		for (int i = 0; i < 10; i++) 
		{
			DrivingLicence testDL = new DrivingLicence(doi, true, name);
			System.out.println(testDL.getLicenceNumber());
			
		}
		System.out.println();
		
		System.out.println(rent.toString());
		
		
	}

}
