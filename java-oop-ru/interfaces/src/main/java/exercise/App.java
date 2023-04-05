package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int elements) {
        List<String> result = homes.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(elements)
                .map(Home::toString)
                .collect(Collectors.toList());
        return result;
    }
}
// END
