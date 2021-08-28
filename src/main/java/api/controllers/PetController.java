package api.controllers;

import api.endpoints.PetEndpoints;
import api.models.pet.Pet;
import api.specifications.SpecFactory;
import api.specifications.SpecType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetController extends BaseController {

    public Response getPetById(Integer petId) {
        Response response = given()
                .spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .pathParam("petId", petId)
                .get("/{petId}");
        response.prettyPrint();
        return response;
    }

    public Response postNewPet(Pet pet) {
        Response response = given()
                .spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .body(gson.toJson(pet))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .post();
        response.prettyPrint();
        return response;
    }

    public Response deletePetById(Integer petId) {
        Response response = given()
                .spec(SpecFactory.getSpecification(SpecType.DEFAULT))
                .basePath(PetEndpoints.PET_BASE_PATH)
                .pathParam("petId", petId)
                .delete("/{petId}");
        response.prettyPrint();
        return response;
    }

}
