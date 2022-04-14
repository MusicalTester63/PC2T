public class Hranol extends Ctverec{ //fix opravenie Cetverec na Ctverec

	private float hrana;
	private float podstava;
	boolean zeDreva;
	static int pocetHranolu=0;	//fix odstraneni final


	// konstruktor se zadanim delky hrany, vysky a materialu
	Hranol(float podstava,float vyska, boolean drevena,float hrana){

		super(hrana);		//fix pridanie super()
		hrana=vyska;
		this.podstava=podstava;
		zeDreva=drevena;
		pocetHranolu++;
	}

	// vypocet objemu hranolu
	float vypoctiObjem() {

		return this.podstava*hrana;		//fix vypocet objemu
	}
	
	// nastaveni materialu
	void setDreveny(boolean dreveny){
		zeDreva=dreveny;
	}
	
	// zjisteni materialu
	boolean jeDreveny(){
		return zeDreva;
	}
	
	// zjisteni celkoveho poctu existujicich kostek
	static int getPocetHranolu(){
		return pocetHranolu;
	}
	
	// zjisteni vysky hranolu
	float getHrana(){					
		return hrana;
	}
	// nastaveni vysky hranolu
	void setHrana(float delka){			
		hrana=delka;
	}
		

	
	
}
