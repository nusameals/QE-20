package starter.user;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class Login extends PageObject {
    private By UsernameField(){
        return By.xpath("//input[@id='input-18']");
    }
    private By PasswordField(){
        return By.xpath("//input[@id='input-21']");
    }
    private By SigInButton(){
        return By.xpath("//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']");
    }

    private By errorMessage(){
        return By.xpath("//div[@class='v-alert v-sheet theme--light elevation-2 v-alert--border v-alert--border-top']");
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

