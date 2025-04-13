package utilities;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setup() throws Exception {
        Driver.initializeDriver("android");  // Change to "ios" for iOS
    }

    @After
    public void teardown() {
        Driver.quit();
    }
}
