package api.steps;

import api.models.order.Order;
import api.models.pet.Pet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import util.ContextKey;
import util.TestContext;

import static org.junit.Assert.assertEquals;

public class StoreSteps extends Beans {

    @When("place an Order for a created Pet with parameters:")
    public void placeAnOrderForAPetWithParameters(Order order) {
        Pet createdPet = TestContext.getContext(ContextKey.PET);
        order.setPetId(createdPet.getId());
        storeController.postNewOrder(order).then().statusCode(200);
        TestContext.setContext(ContextKey.ORDER, order);
    }

    @When("send request for Order removal by orderId {int}")
    public void sendRequestForOrderRemovalByOrderId(int orderId) {
        Response response = storeController.deleteOrderById(orderId);
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    @Then("created Order exists in the app")
    public void createdPetExistsInApp() {
        Order createdOrder = TestContext.getContext(ContextKey.ORDER);
        Response response = storeController.getOrderById(createdOrder.getId());
        response.then().statusCode(200);
        assertEquals("Created Order is incorrect.", createdOrder, response.as(Order.class));
    }

}
