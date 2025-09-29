package tests;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BaseSpec.request;
import static specs.BaseSpec.responseSpec;

public class UpdateUserDataTests extends TestBase {

    @Test
    @Tag("api")
    @DisplayName("Обновление данных пользователя")
    public void updateUserTest() {
        LoginUserLombok data = new LoginUserLombok();
        data.setName("morpheus");
        data.setJob("zion resident");

        UserBodyResponseLombok user = step("Отправить запрос на обновление данных пользователя", () ->
                given()
                        .spec(request)
                        .body(data)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(UserBodyResponseLombok.class));

        step("Проверить имя пользователя", () ->
                assertThat(user.getName()).isEqualTo("morpheus"));

        step("Проверить изменение должности пользователя", () ->
                assertThat(user.getJob()).isEqualTo("zion resident"));

    }
}
