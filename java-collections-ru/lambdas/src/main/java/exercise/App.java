package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(str -> new String[][]{str, str})
                .flatMap(str -> Arrays.stream(str))
                .map(str -> Arrays.stream(str)
                        .map(x -> new String[] {x ,x})
                        .flatMap(x -> Arrays.stream(x))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
    }
}
// END
