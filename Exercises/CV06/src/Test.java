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
            System.out.println("Please input natural numbers only!");
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
            System.out.println("Please input numbers only!");
            sc.nextLine();
            cislo = onlyNumbers(sc);
        }
        return cislo;
    }


    public static void main(String[] args) throws prumerException {

        Scanner sc = new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze();
        float prumer;
        int volba;
        String name;
        int year;
        boolean run = true;

        while(run)
        {
            System.out.println("Choose action:");
            System.out.println("1 .. insert new student");
            System.out.println("2 .. set student average");
            System.out.println("3 .. print student information");
            System.out.println("4 .. remove student");
            System.out.println("5 .. print students");
            System.out.println("6 .. EXIT");

            volba = onlyIntegers(sc);
            switch(volba)
            {
                case 1:
                    System.out.println("Input name of the student and his year of birth:");
                    name = sc.next();
                    year = Test.onlyIntegers(sc);
                    if (!mojeDatabaze.setStudent(name,year))
                    {
                        System.out.println("Student already exists!");
                    }
                break;

                case 2:
                    mojeDatabaze.printDatabase();
                    System.out.println("Input name of the student and his average grade: ");
                    name = sc.next();
                    prumer = onlyNumbers(sc);
                    if (!mojeDatabaze.setAvg(name,prumer))
                    {
                        System.out.println("There has been and error inputing average!");
                    }
                break;

                case 3:
                    System.out.println("Input name of the student: ");
                    name = sc.next();
                    Student info = null;
                    info = mojeDatabaze.getStudent(name);
                    if (info!=null)
                    {
                        System.out.println("Name: " + info.getJmeno() + "\nBirthyear: " + info.getRocnik() + "\nAverage: " + info.getStudijniPrumer()+"\n------------------------");
                    }
                    else
                    {
                        System.out.println("Error: Student doesn't exist");
                    }
                break;


                case 4:
                    System.out.println("Input name of the student you want to remove:");
                    name = sc.next();
                    if (mojeDatabaze.rmStudent(name)) {
                        System.out.println(name + " has been removed ");
                    }
                    else
                    {
                        System.out.println(name + " is not in this database!");
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