import java.util.ArrayList;

public abstract class Osoba {
	private String name;
	private String surname;
	private int year;
	protected int ID = 1;
	private int newID = 1;
	
	public Osoba(String name, String surname, int year)
	{
		this.name = name;
		this.surname = surname;
		this.year = year;
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
		return this.ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	abstract boolean getStip();
	public abstract float getCash();
	public abstract int getListSize();
	public abstract String getSalute();
	public abstract String getMean();
	abstract void add(int Mark);
	abstract void remove(int Stud);
	abstract void print();
	abstract void addData(int ID);
	abstract void printData();
	abstract void addUcitel(int id4);
	protected abstract ArrayList<Integer> getList();
	abstract float getMeanValue();
	abstract void numberstip();
	
}

	
	
	
		
	


