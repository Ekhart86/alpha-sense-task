package api.steps;

import api.endpoints.StoreEndpoints;
import api.models.order.Order;
import api.models.pet.Pet;
import api.specifications.SpecFactory;
import api.specifications.SpecType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import util.ContextKey;
import util.TestContext;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StoreSteps extends Beans {

    @When("place an Order for a created pet with parameters:")
    public void placeAnOrderForAPetWithParameters(Order order) {
        Pet createdPet = TestContext.getContext(ContextKey.PET);
        order.setPetId(createdPet.getId());
        given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .body(gson.toJson(order))
                .basePath(StoreEndpoints.ORDER_BASE_PATH)
                .post().then().statusCode(200);
        TestContext.setContext(ContextKey.ORDER, order);
    }

    @When("send request for Order removal by orderId {int}")
    public void sendRequestForOrderRemovalByOrderId(int orderId) {
        Response response = given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(StoreEndpoints.ORDER_BASE_PATH)
                .pathParam("orderId", orderId)
                .delete("/{orderId}");
        response.prettyPrint();
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    @Then("created Order exists in the app")
    public void createdPetExistsInApp() {
        Order expectedOrder = TestContext.getContext(ContextKey.ORDER);
        Response response = given()
                .spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(StoreEndpoints.ORDER_BASE_PATH)
                .pathParam("orderId", expectedOrder.getId())
                .get("/{orderId}");
        response.prettyPrint();
        response.then().statusCode(200);
        assertEquals("Created Pet is incorrect.", expectedOrder, response.as(Order.class));
    }

}
