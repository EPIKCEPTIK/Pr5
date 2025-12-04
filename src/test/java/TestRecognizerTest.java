import org.example.TestRecognizer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestRecognizerTest {

    private final TestRecognizer recognizer = new TestRecognizer();
    @ParameterizedTest
    @CsvSource({
            "TEST,          F",
            "abc,           S",
            "TTEST,         F",
            "TTTEST,        F",
            "TETEST,        F",
            "TTETEST,       F",
            "TESTEST,       F",
            "TESA_TEST,     F",
            "TE_TEST,       F",
    })
    void testLogic(String input, TestRecognizer.State expected) {
        assertEquals(expected, recognizer.process(input));
    }
}