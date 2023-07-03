package starter.user;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class Login extends PageObject {
    private By UsernameField(){
        return By.xpath("//*[@id=\"login-form_email_or_username\"]");
    }
    private By PasswordField(){
        return By.xpath("//*[@id=\"login-form_password\"]");
    }
    private By SigInButton(){
        return By.xpath("/html/body/div/div/div/div/div/div[2]/div/form/button/span");
    }

    private By errorMessage(){
        return By.xpath("/html/body/div/div/div/div/div/div[2]/div/form/button/span");
    }


    @Step
    public static OpenUrl url(String targetUrl){
        return new OpenUrl(targetUrl);
    }
    @Step
    public void validateOnLoginPage(){
        $(SigInButton()).isDisplayed();
    }
    @Step
    public void inputUsername(String Username){
        $(UsernameField()).type(Username);
    }
    @Step
    public void inputPassword(String Password){
        $(PasswordField()).type(Password);
    }
    @Step
    public void ClickSigInButton(){
        $(SigInButton()).click();
    }

    @Step
    public boolean validateErrorMessageDisplayed(){
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean validateEqualErrorMessage(String message){
        return $(errorMessage()).getText().equalsIgnoreCase(message);
    }

}

