import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Databaze {

    private final Scanner sc;
    private Student[] prvkyDatabaze;
    private int posledniStudent;

    public Databaze(int pocetPrvku)
    {
        this.prvkyDatabaze = new Student[pocetPrvku];
        this.sc = new Scanner(System.in);

    }

    public void setStudent()
    {
        System.out.println("Zadejte jmeno studenta, rok narozeni");
        String jmeno = this.sc.next();
        int rok = Test.pouzeCelaCisla(this.sc);
        this.prvkyDatabaze[this.posledniStudent++] = new Student(jmeno, rok);


    }

    public int getPosledniStudent(){return this.posledniStudent;}

    public Student getStudent(int idx)
    {
        return this.prvkyDatabaze[idx];
    }

    public void setPrumer(int idx, float prumer) throws prumerException
    {
        this.prvkyDatabaze[idx].setStudijniPrumer(prumer);
    }


    public boolean ulozDatabazi(String jmenoSouboru)
    {
        try {

            jmenoSouboru = jmenoSouboru +".txt";
            FileWriter fw = new FileWriter(jmenoSouboru);
            BufferedWriter out = new BufferedWriter(fw);

            out.write("Pocet " + prvkyDatabaze.length);
            out.newLine();

            for (int i=0;i<prvkyDatabaze.length;i++)
            {
                if (prvkyDatabaze[i]!=null)
                {
                    out.write(

                            prvkyDatabaze[i].getJmeno() + " "
                                    + prvkyDatabaze[i].getRocnik() + " "
                                    + prvkyDatabaze[i].getStudijniPrumer()

                    );
                    out.newLine();
                }
                else
                {
                    out.write("null");
                    out.newLine();
                }
            }
            out.close();
            fw.close();


        }
        catch (IOException e)
        {
            System.out.println("Soubor nelze vytvorit");
            return false;
        }
        catch (prumerException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean nactiDatabazi(String jmenoSouboru) {

        FileReader fr = null;
        BufferedReader in = null;

        try {

            fr = new FileReader(jmenoSouboru);
            in = new BufferedReader(fr);

            String radek = in.readLine();

            String oddelovac = " ";

            String[] castiTextu = radek.split(oddelovac);

            if (castiTextu.length != 2)
            {
                return false;
            }

            int pocetPrvku = Integer.parseInt(castiTextu[1]);

            prvkyDatabaze = new Student[pocetPrvku];

            for (int i=0;i<pocetPrvku;i++)
            {
                radek = in.readLine();
                castiTextu = radek.split(oddelovac);

                if (castiTextu.length == 3)
                {
                    prvkyDatabaze[i] = new Student(castiTextu[0], Integer.parseInt(castiTextu[1]) );

                    prvkyDatabaze[i].setStudijniPrumer(Float.parseFloat(castiTextu[2]) );
                }
            }
        }
        catch (IOException e) {
            System.out.println("Súbor nie je možné otvoriť");
            return false;
        }
        catch (NumberFormatException e) {
            System.out.println("Chyba pri čítaní súboru");
            return false;
        } catch (prumerException e) {
            System.out.println("Nesprávne dáta v súbore");
            return false;
        }
        finally
        {
            try
            {
                if (in!=null)
                {
                    in.close();
                    fr.close();
                }
            }
            catch (IOException e) {
                System.out.println("Súbor nie je možné zatvoriť");
                return false;
            }
        }

        return true;
    }



    public void vypisDatabazi()
    {
        for (int i=0;i<prvkyDatabaze.length;i++) {
            int cislovani = i+1;
            if (prvkyDatabaze[i] != null) {
                try {

                    System.out.println(cislovani + ". " + prvkyDatabaze[i].getJmeno() + " " + prvkyDatabaze[i].getRocnik() + " " + prvkyDatabaze[i].getStudijniPrumer());
                }
                catch (prumerException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {

                System.out.println(cislovani + ". " + "null");

            }

        }
    }



}
