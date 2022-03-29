
//package default;
import java.util.ArrayList;
import java.util.Set;

public class Student extends Osoba {
	private int sum;
	private final float AVERAGE = (float) 1.5; //nastavení průměru na stipendium
	private final int CASH = 1000;	//nastavení výše stipendia
	private float mean = 0;
	private boolean stip = false;
	private static int numberstip=0;
	ArrayList<Integer> marks;
	ArrayList<Integer> teacherlist;
	private static int newID = 1000; //nastavení počátečního ID
	
	public Student(String name, String surname, int year) {
		super(name, surname, year);
		// TODO Auto-generated constructor stub
		this.ID = newID++;
		this.marks = new ArrayList<Integer>();
		this.teacherlist = new ArrayList<Integer>();
	}
	
	public int getID() {
		return this.ID;
	}
	
	@Override
	public String getSalute()
	{
		return "Student";
	}
	@Override
	public void add(int Mark) 
	{
		if(1<= Mark && Mark <= 5)
		{
			this.marks.add(Mark);
		}
		else
		{
			System.err.println("Rozsah známek je 1-5.");
		}
		
		int sum = 0;
		for(float addMark : this.marks)
			sum += addMark;
		this.mean = sum/(float)this.marks.size();
		
		if(this.mean <=(float) AVERAGE)
		{
			this.stip = true;
		} 
		else
		{
			this.stip = false;
		}
		if(this.marks.isEmpty())
		{

		}
	}
	
	public boolean getStip()
	{
		return this.stip;
	}
		
	//@Override
	public void addUcitel(int Ucitel) 
	{
		if(this.teacherlist.contains(Ucitel)) 	//zamezení, aby v seznamu byl student 2x
		{
			
		}
		else
		{
			this.teacherlist.add(Ucitel);
		}
	}
	
	@Override
	public void remove(int Stud)		//a.remove(Integer.valueOf(10));
	{
		if(this.teacherlist.contains(Stud))
		{
			this.teacherlist.remove(Integer.valueOf(Stud));
		}	
		else
		{
		
		}
	}
	
	@Override
	public String getMean()
	{
		if(this.marks.isEmpty())
		{
			return "";
		}
		else
		{
		return ", průměr: "+this.mean;
		}
	}
	
	public float getMeanValue()
	{
		return this.mean;
	}
	
	@Override
	public float getCash()
	{
		if(this.stip)
		{			
			return CASH;
		}
		return 0;			
	}
	
	@Override
	public void print() 
	{
		// TODO Auto-generated method stub
		for(int i=0;i<this.teacherlist.size();i++)
		{
	    	System.out.println(this.teacherlist.get(i));
	    	
		} 
	}
	
	public int getListSize()
	{
		return this.teacherlist.size();
	}
	
	@Override
	public void addData(int ID)
	{
	
	}

	@Override
	void printData() {
	}

	@Override
	public ArrayList<Integer> getList() {
		// TODO Auto-generated method stub
		return this.teacherlist;
	}

	@Override
	void numberstip() {
		// TODO Auto-generated method stub
	}
}

