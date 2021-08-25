package api.hooks;

import io.cucumber.java.Before;
import properties.PropertiesLoader;
import util.TestContext;

public class Hooks {

    @Before
    public static void innitProperties() {
        TestContext.resetContext();
        PropertiesLoader.loadProperties();
    }

}
