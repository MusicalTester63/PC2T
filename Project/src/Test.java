import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//import cz.vutbr.feec.dbconnection.dbconn.DBConnection;

public class Test {

	static Connection con = null;
	static String sql = null;
	static Statement stmnt;
	static PreparedStatement pstmnt = null;
	static ResultSet rs = null;		
	static Osoba info = null;
	static int id = 0;
	static int cash = 0;
	static int cash1 = 0;
	static final float GROSSSALARY = (float) 1.2;
	static String login = null;
	static String password = null;
	
	public static boolean connect() { 
	      con = null;
	      login="";
	      password="";
	      sql="jdbc:sqlite:myDB.db";
	      try 
	      {   
	    	  Scanner sc = new Scanner(new File("login.txt"));
	    	  while(sc.hasNext())
	    	  {
	    		  login = sc.next();
	    		  password = sc.next();
	    	  }
	    	  con = DriverManager.getConnection(sql, login, password);
	    	  sc.close();
	      } 
	      catch (SQLException e) 
	      { 
	            System.out.println(e.getMessage());
	            return false;
	      }
	      catch (Exception e) 
	      {
				e.printStackTrace();
				return false;
	      }
		  return true;
	}

	public static void disconnect() {
		if (con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	// vytvoreni tabulky
	public static Boolean createTable() {
		if (con == null)
			return false;

		String sql = "CREATE TABLE IF NOT EXISTS data (" + "id int PRIMARY KEY, " + "salute varchar(20), " + "name varchar(20), " + "surname varchar(20), " + "year int"+");";
		try 
		{
			Statement stmnt = con.createStatement();
			stmnt.execute(sql);
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name = null;
		String surname = null;
		boolean ok = true;
		int newID = 1000; //musí být nastaveno stejně i v Student, jenom pro Student
		int newID1 = 1; //musí být nastaveno stejně i u Ucitel, jenom pro Ucitel
		int year;
		TreeMap<Integer, Osoba> databaze = new TreeMap<Integer, Osoba>();
		
		//v databazi osoby pro testovaci učely
		databaze.put(newID++, new Student("Jan", "Novak", 1995));
		databaze.put(newID++, new Student("Pavel", "Grulich", 1960));
		databaze.put(newID++, new Student("Halo", "Grul", 1960));
		databaze.put(newID++, new Student("Pablo", "Picaso", 1960));
		databaze.put(newID1++, new Ucitel("Karel", "Nečas", 1956));
		databaze.put(newID1++, new Ucitel("Pavel", "Hála", 1965));
		databaze.put(newID1++, new Ucitel("Palo", "H", 1965));
		databaze.put(newID1++, new Ucitel("Pako", "Halo", 1965));
		databaze.put(newID1++, new Ucitel("Alik", "Haf", 1965));
		
		while(ok)
		{
			System.out.println("\n"+"Vítejte, vyberte z následujících možností");
			System.out.println("1. Přidat osobu");
			System.out.println("2. Odebrat osobu");
			System.out.println("3. Výpis informací o osobě");
			System.out.println("4. Výpis databáze osob");
			System.out.println("5. Přidat známku studentovi");
			System.out.println("6. Přiřadit studenta k vyučujícímu");
			System.out.println("7. Odebrání studenta vyučujícímu");
			System.out.println("8. Studenti náležící k vyučujícímu");
			System.out.println("9. Vyučující náležící ke studentovi");
			System.out.println("10. Pro vybraného učitele výpis všech jeho studentů řazený dle studijního průměru.");
			System.out.println("11. Výpis všech učitelů řazených podle aktuálního počtu studentů.");
			System.out.println("12. Finanční prostředky");
			System.out.println("13. Připojení k SQL databázi");
			System.out.println("14. Načtení všech údajů z SQL databáze");
			System.out.println("15. Uložení všech údajů do SQL databáze");
			System.out.println("16. Vymazání vybrané osoby ze SQL databáze");
			System.out.println("17. Načtení vybrané osoby ze SQL databáze");
		
			int choise = Check.pouzeCelaCisla(sc);
			switch(choise)
			{
			case 1:
				System.out.println("Chcete přidat učitele nebo studenta?");
				System.out.println("1. student");
				System.out.println("2. učitel");
				
				int choise2 = Check.pouzeCelaCisla(sc);
				if(choise2 == 1)
				{
					System.out.println("Zadejte jméno studenta:");
					name = sc.next();
					System.out.println("Zadejte přijmení studenta");
					surname = sc.next();
					System.out.println("Zadejte rok narození:");
					year = Check.pouzeCelaCisla(sc);
					databaze.put(newID++, new Student(name, surname, year));
				}
				if(choise2 == 2)
				{
					System.out.println("Zadejte jméno učitele:");
					name = sc.next();
					System.out.println("Zadejte přijmení učitele");
					surname = sc.next();
					System.out.println("Zadejte rok narození:");
					year = Check.pouzeCelaCisla(sc);
					//databaze.put(newID++, new Ucitel(name, surname, year));
					databaze.put(newID1++, new Ucitel(name, surname, year));
				}
				break;
			case 2:
				System.out.println("Zadej ID osoby k odebrání");
				id = Check.pouzeCelaCisla(sc);
				//Osoba infom = (Osoba)databaze.get(id1);
				if(databaze.containsKey(id))
				{
					databaze.remove(id);	
				}
				else
				{
					System.err.println("Osoba s ID "+id+" není v databázi.");
				}
				break;
			case 3:
				System.out.println("Zadej ID osoby k vypisu informaci");		//implementace konstaincky
				id = Check.pouzeCelaCisla(sc);
				
				if(databaze.containsKey(id))
				{
					info = (Osoba)databaze.get(id);
					if(info instanceof Student) //funguje
					{
						System.out.println(info.getSalute()+", "+info.getName()+" "+info.getSurname()+", rok narozeni: "+info.getYear()+ ", odměna: "+(int)info.getCash()+" Kč"+info.getMean());
					}
					else
					{
						System.out.println(info.getSalute()+", "+ info.getName() + " " + info.getSurname() + ", rok narozeni: "+info.getYear()+", výše odměny: "+(int)info.getCash()+" Kč");
					}
				}
				else
				{
					System.err.println("Osoba s ID "+id+" není v databázi.");
				}
				break;
			
			case 4:
				if(databaze.isEmpty())
				{
					System.out.println("V databázi není žádná osoba.");
				}
				else 
				{	
					System.out.println("V databázi jsou tyto osoby:");
					Set<Integer> klice=databaze.keySet();
					for (Integer klic:klice)
						//if(klice instanceof Student)
					{
						System.out.println(databaze.get(klic).getSalute()+", "+databaze.get(klic).getName()+" "+databaze.get(klic).getSurname()+", rok narození: "+databaze.get(klic).getYear()+", ID: "+databaze.get(klic).getID()+", odměna: "+(int)databaze.get(klic).getCash()+" Kč"+databaze.get(klic).getMean()); //vypíše všechny z databáze
					}
				}
				break;
				
			case 5:
				System.out.println("Zadej ID studenta a známku k přidání");
				id = Check.pouzeCelaCisla(sc);
				int mark = Check.pouzeCelaCisla(sc);
				if(databaze.containsKey(id))
				{
					info = databaze.get(id);
					info.add(mark);
				}
				else
				{
					System.err.println("Student s ID "+id+" není v databázi.");
				}
				break;
				
			case 6:
				System.out.println("Přiřazení studenta k učitelovi");
				System.out.println("Zadej ID studenta a ID učitele");
				int id3 = Check.pouzeCelaCisla(sc);
				int id4 = Check.pouzeCelaCisla(sc);
				if((databaze.containsKey(id3))&&databaze.containsKey(id4))
				{
					//do databáze k učiteli 
					Osoba info3 = databaze.get(id4);
					info3.add(id3);
					
					//do databáze ke studentovi
					Osoba info5 = databaze.get(id3);
					info5.addUcitel(id4);
					//stipendium
					if(info5.getStip())
					{
						info3.numberstip();
					}
				}
				else
				{
					System.err.println("Osoba není v databázi.");
				}
				break;
			
			case 7:
				System.out.println("Odebrání studenta vyučujícímu");
				System.out.println("Zadej ID studenta a ID vyučujícího");
				int id8 = Check.pouzeCelaCisla(sc);
				int id9 = Check.pouzeCelaCisla(sc);
				
				if((databaze.containsKey(id8))&&databaze.containsKey(id9))
				{
					//u ucitele
					Osoba info7 = databaze.get(id9);
					info7.remove(id8);
					//u studenta
					Osoba info8 = databaze.get(id8);
					info8.remove(id9);
				}
				else
				{
					System.err.println("Osoba není v databázi.");
				}
				break;
							
			case 8:
				System.out.println("Studenti náležící k učiteli");
				System.out.println("Zadejte ID učitele");
				id = Check.pouzeCelaCisla(sc);
				try
				{
					if(databaze.containsKey(id))
					{
						info = databaze.get(id);
						if(info.getList().isEmpty())
						{
							System.out.println("Učitel s ID: "+id+", "+info.getName()+" "+info.getSurname()+" zatím nemá žádného studenta.");
						}
						else
						{
						System.out.println("K vyučujícímu s ID: "+id+", "+info.getName()+" "+info.getSurname()+", jsou přiřazeni studenti:");
						for(int i=0;i<info.getList().size();i++)
						{
							Osoba info2 = databaze.get(info.getList().get(i));
					    	System.out.println("ID: "+info2.getID()+", "+info2.getName()+" "+info2.getSurname());
						} 	
					}
					
					}
					else
					{
						System.out.println("Učitel s ID: "+id+" není v databázi.");
					}
				}
				catch(NullPointerException e)
				{
						System.err.println("");
				}
				break;
			
			case 9:
				System.out.println("Učitelé náležící ke studentovi");
				System.out.println("Zadejte ID studenta");
				id = Check.pouzeCelaCisla(sc);
				try
				{
					if(databaze.containsKey(id))
					{
						info = databaze.get(id);
						if(info.getList().isEmpty())
						{
							System.out.println("Student s ID: "+id+", "+info.getName()+" "+info.getSurname()+" zatím nemá žádného učitele.");
						}
						else
						{
							System.out.println("Ke studentovi s ID: "+id+" "+info.getName()+" "+info.getSurname()+", jsou přiřazeni učitelé:");
							for(int i=0;i<info.getList().size();i++)
							{
								Osoba info2 = databaze.get(info.getList().get(i));
								System.out.println("ID: "+info2.getID()+" "+info2.getName()+" "+info2.getSurname());
							} 		
						}
					}
					else
					{
						System.out.println("Student s ID: "+id+" není v databázi.");
					}
				}
				catch(NullPointerException e)
				{
						System.err.println("");
				}
				break;
				
			case 10: //Pro vybraného učitele výpis všech jeho studentů řazený dle studijního průměru.
				System.out.println("Zadejte ID učitele");
				id = Check.pouzeCelaCisla(sc);
				if(databaze.containsKey(id))
				{
					info = databaze.get(id);	//zjištění ID učitele
					if(info.getList().isEmpty())	//ověření, že učitel má nějakého studenta v listu
					{
						System.out.println("Učitel s ID: "+id+" "+info.getName()+" "+info.getSurname()+" zatím nemá žádného studenta.");
					}
					else
					{
						System.out.println("K učiteli s ID: "+id+" "+info.getName()+" "+info.getSurname()+" jsou přiřazeni tito studenti řazeni podle studijního průměru");
						ArrayList<Student2> sez = new ArrayList<Student2>(); 	//porovnani podle jmena
					try 
					{
						for(int i=0;i<info.getList().size();i++)
						{
							Osoba info2 = databaze.get(info.getList().get(i));
							sez.add(new Student2(info2.getName(), info2.getSurname(), info2.getID(), info2.getMeanValue()));  //Ucitel2(String name, String surname, int ID, int number) {
						} 
					}
					catch(NullPointerException e)
					{
						System.err.println("");
					}
				
					Collections.sort(sez, Student2.numComp);
					for(Student2 str: sez)
					{
						System.out.println(str);
					}
					sez.clear();
					}
				}
				else
				{
					System.out.println("Učitel není v databázi.");
				}
				break;
			case 11: //Výpis všech učitelů řazených podle aktuálního počtu studentů.		
				ArrayList<Ucitel2> prum = new ArrayList<Ucitel2>(); 	//porovnani podle jmena
				try 
				{
					for(int i=1;i<1000;i++)
					{
						info = databaze.get(i);
						prum.add(new Ucitel2(info.getName(), info.getSurname(), info.getID(), info.getListSize()));  //Ucitel2(String name, String surname, int ID, int number) {
					} 
				}
				catch(NullPointerException e)
				{
					System.err.println("");
				}
					
				Collections.sort(prum, Ucitel2.numComp);
				for(Ucitel2 str: prum)
				{
					System.out.println(str);
				}
				prum.clear();
				break;
				
			case 12:
				//Studenti
				cash = 0;
				try
				{
					for(int i=1000; i<1000000000; i++)
					{
						info = databaze.get(i);
						info.getCash();
						cash += info.getCash();
					}
				}
				catch(NullPointerException e)
				{
					
				}
				System.out.println("Výše finančních prostředků na stipendia je " +cash+" Kč.");
				//Ucitele
				cash1 = 0;
				try
				{
					for(int i=1; i<1000; i++)
					{
						info = databaze.get(i);
						info.getCash();
						cash1 += info.getCash();
					}
				}
				catch(NullPointerException e)
				{
	
				}
				System.out.println("Výše finančních prostředků na hrubou mzdu je " +(int)(cash1*GROSSSALARY)+" Kč.");
				break;
				
			case 13: //připojení k sql
				if(connect())
				{
					System.out.println("Databázi se podařilo připojit");
					
				}
				else
				{
					System.out.println("Databázi se nepodařilo připojit");
				}
			case 14: //načtení ze sql
				if (con == null) 
				{
					System.out.println("Databázi se nepodařilo připojit");
					break;
				}
				sql = "SELECT * FROM data";
				try
				{
					stmnt = con.createStatement();
					rs = stmnt.executeQuery(sql);
					while (rs.next()) 
					{
						System.out.println("ID: " + rs.getInt("id") + "\t" +  
			                	"typ osoby: "+rs.getString("salute") + "\t" + 
			                	"jmeno: "+rs.getString("name") + "\t" + 
			                	"přijmení: "+rs.getString("surname") + "\t" + 
			                	"rok narození: "+rs.getInt("year") + "\t" 
			                	 );
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
	
			case 15:	//uložení do sql
				if (con == null) {
					System.out.println("Databázi se nepodařilo připojit");
					break;
				}
				sql = "INSERT OR REPLACE INTO data(ID, salute, name, surname, year) VALUES(?,?,?,?,?)"; 
				for (Map.Entry<Integer, Osoba> entry: databaze.entrySet())
				{
					info = entry.getValue();
					try 
					{
						pstmnt = con.prepareStatement(sql);
						pstmnt.setInt(1, info.getID());
						pstmnt.setString(2, info.getSalute());
						pstmnt.setString(3, info.getName());
						pstmnt.setString(4, info.getSurname());
						pstmnt.setInt(5, info.getYear());
						pstmnt.executeUpdate();
					}
					catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Databáze byla uložena.");
				break;
			
			case 16:  //vymazání vybrané osoby ze sql
				if(con == null)
				{
					System.out.println("Databázi se nepodařilo připojit");
					break;
				}
				System.out.println("Zadejte ID odoby kterou chcete odebrat ze sql databáze");
				id = Check.pouzeCelaCisla(sc);
				sql = "DELETE FROM data WHERE id = ? ";
				try
				{
					PreparedStatement prstmnt = con.prepareStatement(sql);
					prstmnt.setInt(1, id);
					prstmnt.executeUpdate();
					System.out.println("Ze sql databáze byla smazána osoba s ID: "+id);
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				break;
				
						
			case 17:	//načtení vybraného osoby ze sql
				if(con == null)
				{
					System.out.println("Databázi se nepodařilo připojit");
					break;
				}
				System.out.println("Zadejte ID odoby kterou chcete načíst ze sql databáze");
				int id = Check.pouzeCelaCisla(sc);
				sql = "SELECT * FROM data WHERE id = ?";
				try 
				{
					pstmnt = con.prepareStatement(sql);
					pstmnt.setInt(1, id);
					rs = pstmnt.executeQuery();
					while(rs.next())
					{
						System.out.println("ID: " + rs.getInt("id") + "\t" +  
			                	"typ osoby: "+rs.getString("salute") + "\t" + 
			                	"jmeno: "+rs.getString("name") + "\t" + 
			                	"přijmení: "+rs.getString("surname") + "\t" + 
			                	"rok narození: "+rs.getInt("year") + "\t" 
			                	 );
					}
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				break;
			}
		}
	}
}



