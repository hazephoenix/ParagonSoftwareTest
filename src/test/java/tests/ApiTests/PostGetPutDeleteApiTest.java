package tests.ApiTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import helpers.Api.TestBaseApi;
import helpers.Utils.DateUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static helpers.Endpoints.Endpoints.*;

public class PostGetPutDeleteApiTest extends TestBaseApi {

    private static TokenResponse authorizationToken;
    private static String NAME_OF_BASKET = "testBasket" + DateUtil.todayDateTime();//имя корзины + timestamp

    @Test
    public void createAndCheckBucket () throws JsonProcessingException {
        //создаем body запроса
        ObjectNode body = new ObjectMapper().createObjectNode();
        body.put("capacity", 244);

        //создаем новую корзину и получаем токен авторизации
        authorizationToken =
                given().header("Content-type", ContentType.JSON).
                        body(body.toString()).
                when().
                        post(BASE_URI + BASKETS + NAME_OF_BASKET).
                then().
                        extract().response().as(TokenResponse.class);


        //используя ранее полученный токен смотрим корзину
        given().
                    header("Authorization", authorizationToken.getToken()).
                    when().
                    get(API_URL + NAME_OF_BASKET).
        then().
                    statusCode(200).log().all();

        //редактируем capacity корзины
        ObjectNode capacity = new ObjectMapper().createObjectNode();
        capacity.put("capacity", 298);

        given().
                header("Authorization", authorizationToken.getToken()).
                body(capacity.toString()).
        when().
                put(API_URL + NAME_OF_BASKET).
        then().
                statusCode(204);
        //снова смотрим
        given().
                header("Authorization", authorizationToken.getToken()).
                when().
                get(API_URL + NAME_OF_BASKET).
                then().
                statusCode(200).log().all();

        //удаляем
        given().
                header("Authorization", authorizationToken.getToken()).
                when().
                delete(API_URL + NAME_OF_BASKET).
                then().
                statusCode(204).log().all();
    }
}
