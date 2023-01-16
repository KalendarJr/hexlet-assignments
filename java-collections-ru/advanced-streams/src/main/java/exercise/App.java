package exercise;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String json) {
        String[] arrayJson = json.split("\n");
        return Arrays.stream(arrayJson)
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.replace("environment=", ""))
                .map(x -> x.replace("\"", ""))
                .map(x -> x.split(","))
                .flatMap(str -> Arrays.stream(str))
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
