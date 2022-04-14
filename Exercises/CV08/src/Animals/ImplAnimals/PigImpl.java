package Animals.ImplAnimals;

import Animals.Animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PigImpl implements Animal {


  private byte age;

  public PigImpl() {}

  public PigImpl(byte age) {
    super();
    this.age = age;
  }

  @Override
  public String sound() {
    return "chro chro";
  }


  @Override
  public void saveToFile(Path pathToFile) {
    try {
      Files.write(pathToFile, "chro chro".getBytes());
    } catch (IOException e) {
    }
  }

  public byte getAge() {
    return age;
  }

  public void setAge(byte age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "PigImpl [age=" + age + "]";
  }

}
