package Animals.AbstractAnimals;
import Animals.AbstractAnimal;


public class Cat extends AbstractAnimal {

  @Override
  public String sound() {
    return "Mnau";
  }

  @Override
  public String toString() {
    return "Cat [age=" + age + "]";
  }

}
