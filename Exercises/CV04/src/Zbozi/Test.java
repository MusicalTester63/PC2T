package Zbozi;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Zbozi[] pole = new Zbozi[]
        {
                new Potravina("Rohlík", 1.5D, 1),
                new Naradi("Kleště", 278.0D, 24),
                new Potravina("Chleba", 20.8D, 6),
                new Potravina("Jablko", 51.0D, 20),
                new Naradi("Kladivo", 78.0D, 24),
                new Naradi("Hrebíky", 8.0D, 24),

        };


        for(int i = 0; i < pole.length; i++) {
            if (pole[i] instanceof Potravina) {
                System.out.println(pole[i].getJmeno() + " cena: " + pole[i].getCena() + " trvanlivost: " + ((Potravina)pole[i]).getTrvanlivost() + " " + pole[i].getJednotka());
            } else {
                System.out.println(pole[i].getJmeno() + " cena: " + pole[i].getCena() + ",Záruka: " + ((Naradi)pole[i]).getZaruka() + " " );
            }
        }

    }
}
