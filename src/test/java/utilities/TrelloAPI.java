package utilities;
import io.restassured.response.Response;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class TrelloAPI {
    private static final String API_KEY = ConfigReader.getProperty("API_KEY");
    private static final String TOKEN = ConfigReader.getProperty("TOKEN");
    private static final String BASE_URL = ConfigReader.getProperty("BASE_URL");


    public static String createBoard(String boardName) {
        Response response = given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", boardName)
                .contentType("application/json")
                .accept("application/json")
                .post(BASE_URL + "/boards/");

        response.then().statusCode(200);
        return response.jsonPath().getString("id");
    }


    public static String createList(String boardId, String listName) {
        Response response = given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", listName)
                .queryParam("idBoard", boardId)
                .contentType("application/json")
                .accept("application/json")
                .post(BASE_URL + "/lists");

        response.then().statusCode(200);
        return response.jsonPath().getString("id");
    }




    public static String createCard(String listId, String cardName) {
        Response response = given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", cardName)
                .queryParam("idList", listId)
                .contentType("application/json")
                .accept("application/json")
                .post(BASE_URL + "/cards");

        response.then().statusCode(200);
        return response.jsonPath().getString("id");
    }


    public static List<String> getCards(String listId) {
        Response response = given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .accept("application/json")
                .get(BASE_URL + "/lists/" + listId + "/cards");

        response.then().statusCode(200);
        return response.jsonPath().getList("id");
    }


    public static void updateRandomCard(String listId, String newCardName) {
        List<String> cards = getCards(listId);
        if (cards.isEmpty()) {
            throw new RuntimeException("Güncellenecek kart bulunamadı!");
        }
        String randomCardId = cards.get(new Random().nextInt(cards.size()));

        given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .queryParam("name", newCardName)
                .contentType("application/json")
                .accept("application/json")
                .put(BASE_URL + "/cards/" + randomCardId)
                .then().statusCode(200);
    }

    public static void deleteAllCards(String listId) {
        List<String> cards = getCards(listId);
        for (String cardId : cards) {
            given()
                    .queryParam("key", API_KEY)
                    .queryParam("token", TOKEN)
                    .contentType("application/json")
                    .accept("application/json")
                    .delete(BASE_URL + "/cards/" + cardId)
                    .then().statusCode(200);
        }
    }

    public static void deleteBoard(String boardId) {
        given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .contentType("application/json")
                .accept("application/json")
                .delete(BASE_URL + "/boards/" + boardId)
                .then().statusCode(200);
    }
}
