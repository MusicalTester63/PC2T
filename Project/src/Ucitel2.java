import java.util.Comparator;


public class Ucitel2 {
	private String name;
	private String surname;
	private int year;
	private int ID;
	private int number = 0;
	
	public Ucitel2(String name, String surname, int ID, int number) {
		this.name = name;
		this.surname = surname;
		this.ID = ID;
		this.number = number;
		// TODO Auto-generated constructor stub
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getSurname() 
	{
		return surname;
	}

	public void setSurname(String surname) 
	{
		this.surname = surname;
	}

	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		this.year = year;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}

	public int getNumber() 
	{
		return number;
	}

	public void setNumber(int number) 
	{
		this.number = number;
	}
	
	public static Comparator<Ucitel2> numComp = new Comparator<Ucitel2>() 
	{
		public int compare(Ucitel2 s1, Ucitel2 s2)
		{
			int a = s1.getNumber();
			int b = s2.getNumber();
			return a-b;
	
		}};
	public String toString() 
	{
	        return  name + " " + surname + " ID: "+ID+ ", počet studentů: " + number;
	}	
}
	
	

