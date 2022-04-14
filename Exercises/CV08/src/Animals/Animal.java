package Animals;

import java.nio.file.Path;

public interface Animal {
    String sound();
    void saveToFile(Path pathToFile);
}