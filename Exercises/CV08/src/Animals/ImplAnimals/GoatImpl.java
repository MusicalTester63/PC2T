package Animals.ImplAnimals;

import Animals.Animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GoatImpl implements Animal {


  private byte age;

  public GoatImpl() {}

  public GoatImpl(byte age) {
    super();
    this.age = age;
  }

  @Override
  public String sound() {
    return "bee";
  }


  @Override
  public void saveToFile(Path pathToFile) {
    try
    {
      Files.write(pathToFile, "mee".getBytes());
    }
    catch (IOException e) {
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
    return "GoatImpl [age=" + age + "]";
  }

}
