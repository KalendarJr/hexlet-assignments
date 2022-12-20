package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> listBooks, Map<String, String> dictionary) {
        List<Map<String, String>> actualList = new ArrayList<>();

        for (Map<String, String> index: listBooks) {
            boolean result = true;
            for (Map.Entry<String, String> books: dictionary.entrySet()) {
                    if (!books.getValue().equals(index.get(books.getKey()))) {
                        result = false;
                        break;
                    }
            }
            if (result) {
                actualList.add(index);
            }
        }

        return actualList;
    }
}
//END
