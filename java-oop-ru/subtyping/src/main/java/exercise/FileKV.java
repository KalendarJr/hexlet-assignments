package exercise;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String path;
    private final Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.path = filePath;
        if (this.path != null) {
            String fileContent = Utils.readFile(path);
            if (fileContent == null || fileContent.trim().length() == 0) {
                this.data = initialData;
            } else {
                this.data = Utils.unserialize(fileContent);
            }
        } else {
            this.data = initialData;
            Utils.writeFile(null, Utils.serialize(data));
        }
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String value = data.get(key);
        return value == null ? defaultValue : value;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }
}
// END
