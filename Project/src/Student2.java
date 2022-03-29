import java.util.Comparator;

public class Student2 {
	private String name;
	private String surname;
	private int year;
	private int ID;
	private float number = 0;
	
	public Student2(String name, String surname, int ID, float number) {
		this.name = name;
		this.surname = surname;
		this.ID = ID;
		this.number = number;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static Comparator<Student2> numComp = new Comparator<Student2>() {
		public int compare(Student2 s1, Student2 s2)
		{
			float a = s1.getNumber();
			float b = s2.getNumber();
			return Float.compare(a, b);
			
		}};
	public String toString()
	{
	        return "ID: " +ID+ " " +name + " " + surname + ", průměr: " + number;
	}	
}
