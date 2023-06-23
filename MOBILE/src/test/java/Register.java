import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class Register {
    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid('123456')
                .setApp("/home/myapp.apk");
        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );
        try {
            WebElement button_create_account = driver.findElement(AppiumBy.xpath("//Button"));
            button_create_account.click();

            WebElement field_email = driver.findElement(AppiumBy.xpath("//Button"));
            field_email.click();
            field_email.sendKeys("test@gmail.com");

            WebElement field_password = driver.findElement(AppiumBy.xpath("//Button"));
            field_password.click();
            field_password.sendKeys("testing123");

            WebElement field_confirm_password = driver.findElement(AppiumBy.xpath("//Button"));
            field_confirm_password.click();
            field_confirm_password.sendKeys("testing123");

            WebElement button_create = driver.findElement(AppiumBy.xpath("//Button"));
            button_create.click();

            WebElement field_verif = driver.findElement(AppiumBy.xpath("//Button"));
            field_verif.click();
            field_verif.sendKeys("12345");

            WebElement button_submit = driver.findElement(AppiumBy.xpath("//Button"));
            button_submit.click();

            driver.getPageSource();

        } finally {
            driver.quit();
        }
    }
}
