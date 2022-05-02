import java.util.Scanner;

public class Databaze {

    private Scanner sc;
    private Student[] prvkyDatabaze;
    private int posledniStudent;

    public Databaze(int pocetPrvku)
    {
        this.prvkyDatabaze = new Student[pocetPrvku];
        this.sc = new Scanner(System.in);
    }

    public void setStudent() {
        System.out.println("Zadejte jmeno studenta, rok narozeni");
        String jmeno = this.sc.next();
        int rok = Test.pouzeCelaCisla(this.sc);
        this.prvkyDatabaze[this.posledniStudent++] = new Student(jmeno, rok);
    }

    public Student getStudent(int idx)
    {
        return this.prvkyDatabaze[idx];
    }

    public void setPrumer(int idx, float prumer) throws prumerException
    {
        this.prvkyDatabaze[idx].setStudijniPrumer(prumer);
    }
}
