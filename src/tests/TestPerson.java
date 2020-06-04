package tests;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import Main.DrivingLicence;
import Main.Name;
import Main.Person;

public class TestPerson {

	@Test
	public void test() {

		Name name = new Name("Glenn","McAvoy");
		
		Calendar calDOB = Calendar.getInstance();
		calDOB.clear();
		calDOB.set(1992, 02, 17);
		Date dob = calDOB.getTime();
		
		Calendar cDOI = Calendar.getInstance();
		cDOI.clear();
		cDOI.set(2000, 02, 17);
		Date doi = cDOI.getTime();
		
		DrivingLicence dl = new DrivingLicence(doi, true, name);
		
		Person per = new Person(name, dob, dl);

		assertEquals(per.getAge(), 27);
		assertEquals(per.getDOB(), "1992/2/17");
		assertEquals(per.getDrivingLicence(), dl);
		assertEquals(per.getName(), name);
		assertEquals(per, per);
		assertEquals(per.hashCode(), per.hashCode());
		assertEquals(per.toString(), "Glenn - McAvoy - 1992/2/17 - 27 - 19 - true - GM-2000-1 - 17/2/2000");
		
	}

}
