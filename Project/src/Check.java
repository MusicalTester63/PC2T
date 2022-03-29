import java.util.Scanner;

public class Check {
	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim celé číslo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	public static float pouzeCisla(Scanner sc)     //metoda, která po zadání znaku z klávesnice rozhodne, jestli se jedná o číslo typu float
	{
		float cislo1 = 0;
		try			//ošetření vyjimky metodou hlídaných bloků
		{
			cislo1 = sc.nextFloat();		//hlídaný blok, v němž mohou nastat vyjímky
		}
		catch(Exception e)		//když se zadá znak, který není typu float, nastane výpis, že nastane vyjimka a výzva, aby uživatel zadal číslo
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim číslo ");
			sc.nextLine();
			cislo1 = pouzeCisla(sc);
		}
		return cislo1;
	}
}

