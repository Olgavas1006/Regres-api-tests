package tests;

import models.LoginUserLombok;
import models.UserBodyResponseLombok;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BaseSpec.request;
import static specs.BaseSpec.responseSpec;

public class CreateUserTests extends TestBase {

    @Test
    @Tag("api")
    @DisplayName("Создание пользователя")
    public void createUserTest() {
        LoginUserLombok data = new LoginUserLombok();
        data.setName("morpheus");
        data.setJob("leader");

        UserBodyResponseLombok user = step("Отправить запрос на создание пользователя", () ->
                given()
                        .spec(request)
                        .body(data)
                        .when()
                        .post("/users")
                        .then()
                        .spec(responseSpec(201))
                        .extract().as(UserBodyResponseLombok.class));

        step("Проверить имя пользователя", () ->
                assertThat(user.getName()).isEqualTo("morpheus"));

        step("Проверить должность пользователя", () ->
                assertThat(user.getJob()).isEqualTo("leader"));
    }
}
