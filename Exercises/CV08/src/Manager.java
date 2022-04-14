import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class Manager<T> extends Employee {

    private List<Employee> listOfEmployees;
    private List<T> listOfRelationships;


    public Manager() {
        super();
        listOfEmployees = new ArrayList<>();
        listOfRelationships = new ArrayList<>();
    }

    public Manager(List<Employee> listOfEmployees, List<T> listOfRelationships) {
        super();
        this.listOfEmployees = listOfEmployees;
        this.listOfRelationships = listOfRelationships;
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public void addEmployee(Employee employee) {
        this.listOfEmployees.add(employee);
    }

    public List<T> getListOfRelationships() {
        return listOfRelationships;
    }

    public void setListOfRelationships(List<T> listOfRelationships) {
        this.listOfRelationships = listOfRelationships;
    }

    public void addRelationship(T t) {
        this.listOfRelationships.add(t);
    }

    public int printAllEmployeesAndRelationships() {
        int lineLength;
        System.out.println("List of manager employees:");
        listOfEmployees.forEach(System.out::println);
        System.out.println(System.lineSeparator() + "List of manager relationships:");
        listOfRelationships.forEach(System.out::println);

        lineLength = listOfRelationships.size();
        return lineLength;
    }

    @Override
    public String toString() {
        return "Manager [listOfEmployees=" + listOfEmployees + ", listOfRelationships=" + listOfRelationships + "]";
    }

}
