package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        ArrayList<String> wordsSentence = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        Map<String, Integer> wordsMap = new HashMap<>();

        for(var word: wordsSentence) {
            if (wordsSentence.size() == 1) {
                wordsMap.clear();
            } else if(wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else if (!wordsMap.containsKey(word) && wordsSentence.size() != 1) {
                wordsMap.put(word, 1);
            }
        }

        return wordsMap;
    }

    public static String toString(Map<String, Integer> words) {
        var str = "";

        for (Map.Entry<String, Integer> word: words.entrySet()) {
                str += "  " + word.getKey() + ": " + word.getValue() + "\n";
        }

        if (str == "") {
            str = "{}";
        } else if (str != "") {
            str = "{\n" + str + "}";
        }

        return str;
    }
}
//END
