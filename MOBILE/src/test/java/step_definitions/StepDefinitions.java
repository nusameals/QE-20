package step_definitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step_definitions.DriverHook.driver;

public class StepDefinitions {

    @Given("User open Nusameals app")
    public void userOpenNusamealsApp() {
        assertEquals("app-release.apk", driver.getCurrentPackage());
    }

    @And("User input Username {string}")
    public void userInputUsername(String arg0) {
        WebElement fieldusername = driver.findElement(AppiumBy.xpath("//android.widget.button"));
        fieldusername.click();
        fieldusername.sendKeys("Basmaronanta");
    }

    @And("User input Password {string}")
    public void userInputPassword(String arg0) {
        WebElement fieldpassword = driver.findElement(AppiumBy.xpath("//android.widget.button"));
        fieldpassword.click();
        fieldpassword.sendKeys("mylove366");
    }

    @And("User click Login button")
    public void userClickLoginButton() {
        WebElement LoginButton = driver.findElement(AppiumBy.id("//android.widget.button"));
        LoginButton.click();
    }

    @Then("User see login Success message")
    public void userSeeLoginSuccessMessage() {
        assertEquals("Login Success", driver.getCurrentPackage());
    }

    @Then("User see login Failed message")
    public void userSeeLoginFailedMessage() {
        assertEquals("Login Failed", driver.getCurrentPackage());
    }

    @And("User click create account")
    public void userClickCreateAccount() {
        WebElement CreateAccountButton = driver.findElement(AppiumBy.id("//android.widget.button"));
        CreateAccountButton.click();
    }

    @And("User input Email {string}")
    public void userInputEmail(String arg0) {
        WebElement fieldEmail = driver.findElement(AppiumBy.xpath("//android.widget.button"));
        fieldEmail.click();
        fieldEmail.sendKeys("basmaronanta@gmail.com");
    }

    @And("User input Confirm Password {string}")
    public void userInputConfirmPassword(String arg0) {
        WebElement fieldconfpassword = driver.findElement(AppiumBy.xpath("//android.widget.button"));
        fieldconfpassword.click();
        fieldconfpassword.sendKeys("test123");
    }

    @And("User click Create Account button")
    public void userClickCreateAccountButton() {
        WebElement CreateAccountSubmitButton = driver.findElement(AppiumBy.id("//android.widget.button"));
        CreateAccountSubmitButton.click();
    }

    @Then("User see Create Account Success message")
    public void userSeeCreateAccountSuccessMessage() {
        assertEquals("Register Success", driver.getCurrentPackage());
    }

    @Then("User see Insert a valid email message")
    public void userSeeInsertAValidEmailMessage() {
        assertEquals("Email Invalid", driver.getCurrentPackage());
    }

    @And("User input Username without capital letters {string}")
    public void userInputUsernameWithoutCapitalLetters(String arg0) {
        WebElement invalidusername = driver.findElement(AppiumBy.xpath("//android.widget.button"));
        invalidusername.click();
        invalidusername.sendKeys("basmaronanta");
    }
}
