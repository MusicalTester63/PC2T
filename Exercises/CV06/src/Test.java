import java.util.Scanner;


public class Test {
    public Test() {
    }

    public static int onlyIntegers(Scanner sc)
    {

        int cislo=0;
        try
        {
            cislo = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = onlyIntegers(sc);
        }
        return cislo;
    }

    public static float onlyNumbers(Scanner sc) {
        float cislo = 0.0F;

        try
        {
            cislo = sc.nextFloat();
        }
        catch (Exception e)
        {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cislo ");
            sc.nextLine();
            cislo = onlyNumbers(sc);
        }
        return cislo;
    }


    public static void main(String[] args) throws prumerException {

        Scanner sc=new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze();
        float prumer;
        int volba;
        String jmeno;
        int rok;
        boolean run = true;

        while(run)
        {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vlozeni noveho studenta");
            System.out.println("2 .. nastaveni prumeru studenta");
            System.out.println("3 .. vypis informace o studentovi");
            System.out.println("4 .. odstraneni studenta ");
            System.out.println("5 .. vypis studentu ");
            System.out.println("6 .. ukonceni aplikace");

            volba = onlyIntegers(sc);
            switch(volba)
            {
                case 1:
                    System.out.println("Zadejte jmeno studenta, rok narozeni");
                    jmeno=sc.next();
                    rok=Test.onlyIntegers(sc);
                    if (!mojeDatabaze.setStudent(jmeno,rok))
                    {
                        System.out.println("Student v databazi jiz existuje");
                    }
                break;

                case 2:
                    mojeDatabaze.printDatabase();
                    System.out.println("Zadejte jmeno a prumer studenta");
                    jmeno=sc.next();
                    prumer = onlyNumbers(sc);
                    if (!mojeDatabaze.setAvg(jmeno,prumer))
                    {
                        System.out.println("Prumer nezadan");
                    }
                break;

                case 3:
                    System.out.println("Input name of the student: ");
                    jmeno = sc.next();
                    Student info = null;
                    info = mojeDatabaze.getStudent(jmeno);
                    if (info!=null)
                    {
                        System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
                    }
                    else
                    {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                break;


                case 4:
                    System.out.println("Zadejte jmeno studenta k odstraneni");
                    jmeno = sc.next();
                    if (mojeDatabaze.vymazStudenta(jmeno)) {
                        System.out.println(jmeno + " odstranen ");
                    }
                    else
                    {
                        System.out.println(jmeno + " neni v databazi ");
                    }
                break;

                case 5:
                    mojeDatabaze.printDatabase();
                break;

                case 6:
                    run = false;
                break;
            }

        }

    }
}
//Spýtať sa ako vyčistiť tú konzolu