package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.TrelloAPI;


public class TrelloStepDef {
    private static final Logger logger = LogManager.getLogger(BeymenStepDef.class);
    private String boardId;
    private String listId;

    @Given("Kullanici Trello API ile yeni bir {string} olusturur")
    public void kullanici_trello_apı_ile_yeni_bir_olusturur(String boardName) {
        logger.info("Board oluşturuluyor: {}", boardName);
        boardId = TrelloAPI.createBoard(boardName);
        Assert.assertNotNull("Board ID null olamaz!", boardId);

        listId = TrelloAPI.createList(boardId, "Test List");
        Assert.assertNotNull("Liste ID null olamaz!", listId);
        logger.info("Board oluşturuldu: {}", boardId);
    }


    @When("Kullanici bu board'a {string} ve {string} isimli iki kart ekler")
    public void kullanici_bu_board_a_ve_isimli_iki_kart_ekler(String string, String string2) {
        logger.info("Board'a kartlar ekleniyor: {} ve {}", string, string2);
        String card1Id = TrelloAPI.createCard(listId, string);
        Assert.assertNotNull("Kart 1 ID null olamaz!", card1Id);
        logger.info("Card 1 kartı oluşturuldu: {}", string);

        String card2Id = TrelloAPI.createCard(listId, string2);
        Assert.assertNotNull("Kart 2 ID null olamaz!", card2Id);
        logger.info("Card 2 kartı oluşturuldu: {}", string2);
    }

    @And("Kullanici rastgele bir karti {string} olarak gunceller")
    public void kullaniciRastgeleBirKartiOlarakGunceller(String arg0) {
        logger.info("Kart güncelleniyor: {}", arg0);
        TrelloAPI.updateRandomCard(listId, arg0);
    }

    @When("Kullanici tum kartlari siler")
    public void kullanici_tum_kartlari_siler() {
        logger.info("Board'daki tüm kartlar siliniyor...");
        TrelloAPI.deleteAllCards(listId);
    }

    @When("Kullanici board'u siler")
    public void kullanici_board_u_siler() {
        logger.info("Board siliniyor: {}", boardId);
        TrelloAPI.deleteBoard(boardId);
        logger.info("Board silindi: {}", boardId);
    }


}
