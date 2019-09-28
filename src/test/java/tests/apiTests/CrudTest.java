package tests.apiTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import BaseClasses.api.POJO.TokenResponse;
import org.junit.Test;

import static BaseClasses.api.POJO.Basket.*;
import static BaseClasses.api.POJO.Basket.generatedBasketId;


public class CrudTest {

    private static TokenResponse authorizationToken;
    private final static ObjectMapper mapper = new ObjectMapper();
    private static ObjectNode bodyObject;
    private static String requestBody;


    @Test
    public void crudTest () {
        //создаем body запроса
        bodyObject = mapper.createObjectNode();
        requestBody = bodyObject.put("capacity", 295).toString();

        //создаем новую корзину и получаем токен авторизации
        authorizationToken = createBasket(generatedBasketId, requestBody);

        //используя ранее полученный токен смотрим корзину
        getBasket(generatedBasketId, authorizationToken);

        //редактируем capacity корзины
        updateBasket(generatedBasketId, authorizationToken);

        //удаляем
        deleteBasket(generatedBasketId, authorizationToken);
}}
