import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class Login {
    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid('123456')
                .setApp("/home/myapp.apk");
        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );
        try {
            WebElement field_username = driver.findElement(AppiumBy.xpath("//Button"));
            field_username.click();
            field_username.sendKeys("test@gmail.com");

            WebElement field_password = driver.findElement(AppiumBy.xpath("//Button"));
            field_password.click();
            field_password.sendKeys("test123");

            WebElement button_forget_password = driver.findElement(AppiumBy.xpath("//Button"));
            button_forget_password.click();

            WebElement button_submit_login = driver.findElement(AppiumBy.xpath("//Button"));
            button_submit_login.click();

            WebElement button_create_account = driver.findElement(AppiumBy.xpath("//Button"));
            button_create_account.click();

            driver.getPageSource();

        } finally {
            driver.quit();
        }
    }
}
