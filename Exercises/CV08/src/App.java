import Animals.AbstractAnimal;
import Animals.AbstractAnimals.*;
import Animals.Animal;
import Animals.ImplAnimals.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * When we talk about abstract classes we are defining characteristics of an object type; specifying what an object is.
 *
 * When we talk about an interface and define capabilities that we promise to provide, we are
 * talking about establishing a contract about what the object can do.
 *
 * Enum provides an efficient way to define a set of named integral constants that may be assigned to a variable.
 *
 * @author David Hamran & Michal Vida
 *
 */

public class App {

    //Separator
    public static void separator(int lineLength){
        if(lineLength == 0 || lineLength < 0){lineLength=30;}
        System.out.println();
        for(int i=0;i<lineLength;i++)
        {

            System.out.print("-");

        }
        System.out.println();
    }


    //Creating Lists

    public static List<Employee> createEmployeeList() {

        Employee Employee1 = new Employee("vtak", "e@seznam.cz", "pilot".toCharArray(), EmployeeType.ACTIVE);
        Employee Employee2 = new Employee("barak", "d@gmail.com", "stavbar".toCharArray(), EmployeeType.INACTIVE);
        Employee Employee3 = new Employee("kominos", "c@gmail.com", "dymic".toCharArray(), EmployeeType.DELETED);
        Employee Employee4 = new Employee("kp", "b@centrum.sk", "placeholder".toCharArray(), EmployeeType.ACTIVE);
        Employee Employee5 = new Employee("eiffel", "a@televizna.sk", "vysielac".toCharArray(), EmployeeType.ACTIVE);

        return Arrays.asList(Employee1, Employee2, Employee3, Employee4, Employee5);
    }

    public static List<AbstractAnimal> getAnimals() {
        AbstractAnimal cat = new Cat();
        AbstractAnimal cow = new Cow();
        AbstractAnimal dog = new Dog();
        AbstractAnimal goat = new Goat();
        AbstractAnimal pig = new Pig();
        return Arrays.asList(cat, cow, dog, goat, pig);
    }

    public static List<Animal> getAnimalsInterface() {
        Animal cat = new CatImpl((byte) 1);
        Animal cow = new CowImpl((byte) 10);
        Animal dog = new DogImpl((byte) 3);
        Animal goat = new GoatImpl((byte) 4);
        Animal pig = new PigImpl((byte) 7);
        return Arrays.asList(cat, cow, dog, goat, pig);
    }



    public static void main(String[] args) {

        int lineLength = 80;

        Manager<Secretarian> VelkyManager = new Manager<>();

        var listOfEmployees = createEmployeeList();

        Secretarian secretar1 = new Secretarian("Buka", "vladimirbukovsky@gmail.com", "borovicka".toCharArray(), EmployeeType.ACTIVE, 45);
        Secretarian secretar2 = new Secretarian("Kacena", "telarka@gmail.com", "uaaaaa".toCharArray(), EmployeeType.NAPITY, 57);

        separator(lineLength);
        System.out.println("UNSORTED:");
        VelkyManager.setListOfEmployees(listOfEmployees);
        VelkyManager.addRelationship(secretar1);
        VelkyManager.printAllEmployeesAndRelationships();           //Unsorted Employees

        Collections.sort(listOfEmployees);


        separator(lineLength);


        System.out.println("SORTED:");
        VelkyManager.printAllEmployeesAndRelationships();           //sorted Employees

        separator(lineLength);
        System.out.println("ABSTRACT ANIMAL ANIMALS:");
        List<AbstractAnimal> abstractAnimals = getAnimals();
        abstractAnimals.forEach(animal -> System.out.println(animal.sound()));

        separator(lineLength);
        System.out.println("IMPLEMENTED ANIMAL ANIMALS:");
        List<Animal> animals = getAnimalsInterface();
        animals.forEach(animal -> System.out.println(animal.sound()));

    }

}
