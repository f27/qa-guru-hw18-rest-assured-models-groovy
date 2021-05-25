package steps;

import models.User;
import models.Users;
import specs.Specs;

import static endpoints.ApiEndpoints.USERS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

public class ApiSteps {
    public User getUserById(int id) {
        return given(Specs.request)
                .when()
                .get(USERS.addPath("/{id}"), id)
                .then()
                .statusCode(200)
                .log().body()
                .extract().as(User.class);
    }

    public Users getUsersFromPage(int page) {
        return given(Specs.request)
                .queryParam("page", page)
                .get(USERS.getPath())
                .then()
                .statusCode(200)
                .extract().as(Users.class);
    }

    public void userWithEmailDomainExist(String domain) {
        given(Specs.request)
                .get(USERS.getPath())
                .then()
                .log().body()
                .statusCode(200)
                .body(String.format("data.findAll{it.email =~/.*?@%s/}.email.flatten()", domain), is(not(empty())))
                .extract().asPrettyString();
    }
}
