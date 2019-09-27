package tests.ApiTests;

import helpers.Api.TestBaseApi;
import helpers.Utils.DateUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyData;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import java.io.InputStream;
import java.util.*;

import static io.restassured.RestAssured.*;
import static tests.Endpoints.Endpoints.*;

public class PostGetPutDeleteApiTest extends TestBaseApi {

    private static String authorizationToken;
    private static String NAME_OF_BASKET = DateUtil.todayDateTime();
    /*private static Map<String, String> requestParams = new HashMap<>();*/

    @Test
    public void createAndCheckBucket() {
        //создание корзины
        /*requestParams.put("capacity", "267");
        requestParams.put("forward_url", "http://example.biz");
        requestParams.put("expand_path", "true");*/
        /*authorizationToken =*/
        ResponseBodyData data=
        given().
                    param("capacity", 267).
                    param("forward_url", "http://example.biz").
                    param("expand_path", "true").
        when().
                    post(BASE_URI + BASKETS + NAME_OF_BASKET);
       /* then().
                    extract().path("token");*/

        System.out.println("HI");
        //получение данных о ранее созданной корзине
        given().
                    header("Authorization", authorizationToken).
                    when().
                    get(API_URL + NAME_OF_BASKET).
        then().
                    statusCode(200).log().all();
    }
}
