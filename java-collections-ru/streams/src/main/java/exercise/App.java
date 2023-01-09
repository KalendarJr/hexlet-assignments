package exercise;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        ArrayList<String> emailsList = new ArrayList<>();
        for (String word : emails) {
            String[] strElements = word.split("@");
            Collections.addAll(emailsList, strElements);
        }

        return emailsList.stream()
                .filter(elements -> elements.equals("gmail.com") || elements.equals("yandex.ru") || elements.equals("hotmail.com"))
                .count();
    }
}
// END
