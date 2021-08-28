package api.controllers;

import api.endpoints.StoreEndpoints;
import api.models.order.Order;
import api.specifications.SpecFactory;
import api.specifications.SpecType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreController extends BaseController {

    public Response getOrderById(Integer orderId) {
        Response response = given()
                .spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(StoreEndpoints.ORDER_BASE_PATH)
                .pathParam("orderId", orderId)
                .get("/{orderId}");
        response.prettyPrint();
        return response;
    }

    public Response deleteOrderById(Integer orderId) {
        Response response = given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(StoreEndpoints.ORDER_BASE_PATH)
                .pathParam("orderId", orderId)
                .delete("/{orderId}");
        response.prettyPrint();
        return response;
    }

    public Response postNewOrder(Order order) {
        Response response = given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .body(gson.toJson(order))
                .basePath(StoreEndpoints.ORDER_BASE_PATH)
                .post();
        response.prettyPrint();
        return response;
    }

}
