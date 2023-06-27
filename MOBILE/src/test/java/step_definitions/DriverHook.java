package step_definitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverHook {

    String runOn = "browserstack";

    public static AndroidDriver driver;

    @Before
    public void initiateDriver(Scenario scenario) throws Exception {
        if (runOn.equals("browserstack")) {
            setBrowserstackCapabilities(scenario);
        } else {
            useLocalDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // set implicit wait to 5 seconds
    }

    @After
    public void quitDriver(Scenario scenario) {
        setBrowserstackStatus(!scenario.isFailed());
        driver.quit();
        System.out.println("""

                ████████╗███████╗███████╗████████╗    ██████╗  ██████╗ ███╗   ██╗███████╗
                ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗██╔═══██╗████╗  ██║██╔════╝
                   ██║   █████╗  ███████╗   ██║       ██║  ██║██║   ██║██╔██╗ ██║█████╗ \s
                   ██║   ██╔══╝  ╚════██║   ██║       ██║  ██║██║   ██║██║╚██╗██║██╔══╝ \s
                   ██║   ███████╗███████║   ██║       ██████╔╝╚██████╔╝██║ ╚████║███████╗
                   ╚═╝   ╚══════╝╚══════╝   ╚═╝       ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝╚══════╝
                                                                                        \s
                """);
        Logger logger = LoggerFactory.getLogger(DriverHook.class);
        logger.info("See reports: "+System.getProperty("user.dir")+"/reports/cucumber_reports/report.html");
    }

    void setBrowserstackStatus(boolean status) {
        JavascriptExecutor jse = driver;

        if (!status) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\"}}");
        } else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\"}}");
        }
    }

    void useLocalDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554") // get from command "adb devices"
                .setAppPackage("E:\\AndroidStudio\\application\\app-release.apk") // change to package name of application to be tested
                .setAppActivity("app-release.apk"); // set to main activity of the application
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
    }

    void setBrowserstackCapabilities(Scenario scenario) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/java/bsconfig.json"));

        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONArray envs = (JSONArray) config.get("environments");
        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }
        }

        capabilities.setCapability("build", "Test Mobile Capstone - "+java.time.LocalDate.now());
        capabilities.setCapability("name", scenario.getName());

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("username");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("access_key");
        }

        driver = new AndroidDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
    }
}
