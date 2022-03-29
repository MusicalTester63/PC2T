import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Databaze {

    private final Map<String,Student>  prvkyDatabaze;

    Databaze()
    {
        prvkyDatabaze = new HashMap<>();    //Konstruktor databázy
    }

    public boolean setStudent(String name,int year)
    {
        return prvkyDatabaze.put(name, new Student(name, year)) == null;    //Vloží klúč(meno) a hodnotu(Student) do mapy
    }

    public Student getStudent(String name)
    {
        return prvkyDatabaze.get(name);     //vracia info o študentovi s príslušným klúčom(meno)
    }

    public boolean setAvg(String name, float avg){

        if (prvkyDatabaze.get(name) == null) //Podmienka ktorá zabezpečuje vloženie priemeru len pre existujúci záznam v Mape
        {
            return false;
        }
        return prvkyDatabaze.get(name).setStudijniPrumer(avg);
    }


    public boolean rmStudent(String name)
    {
        return prvkyDatabaze.remove(name) != null;  //Maže záznam s príslušým klúčom z mapy
    }

    public void printDatabase()
    {
        Set<String> nameList = prvkyDatabaze.keySet(); //Vracia množinu obssahuhúcu klúče

        for(String name:nameList)
        {
            System.out.println(name);
        }
    }

}