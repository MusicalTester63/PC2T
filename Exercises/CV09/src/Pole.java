import java.util.Scanner;

public class Pole {

	private Scanner sc;
	private Hranol []mojeHranoly;

	// Konstruktor s velikosti pole
	Pole(int velikost)
	{
		mojeHranoly=new Hranol[velikost];
		sc=new Scanner(System.in);
	}
	
	// vlozeni hranolu do pole na prvni volnou pozici
	void zadejHranol(){
		boolean drevena=false;
		float delka=0;
		float vyska=0;
		System.out.println("Zadejte delku podstavy hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		delka=sc.nextFloat();
		System.out.println("Zadejte vysku hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		vyska=sc.nextFloat();
		System.out.println("Je drevena?");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		drevena=sc.nextBoolean();
		if (Hranol.getPocetHranolu()>mojeHranoly.length)
		{
			System.out.println("Pole uz je zaplneno");
			return;
		}
		mojeHranoly[Hranol.getPocetHranolu()].setHrana(delka);			
		mojeHranoly[Hranol.getPocetHranolu()].setHrana(vyska);
		mojeHranoly[Hranol.getPocetHranolu()].setDreveny(drevena);
	}
	
	// vypis objemu vsech hranolu
	void vypoctiObjem()
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
			System.out.println("Objem "+i+". hranolu je" + mojeHranoly[i].vypoctiObjem());		//fix vypisu
	}																							//fix metody z vypoctiObsah na vypoctiObjem
	
	// vypis obsahu podstavy vsech hranolu
	void vypoctiObsahPodstavy()
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)										//fix výpisu
			System.out.println("Obsah "+i+". hranolu je" + mojeHranoly[i].vypoctiObsah()); //fix metody vypoctiObjem na vypoctiObsah
	}
	
	// nalezeni indexu nejmensiho hranolu
	int najdiNejmensiObjem()
	{
		float min=9999999; //Fix minumum nesmie byť nula
		int idx=0;										
		for (int i=0;i<Hranol.getPocetHranolu();i++)
		{
			if (mojeHranoly[i].vypoctiObjem()<min){
				min=mojeHranoly[i].vypoctiObjem();
				idx=i;
			}
		}
		return idx;
	}
	
	// zjisteni celkoveho poctu drevenych kostek
	int zjistiPocetDrevenych(){

		int pocetDrevenych=0;
		for (int i=1;i<mojeHranoly.length;i++)			//fix zmena i>mojeHranoly.length na i<mojeHranoly.length
														//fix pridanie i++
		{
			if (mojeHranoly[i].zeDreva==true)		//fix = na ==
				pocetDrevenych++;
		}
		return pocetDrevenych;
	}


}
