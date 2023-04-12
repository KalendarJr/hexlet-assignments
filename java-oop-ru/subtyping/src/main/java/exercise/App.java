package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage object) {
        Map<String, String> map = object.toMap();
        Map<String, String> newMap = new HashMap<>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<String, String> entry : entrySet) {
            object.unset(entry.getKey());
        }
        for (Map.Entry<String, String> entry : newMap.entrySet()) {
            object.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
