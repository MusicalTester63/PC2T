class Ctverec {

	private float hrana;

	// konstruktor se zadanim delky hrany ctverce
	Ctverec(float hrana){

		this.hrana=hrana;		//fix Pridanie this.
	}

	// vypocet obsahu ctverce
	int vypoctiObsah(){					
		return (int)(hrana*hrana);		
	}

	// zjisteni delky hrany ctverce
	float getHrana(){					
		return hrana;
	}
	// nastaveni delky hrany ctverce
	void setHrana(float delka){			
		hrana=delka;
	}

}
