package Animals.ImplAnimals;

import Animals.Animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CatImpl implements Animal {

  //private static final Logger LOGGER = LoggerFactory.getLogger(CatImpl.class);

  private byte age;

  public CatImpl() {}

  public CatImpl(byte age) {
    super();
    this.age = age;
  }

  @Override
  public String sound() {
    return "mnau";
  }


  @Override
  public void saveToFile(Path pathToFile) {
    try {
      Files.write(pathToFile, "mnau".getBytes(), StandardOpenOption.CREATE);
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
    return "CatImpl [age=" + age + "]";
  }

}
