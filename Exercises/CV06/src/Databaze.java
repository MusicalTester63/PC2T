import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Databaze {

    private Map<String,Student>  prvkyDatabaze;

    Databaze()
    {
        prvkyDatabaze = new HashMap<>();
    }

    public boolean setStudent(String name,int year)
    {
        if (prvkyDatabaze.put(name,new Student(name,year)) == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Student getStudent(String name)
    {
        return prvkyDatabaze.get(name);
    }

    public boolean setAvg(String name, float avg) throws prumerException {
        if (prvkyDatabaze.get(name) == null)
        {
            return false;
        }
        return prvkyDatabaze.get(name).setStudijniPrumer(avg);
    }
    public boolean rmStudent(String name)
    {
        if (prvkyDatabaze.remove(name)!=null)
        {
            return true;
        }
        return false;
    }

    public void printDatabase()
    {
        Set<String> nameList = prvkyDatabaze.keySet();

        for(String name:nameList)
        {
            System.out.println(name);
        }
    }

}