package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String words) {
        var wordsNew = words.toLowerCase();
        ArrayList<String> symbolsList = new ArrayList<>(Arrays.asList(symbols.split("")));
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsNew.split("")));

        symbolsList.retainAll(wordsList);

        for (var i = 0; i < symbolsList.size(); i++) {
            for (var j = 0; j < wordsList.size(); j++) {
                if (wordsList.get(j).equals(symbolsList.get(i))) {
                    wordsList.remove(j);
                }
            }
        }

        return wordsList.size() == 0;
    }
}
//END
