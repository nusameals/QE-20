import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class Forgot_Password {
    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid('123456')
                .setApp("/home/myapp.apk");
        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );
        try {
            WebElement button_forget_password = driver.findElement(AppiumBy.xpath("//Button"));
            button_forget_password.click();

            WebElement field_email = driver.findElement(AppiumBy.xpath("//Button"));
            field_email.click();
            field_email.sendKeys("test@gmail.com");

            WebElement button_submit = driver.findElement(AppiumBy.xpath("//Button"));
            button_submit.click();

            WebElement field_verif = driver.findElement(AppiumBy.xpath("//Button"));
            field_verif.click();
            field_verif.sendKeys("12345");

            WebElement button_submit1 = driver.findElement(AppiumBy.xpath("//Button"));
            button_submit1.click();

            WebElement field_password = driver.findElement(AppiumBy.xpath("//Button"));
            field_password.click();
            field_password.sendKeys("testing123");

            WebElement field_new_password = driver.findElement(AppiumBy.xpath("//Button"));
            field_new_password.click();
            field_new_password.sendKeys("testing123");

            WebElement button_submit2 = driver.findElement(AppiumBy.xpath("//Button"));
            button_submit2.click();

            driver.getPageSource();

        } finally {
            driver.quit();
        }
    }
}
