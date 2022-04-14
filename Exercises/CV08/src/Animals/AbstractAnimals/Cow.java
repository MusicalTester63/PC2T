package Animals.AbstractAnimals;


import Animals.AbstractAnimal;

import java.util.logging.Logger;


public class Cow extends AbstractAnimal {


  @Override
  public String sound() {
    return "Boo";
  }

  @Override
  public String toString() {
    return "Cow [age=" + age + "]";
  }

}
