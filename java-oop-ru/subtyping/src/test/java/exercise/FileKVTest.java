package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
//    @Test
//    void testGetExistingKey() {
//        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
//        Assertions.assertEquals("value", storage.get("key", "default"));
//    }
//
//    @Test
//    void testGetNonExistingKey() {
//        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
//        Assertions.assertEquals("default", storage.get("non-existing-key", "default"));
//    }
//
//    @Test
//    void testSet() {
//        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
//        storage.set("new-key", "new-value");
//        Assertions.assertEquals("new-value", storage.get("new-key", "default"));
//    }
//
//    @Test
//    void testUnset() {
//        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
//        storage.unset("key");
//        Assertions.assertEquals("default", storage.get("key", "default"));
//    }
    @Test
    void testSet() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.set("key4", "value4");
        Assertions.assertEquals("value4", storage.get("key4", ""));
    }

    @Test
    void testUnset() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.unset("key");
        Assertions.assertFalse(storage.toMap().containsKey("key"));
    }

    @Test
    void testGet() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        Assertions.assertEquals("default", storage.get("non-existent-key", "default"));
    }

    @Test
    void testToMap() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        Map<String, String> expected = new HashMap<>();
        expected.put("key1", "value1");
        expected.put("key2", "value2");
        storage.set("key1", "value1");
        storage.set("key2", "value2");
        Assertions.assertEquals(expected, storage.toMap());
    }
    // END
}
