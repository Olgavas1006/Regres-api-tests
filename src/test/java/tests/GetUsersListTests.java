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

public class GetUsersListTests extends TestBase{

    @Test
    @Tag("api")
    @DisplayName("Получение списка пользователей")
    public void getUsersListTest() {
        UsersListResponse response = step("Отправить запрос на получение списка пользователей", () ->
                given()
                        .spec(request)
                        .when()
                        .queryParam("page", "2")
                        .get("/users")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(UsersListResponse.class));

        step("Проверить параметры", () -> {
            assertThat(response.getPage()).isEqualTo(2);
            assertThat(response.getPer_page()).isEqualTo(6);
            assertThat(response.getTotal()).isEqualTo(12);
            assertThat(response.getTotal_pages()).isEqualTo(2);
        });

    }
}
