package exercise;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String path;
    private final Map<String, String> dictionary;

    public FileKV(String path, Map<String, String> dictionary) {
        this.path = path;
        this.dictionary = dictionary;
//        Utils.writeFile(this.path, Utils.serialize(this.dictionary));
    }

    @Override
    public void set(String key, String value) {
        dictionary.put(key, value);
//        Utils.writeFile(path, Utils.serialize(dictionary));
    }

    @Override
    public void unset(String key) {
        dictionary.remove(key);
//        Utils.writeFile(path, Utils.serialize(dictionary));
    }

    @Override
    public String get(String key, String defaultValue) {
        return dictionary.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dictionary);
    }
}
// END
