package tests;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import Main.DrivingLicence;
import Main.Name;

public class TestDrivingLicence {

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
				
		assertEquals(dl.toString(), "19 - true - GM-2000-1 - 2000/2/17");
		assertEquals(dl.getIsFull() == true, true);
		assertEquals(dl.getInitials().equals("GM"), true);
		assertEquals(dl.getLicenceHeldFor() == 19, true);
		assertEquals(dl.getDateOfIssue().equals("2000/2/17"), true);
		assertEquals(dl.getLicenceNumber().equals("GM-2000-1"), true);
		assertEquals(dl.getSerialNumber() == 1, true);
		assertEquals(dl.getYearOfIssue().equals("2000"), true);
		
		assertEquals(dl.generateLicenceNumber(name, doi).equals(dl.getLicenceNumber()), false);//Does not produce same licence number for objects with the same details
		
	}

}
