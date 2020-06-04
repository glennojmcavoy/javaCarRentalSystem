package tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import Main.AbstractCar;
import Main.DrivingLicence;
import Main.LargeCar;
import Main.Name;
import Main.Person;
import Main.RentalSystem;
import Main.SmallCar;

public class TestRentalSystem {

	@Test
	public void test() {


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
		
		assertEquals(rent.getNumberOfAvailableCars("small") == 20, true);
		assertEquals(rent.getNumberOfAvailableCars("large") == 10, true);
		assertEquals(rent.issueCar(per, dl, "large"), true);
		assertEquals(rent.getCar(per).getTypeOfCar().equals("large"),true);
		assertEquals(rent.getCar(per).drive(875) == 60, true);
		assertEquals(rent.getCar(per).drive(875) == 0, true);
		assertEquals(rent.getCar(per).drive(875) == 0, true);
		assertEquals(rent.getCar(per).equals(rent.getCar(per)), true);
		assertEquals(LargeCar.valueOf(rent.getCar(per).toString()).equals(rent.getCar(per)), false);
		assertEquals(rent.terminateRental(per) == 60, true);
									
		assertEquals(rent.issueCar(per, dl, "small"), true);
		assertEquals(rent.getCar(per).drive(980) == 49, true);
		assertEquals(rent.getCar(per).drive(1) == 0, true);
		assertEquals(rent.getCar(per).drive(0) == 0, true);
		assertEquals(rent.getCar(per).equals(rent.getCar(per)), true);
		assertEquals(SmallCar.valueOf(rent.getCar(per).toString()).equals(rent.getCar(per)),false);
		assertEquals(rent.terminateRental(per) == 49, true);
		
		rent.issueCar(per, dl, "large");
		rent.issueCar(per1, dl1, "large");
		rent.issueCar(per2, dl2, "large");
		rent.issueCar(per3, dl3, "large");
		rent.issueCar(per4, dl4, "large");
		rent.issueCar(per5, dl5, "large");
		rent.issueCar(per6, dl6, "large");
		rent.issueCar(per7, dl7, "large");
		rent.issueCar(per8, dl8, "large");
		rent.issueCar(per9, dl9, "large");
		rent.issueCar(per10, dl10, "large");
		
		assertEquals(rent.issueCar(per10, dl10, "large") == false, true); //cannot rent more cars then there are
		rent.issueCar(per11, dl11, "small");

		assertEquals(rent.getRentedCars().size() == 11, true);

		
	}

}
