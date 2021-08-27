package api.steps;

import api.endpoints.PetEndpoints;
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

public class PetSteps extends Beans {

    @When("send request for adding new Pet to the store with parameters:")
    public void sendRequestToAddNewPetToTheStore(Pet pet) {
        Response response = given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .body(gson.toJson(pet))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .post();
        response.prettyPrint();
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    @When("add a new pet with random parameters to the store")
    public void postAddNewPetWithRandomParametersToTheStore() {
        Pet randomPet = new Pet();
        given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .body(gson.toJson(randomPet))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .post().then().log().all().statusCode(200);
        TestContext.setContext(ContextKey.PET, randomPet);
    }

    @When("delete the created Pet")
    public void deleteTheCreatedPet() {
        Pet createdPet = TestContext.getContext(ContextKey.PET);
        given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .pathParam("petId", createdPet.getId())
                .delete("/{petId}").then().log().all().statusCode(200);
    }

    @When("send request for Pet removal by petId {int}")
    public void sendRequestForPetRemovalById(int petId) {
        Response response = given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .pathParam("petId", petId)
                .delete("/{petId}");
        response.prettyPrint();
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    @Then("created Pet exists in the app")
    public void createdPetExistsInApp() {
        Pet createdPet = TestContext.getContext(ContextKey.PET);
        Response response = given()
                .spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .pathParam("petId", createdPet.getId())
                .get("/{petId}");
        response.prettyPrint();
        response.then().statusCode(200);
        assertEquals("Created Pet is incorrect.", createdPet, response.as(Pet.class));
    }

    @Then("deleted Pet no longer exists in the app")
    public void deletedPetNoLongerExistsInTheApp() {
        Pet deletedPet = TestContext.getContext(ContextKey.PET);
        given().spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .pathParam("petId", deletedPet.getId())
                .get("/{petId}").then().log().all().statusCode(404);
    }

}
