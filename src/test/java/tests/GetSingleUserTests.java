package tests;

import models.UserDataModel;
import models.UserDataResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BaseSpec.request;
import static specs.BaseSpec.responseSpec;

public class GetSingleUserTests extends TestBase {

    @Test
    @Tag("api")
    @DisplayName("Получение данных пользователя")
    public void getSingleUserTest() {
        UserDataResponseModel response = step("Отправить запрос на получение данных", () ->
                given()
                        .spec(request)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(UserDataResponseModel.class));

        UserDataModel data = response.getData();

        step("Проверить id пользователя", () ->
                assertThat(data.getId()).isEqualTo(2));
        step("Проверить email пользователя", () ->
                assertThat(data.getEmail()).isEqualTo("janet.weaver@reqres.in"));
        step("Проверить имя пользователя", () ->
                assertThat(data.getFirstName()).isEqualTo("Janet"));
        step("Проверить фамилию пользователя", () ->
                assertThat(data.getLastName()).isEqualTo("Weaver"));
    }
}
