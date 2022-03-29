import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	private Osoba stud;
	@Test
	public void test1()
	{
		stud = new Student("Jan", "Novak", 1995);	//vytvoření nového objektu třídy Student
		assertEquals(1995,stud.getYear());	//vyzkoušení, jestli se shoduje 1995 s getYear()
	}
	@Test
	public void test2()
	{
		stud = new Student("Jan", "Novak", 1995);
		assertEquals("Novak",stud.getSurname());
	}
	@Test
	public void test3()
	{
		stud = new Student("Jan", "Novak", 1995);
		assertEquals("Jan",stud.getName());
	}
	
}
