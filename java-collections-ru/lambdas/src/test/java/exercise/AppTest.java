package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testEnlargeArrayImage() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] resultImage = {
            {"*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", " ", " ", " ", " ", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*"},
        };

        assertThat(App.enlargeArrayImage(image)).isEqualTo(resultImage);
    }
}
// END
