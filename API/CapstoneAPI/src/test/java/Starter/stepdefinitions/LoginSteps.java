package Starter.stepdefinitions;

import Starter.NusaMeals.Authentication.Login;
import Starter.NusaMeals.Authentication.RegisterUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {
    @Steps
    Login login;
    @Steps
    RegisterUser registerUser;
    @Given("I have valid credentials")
    public void iHaveValidCredentials() {
        login.iHaveValidCredentials();
    }

    @When("I submit a POST request to {string} with email {string} and password {string}")
    public void iSubmitAPOSTRequestToWithEmailAndPassword(String endpoint, String email, String password) {
        login.iSubmitAPOSTRequestToWithEmailAndPassword();
    }

    @Then("I receive valid HTTP response code Login {int}")
    public void iShouldGetAResponseCode(int arg0) {
        login.iShouldGetAResponseCode();
    }


    @Given("I register using the correct data")
    public void iRegisterUsingTheCorrectData() {
        registerUser.RegisterUsingTheCorrectData();
    }

    @When("I submit a POST request to {string} with username {string}, email {string} and password {string}")
    public void iSubmitAPOSTRequestToWithFullnameEmailAndPassword(String endpoint, String username, String email, String password) {
        registerUser.POSTRequestToWithusernameEmailAndPassword();
    }

    @Then("I receive valid HTTP response code register {int}")
    public void iReceiveValidHTTPResponseCodeRegister(int arg0) {
        registerUser.ValidHTTPResponseCodeRegister();
    }

    @And("register successfully")
    public void registerSuccessfully() {
        registerUser.registerSuccessfully();
    }
}
