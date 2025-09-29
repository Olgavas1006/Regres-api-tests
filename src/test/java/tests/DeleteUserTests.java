package tests;

import models.UsersListResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BaseSpec.request;
import static specs.BaseSpec.responseSpec;

public class DeleteUserTests extends TestBase{

    @Test
    @Tag("api")
    @DisplayName("Удаления  пользователя")
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
