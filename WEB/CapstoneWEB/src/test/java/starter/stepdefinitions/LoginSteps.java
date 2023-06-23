package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.HomePage;
import starter.user.Login;

public class LoginSteps {
    @Steps
    Login login;

    @Steps
    HomePage homePage;

    @Given("I am on the login page")
    public void onLoginPage(){
        login.openUrl("https://nusameals.netlify.app/admin");
        login.validateOnLoginPage();
    }

    @When("I enter Username {string}")
    public void enterUsernamelOnSigIn(String Username){
        login.inputUsername(Username);
    }
    @And("I enter Password {string}")
    public void enterPasswordOnLogin(String Password){
        login.inputPassword(Password);
    }
    @And("I click SigIn button")
    public void clickSigInButton(){
        login.ClickSigInButton();
    }
    @Then("I am on the home page")
    public void goToHomePage(){
//        login.openUrl("https://nusameals.netlify.app/dashboard");
       homePage.validateOnHomePage();
    }

    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String message) {
        login.validateErrorMessageDisplayed();
        login.validateEqualErrorMessage(message);
    }
}

