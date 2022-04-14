package Animals.AbstractAnimals;


import Animals.AbstractAnimal;


public class Pig extends AbstractAnimal {


  @Override
  public String sound() {
    return "Oink chro";
  }

  @Override
  public String toString() {
    return "Pig [age=" + age + "]";
  }

}
