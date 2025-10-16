package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginBodyModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.BaseSpec.request;
import static specs.BaseSpec.responseSpec;

@Owner("Olgavas1006")
@Feature("POST запрос входа в систему")
public class LoginTests extends TestBase{
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешный вход в систему")
    void successfulLoginTest() {
        LoginBodyModel authData = new LoginBodyModel("eve.holt@reqres.in", "cityslicka");

        LoginResponseModel responce = step("Вход в систему", () ->
                given(request)
                        .body(authData)
                        .when()
                        .post("/login")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(LoginResponseModel.class));

        step("Проверка token", () ->
                assertEquals("QpwL5tke4Pnpja7X4", responce.getToken()));
    }
}
