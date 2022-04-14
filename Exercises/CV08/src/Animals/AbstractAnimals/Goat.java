package Animals.AbstractAnimals;


import Animals.AbstractAnimal;
import java.util.logging.Logger;


public class Goat extends AbstractAnimal {


  @Override
  public String sound() {
    return "Beee";
  }

  @Override
  public String toString() {
    return "Goat [age=" + age + "]";
  }

}
