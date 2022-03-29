import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;


public class Ucitel extends Osoba{
	
	ArrayList<Integer> list;
	private static int newID1 = 1; //nastavení počátečního ID
	private final int PRICE = 1000;	//výše odměny za jednoho studenta
	private final int PRICESTIP = 2000;
	private final float NETSALARY = (float) 0.85;
	//private static int number = 0;
	private static int numberstip = 0;
	private static int a = 0;
	private static int cash = 0;
	
	public Ucitel(String name, String surname, int year) {
		super(name, surname, year);
		this.ID = newID1++;
		this.list = new ArrayList<Integer>();
	}

	@Override
	public String getSalute()
	{
		return "Učitel";
	}
		
	@Override
	public float getCash()
	{
		if(this.list.isEmpty())
		{
			return 0;
		}
		else
		{
		return this.cash = this.list.size()*PRICE+numberstip*PRICESTIP;		//výše odměny
		
		}
	}
	
	@Override
	public void add(int Student) 
	{
		if(this.list.contains(Student)) 	//zamezení, aby v seznamu byl student 2x
		{
			
		}
		else
		{
		this.list.add(Student);
		}
	}
	
	@Override
	public void remove(int Stud)
	{
		if(this.list.contains(Stud))
		{
			this.list.remove(Integer.valueOf(Stud));
		}	
		else
		{
		
		}
	}
	
	@Override
	public void print()
	{	
		for(int i=0;i<this.list.size();i++)
		{
	    	System.out.println(this.list.get(i));
		} 
	}
	
	public ArrayList<Integer> getList()
	{
		return this.list;
	}
	
	public int getListSize()
	{
		return this.list.size();
	}

	void numberstip()
	{
		this.numberstip++;
	}
	
	@Override
	public String getMean()
	{
		return "";
	}

	@Override
	boolean getStip() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void printData() {
		// TODO Auto-generated method stub
	}

	@Override
	void addUcitel(int id4) {
		// TODO Auto-generated method stub
	}

	@Override
	float getMeanValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void addData(int ID) {
		// TODO Auto-generated method stub
		
	}
}

