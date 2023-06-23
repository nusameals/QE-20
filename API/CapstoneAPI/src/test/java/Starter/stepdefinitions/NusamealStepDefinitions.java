package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;


public class NusamealStepDefinitions {
    String baseURL = "http://testing.hopto.org/";



    @Given("{actor} call an api {string} with method {string}")
    public void callAPI(Actor actor, String path, String method) {
        actor.whoCan( CallAnApi.at( baseURL ) );

        switch (method) {
            case "GET":
                actor.attemptsTo( Get.resource( path ) );
                break;
            case "POST":
                actor.attemptsTo( Post.to( path ) );
                break;
            case "PUT":
                actor.attemptsTo( Put.to( path ) );
                break;
            case "DELETE":
                actor.attemptsTo( Delete.from( path ) );
                break;
            default:
                throw new IllegalStateException( "Unknown method" );
        }
    }

    @Then("{actor} verify status code is {int}")
    public void userVerifyStatusCodeIs(Actor actor, int statusCode) {
        Response response = SerenityRest.lastResponse();
        response.then().log().all().statusCode( statusCode );
    }

    @Given("{actor} call an api {string} with method {string} with payload below")
    public void CallAnApi(Actor actor, String path, String method, DataTable table) {
        actor.whoCan( CallAnApi.at( baseURL ) );

        // Create request body json instance
        JSONObject bodyRequest = new JSONObject();

        // Get headers
        List<List<String>> rowsList = table.asLists( String.class );
        List<String> headerlist = rowsList.get( 0 );

        // Get values
        List<Map<String, String>> rowsMap = table.asMaps( String.class, String.class );
        Map<String, String> valueList = rowsMap.get( 0 );

        for (int i = 0; i < valueList.size(); i++) {
            String key = headerlist.get( i );
            bodyRequest.put( key, valueList.get( key ) );
        }

        switch (method) {
            case "GET":
                actor.attemptsTo( Get.resource( path ) );
                break;
            case "POST":
                actor.attemptsTo( Post.to( path ).with( request -> request.body( bodyRequest ) ) );
                break;
            case "PUT":
                actor.attemptsTo( Put.to( path ).with( request -> request.body( bodyRequest ) ) );
                break;
            case "DELETE":
                actor.attemptsTo( Delete.from( path ) );
                break;
            default:
                throw new IllegalStateException( "Unknown Method" );
        }
    }

}