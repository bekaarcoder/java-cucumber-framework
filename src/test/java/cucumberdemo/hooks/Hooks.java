package cucumberdemo.hooks;

import cucumberdemo.context.TestContext;
import cucumberdemo.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before(value = "@skip", order = 0)
    public void skipScenario(Scenario scenario) {
        throw new SkipException("Skipping Scenario: " + scenario.getName());
    }

    @Before(order = 1)
    public void before() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take Screenshot
            System.out.println("Taking Screenshot");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/target/cucumber/screenshots/" + screenshotName + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    @After(order = 0)
    public void after() {
        driver.quit();
    }
}
