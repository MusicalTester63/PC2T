import java.util.Scanner;

public class Test {
    public Test() {
    }

    public static int pouzeCelaCisla(Scanner sc) {

        int cislo;

        try
        {
            cislo = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }

        return cislo;
    }

    public static float pouzeCisla(Scanner sc) {
        float cislo = 0.0F;

        try {
            cislo = sc.nextFloat();
        } catch (Exception e) {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cislo ");
            sc.nextLine();
            cislo = pouzeCisla(sc);
        }

        return cislo;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze(1);
        boolean run = true;

        while(run) {
            System.out.println("\nVyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni nove databaze");
            System.out.println("2 .. vlozeni noveho studenta");
            System.out.println("3 .. nastaveni prumeru studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. ukonceni aplikace");

            int volba = pouzeCelaCisla(sc);

            int idx;

            switch(volba) {
                case 1:
                    System.out.println("Zadejte pocet studentu");
                    mojeDatabaze = new Databaze(pouzeCelaCisla(sc));
                    break;
                case 2:
                    try {
                        mojeDatabaze.setStudent();
                    } catch (ArrayIndexOutOfBoundsException var15) {
                        System.out.println("Nebylo mozno vytvorit novou polozku, databaze je plna");
                    }
                    break;
                case 3:
                    System.out.println("Zadejte index a prumer studenta");
                    idx = pouzeCelaCisla(sc);
                    float prumer = pouzeCisla(sc);

                    try {
                        mojeDatabaze.setPrumer(idx, prumer);
                    } catch (ArrayIndexOutOfBoundsException var12) {
                        System.out.println("Vybrana polozka mimo rozsah databaze");
                    } catch (NullPointerException var13) {
                        System.out.println("Vybrana polozka neexistuje");
                    } catch (prumerException var14) {
                        System.out.println(var14.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Zadejte index studenta");
                    idx = pouzeCelaCisla(sc);
                    Student info = null;

                    try {
                        info = mojeDatabaze.getStudent(idx);
                        System.out.println("Jmeno: " + info.getJmeno() + "\nRok narozeni: " + info.getRocnik() + "\nPrumer: " + info.getStudijniPrumer());
                    } catch (prumerException var9) {
                        System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " Prumer nebyl zadan");
                    } catch (ArrayIndexOutOfBoundsException var10) {
                        System.out.println("Vybrana polozka mimo rozsah databaze");
                    } catch (NullPointerException var11) {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                    break;
                case 5:
                    System.out.println("Sbohem");
                    run = false;
            }
        }

    }
}
