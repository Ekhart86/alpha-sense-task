package api.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import properties.Properties;

import java.nio.charset.StandardCharsets;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class SpecFactory {

    public static RequestSpecification getSpecification(SpecType type) {
        RequestSpecification requestSpecification;
        if (type == SpecType.DEFAULT) {
            requestSpecification = new RequestSpecBuilder()
                    .setConfig(newConfig().encoderConfig(encoderConfig().defaultContentCharset(StandardCharsets.UTF_8)))
                    .setBaseUri(System.getProperty(Properties.BASE_URL))
                    .setRelaxedHTTPSValidation()
                    .addFilter(new AllureRestAssured())
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    .log(LogDetail.ALL).build();
        } else {
            throw new IllegalArgumentException("Wrong specification type: " + type);
        }
        return requestSpecification;
    }

}
