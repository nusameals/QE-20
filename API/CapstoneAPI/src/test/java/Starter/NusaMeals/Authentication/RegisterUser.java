package Starter.NusaMeals.Authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterUser {
    protected static String url = "http://testing.hopto.org/register/";
    @Step("I register using the correct data")
    public String RegisterUsingTheCorrectData(){
        return url + "register";
    }
    @Step("I submit a POST request to {string} with username basmaronanta, email basmaronanta@gmail.com and password kelompok20")
    public void POSTRequestToWithusernameEmailAndPassword(){
        String alphabet = "abcdef";
        String s = RandomStringUtils.random(8, alphabet);
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "basmaronanta");
        requestBody.put("email",s + "basmaronanta@gmail.com");
        requestBody.put("password", "kelompok20");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegisterUsingTheCorrectData());
    }
    @Step("I receive valid HTTP response code register 200")
    public void ValidHTTPResponseCodeRegister(){

        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("register successfully")
    public void registerSuccessfully(){

        restAssuredThat(response -> response.statusCode(200));
    }
}
