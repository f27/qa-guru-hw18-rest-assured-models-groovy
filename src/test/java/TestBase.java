import org.junit.jupiter.api.BeforeAll;
import steps.ApiSteps;

public class TestBase {
    static ApiSteps apiSteps;

    @BeforeAll
    public static void setup() {
        apiSteps = new ApiSteps();
    }
}
