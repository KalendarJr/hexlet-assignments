package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> oneDictionary, Map<String, Object> twoDictionary) {
        Map<String, String> linkedMap = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>();

        keys.addAll(oneDictionary.keySet());
        keys.addAll(twoDictionary.keySet());

        for (String x: keys) {
                if (!oneDictionary.containsKey(x)) {
                    linkedMap.put(x, "added");
                } else if (!twoDictionary.containsKey(x)) {
                    linkedMap.put(x, "deleted");
                } else if (!oneDictionary.get(x).equals(twoDictionary.get(x))) {
                    linkedMap.put(x, "changed");
                } else {
                    linkedMap.put(x, "unchanged");
                }
        }

        return linkedMap;
    }
}
//END
