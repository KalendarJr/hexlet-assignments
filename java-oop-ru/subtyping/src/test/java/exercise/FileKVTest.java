package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testGetExistingKey() throws Exception {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertEquals("value1", storage.get("key1", ""));
        assertEquals("value2", storage.get("key2", ""));
    }

    @Test
    public void testGetNonExistingKey() throws Exception {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertEquals("", storage.get("key3", ""));
    }

    @Test
    public void testSetNewKey() throws Exception {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.set("key3", "value3");
        assertEquals("value3", storage.get("key3", ""));
    }

    @Test
    public void testSetExistingKey() throws Exception {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.set("key1", "newvalue1");
        assertEquals("newvalue1", storage.get("key1", ""));
    }

    @Test
    public void testDeleteExistingKey() throws Exception {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.unset("key1");
        assertEquals("", storage.get("key1", ""));
    }

    @Test
    public void testDeleteNonExistingKey() throws Exception {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.unset("key3");
        assertEquals("", storage.get("key3", ""));
    }

    @Test
    public void testSaveDataToFile() throws Exception {
        String json = Utils.readFile("src/test/resources/file");
        Map<String, String> dataFromFile = Utils.unserialize(json);
        assertEquals("value1", dataFromFile.get("key1"));
        assertEquals("value2", dataFromFile.get("key2"));
    }
    // END
}
