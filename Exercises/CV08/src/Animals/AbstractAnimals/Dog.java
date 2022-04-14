package Animals.AbstractAnimals;


import Animals.AbstractAnimal;
import java.util.logging.Logger;


public class Dog extends AbstractAnimal {


  @Override
  public String sound() {
    return "Haf haf";
  }

  @Override
  public String toString() {
    return "Dog [age=" + age + "]";
  }

}
