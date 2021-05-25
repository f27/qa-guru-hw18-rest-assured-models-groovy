package specs;

import helpers.ConfigHelper;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static filters.LogFilter.filters;
import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri(ConfigHelper.getApiBaseURL())
            .basePath(ConfigHelper.getApiBasePath())
            .contentType(ContentType.JSON)
            .filter(filters().withCustomTemplates())
            .log().all();
}
