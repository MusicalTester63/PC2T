public class Student {

    private String jmeno;
    private int rocnik;
    private float studijniPrumer;

    public Student(String jmeno, int rocnik)
    {
        this.jmeno = jmeno;
        this.rocnik = rocnik;
    }

    public String getJmeno() {return this.jmeno;}

    public int getRocnik() {return this.rocnik;}

    public float getStudijniPrumer() throws prumerException
    {
        if (this.studijniPrumer == 0.0F) {
            throw new prumerException();
        }
        else
        {
            return this.studijniPrumer;
        }
    }

    public void setStudijniPrumer(float studijniPrumer) throws prumerException
    {
        if (!(studijniPrumer < 1.0F) && !(studijniPrumer > 5.0F))
        {
            this.studijniPrumer = studijniPrumer;
        }
        else
        {
            throw new prumerException("Zadan nespravny prumer");
        }
    }
}
