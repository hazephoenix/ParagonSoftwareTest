package BaseClasses.api.POJO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.http.ContentType;

import static BaseClasses.api.endpoints.BasketResources.*;
import static helpers.DateUtil.todayDateTime;
import static io.restassured.RestAssured.given;


public class Basket {

    private String capacity;
    private String forward_url;

    public final static String generatedBasketId = "testBasket" + todayDateTime(); // имя корзины + timestamp
    private static TokenResponse authorizationToken;


    public static void getBasket(String basketId, TokenResponse authorizationToken) {
        given().
                header("Authorization", authorizationToken.getToken()).
                when().
                get(BASKETS_API_URL + basketId).
                then().
                statusCode(200).log().all();
    }

    public static TokenResponse createBasket(String basketId, String requestBody) {
        return authorizationToken =
        given().header("Content-type", ContentType.JSON).
                body(requestBody).
                when().
                post(BASKETS_API_URL + generatedBasketId).
                then().
                extract().response().as(TokenResponse.class);
    }

    public static void updateBasket(String basketId, TokenResponse authorizationToken) {
        ObjectNode capacity = new ObjectMapper().createObjectNode();
        capacity.put("capacity", 291);
        given().
                header("Authorization", authorizationToken.getToken()).
                body(capacity.toString()).
                when().
                put(BASKETS_API_URL + basketId).
                then().
                statusCode(204).log().all();
    }

    public static void deleteBasket(String basketId, TokenResponse authorizationToken) {
        given().
                header("Authorization", authorizationToken.getToken()).
                when().
                delete(BASKETS_API_URL + basketId).
                then().
                statusCode(204).log().all();
    }

    public Basket(String capacity, String forward_url) {
        this.capacity = capacity;
        this.forward_url = forward_url;
    }


    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getForward_url() {
        return forward_url;
    }

    public void setForward_url(String forward_url) {
        this.forward_url = forward_url;
    }
}

