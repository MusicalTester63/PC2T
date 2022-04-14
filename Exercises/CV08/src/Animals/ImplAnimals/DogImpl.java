package Animals.ImplAnimals;

import Animals.Animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DogImpl implements Animal {

  //private static final Logger LOGGER = LoggerFactory.getLogger(DogImpl.class);

  private byte age;

  public DogImpl() {}

  public DogImpl(byte age) {
    super();
    this.age = age;
  }

  @Override
  public String sound() {
    return "haf haf";
  }


  @Override
  public void saveToFile(Path pathToFile) {
    try {
      Files.write(pathToFile, "haf haf".getBytes());
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
    return "DogImpl [age=" + age + "]";
  }

}
