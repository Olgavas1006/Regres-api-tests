package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BaseSpec.request;
import static specs.BaseSpec.responseSpec;

@Owner("Olgavas1006")
@Feature("Удаление пользователя")
public class DeleteUserTests extends TestBase{

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление  пользователя")
    void deleteUser() {

        step("Отправить запрос на удаление", () ->
                given()
                        .spec(request)
                        .log().uri()
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(responseSpec(204)));
    }
}
