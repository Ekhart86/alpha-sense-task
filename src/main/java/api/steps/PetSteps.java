package api.steps;

import api.models.pet.Pet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import util.ContextKey;
import util.TestContext;

import static org.junit.Assert.assertEquals;

public class PetSteps extends Beans {

    @When("send request for adding new Pet to the store with parameters:")
    public void sendRequestToAddNewPetToTheStore(Pet pet) {
        Response response = petController.postNewPet(pet);
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    @When("add a new pet with random parameters to the store")
    public void postAddNewPetWithRandomParametersToTheStore() {
        Pet randomPet = new Pet();
        Response response = petController.postNewPet(randomPet);
        response.then().statusCode(200);
        TestContext.setContext(ContextKey.PET, randomPet);
    }

    @When("delete the created Pet")
    public void deleteTheCreatedPet() {
        Pet createdPet = TestContext.getContext(ContextKey.PET);
        Response response = petController.deletePetById(createdPet.getId());
        response.then().statusCode(200);
    }

    @When("send request for Pet removal by petId {int}")
    public void sendRequestForPetRemovalById(int petId) {
        Response response = petController.deletePetById(petId);
        TestContext.setContext(ContextKey.API_RESPONSE, response);
    }

    @Then("created Pet exists in the app")
    public void createdPetExistsInApp() {
        Pet createdPet = TestContext.getContext(ContextKey.PET);
        Response response = petController.getPetById(createdPet.getId());
        response.then().statusCode(200);
        assertEquals("Created Pet is incorrect.", createdPet, response.as(Pet.class));
    }

    @Then("deleted Pet no longer exists in the app")
    public void deletedPetNoLongerExistsInTheApp() {
        Pet deletedPet = TestContext.getContext(ContextKey.PET);
        Response response = petController.getPetById(deletedPet.getId());
        response.then().statusCode(404);
    }

}
