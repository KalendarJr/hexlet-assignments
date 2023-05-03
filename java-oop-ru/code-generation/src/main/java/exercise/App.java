package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path pathIsFile, Car obj) throws Exception {
        String json = Car.serialize(obj);
        Files.write(pathIsFile, json.getBytes(), StandardOpenOption.CREATE);
    }

    public static Car extract(Path pathIfFile) throws Exception {
        String json = Files.readString(pathIfFile);
        return Car.unserialize(json);
    }
}
// END
