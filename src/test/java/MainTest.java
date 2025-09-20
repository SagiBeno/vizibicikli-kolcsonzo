import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MainTest {
    @Before
    public void testBefore() {
        Main.isRunningTest = true;
    }

    @Test
    public void testMain() throws IOException, IOException {
        Main.isRunningTest = true;
        Main.main(null);
    }

    @After
    public void testAfter() {
        Main.isRunningTest = false;
    }
}
