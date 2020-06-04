package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Main.Name;

public class TestName {

	@Test
	public void test() {
		
		Name name = new Name("Glenn","McAvoy");
		Name name2 = new Name("Ben", "McAvoy");
		Name name3 = new Name("Ben", "McAvoy");
		
		assertEquals(name.getFirstname(),"Glenn");
		assertEquals(name.getSurname(),"McAvoy");
		assertEquals(name2.toString(), "Ben - McAvoy");
		assertEquals(name2.equals(name3), true);
		
		Name name4 = Name.valueOf(name.toString());

		assertEquals(name4.equals(name), true);
		
	}

}
