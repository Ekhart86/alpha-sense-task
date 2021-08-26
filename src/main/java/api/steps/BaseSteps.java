package api.steps;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import util.ContextKey;
import util.TestContext;


public class BaseSteps extends Beans {

    @Then("response status code is {int}")
    public void verifyResponseStatusCode(int statusCode) {
        Response response = TestContext.getContext(ContextKey.API_RESPONSE);
        response.then().statusCode(statusCode);
    }

}
