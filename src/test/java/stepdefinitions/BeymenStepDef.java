package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BeymenPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class BeymenStepDef {
    BeymenPage beymenPage = new BeymenPage();
    Actions actions = new Actions(Driver.getDriver());
    String urunFiyati;
    String urunSepetfiyati;
    String excelPath = "src/test/resources/testdata/Testinium.xlsx";

    @Given("Kullanici {string} sitesini acar")
    public void kullanici_sitesini_acar(String url) {
        Driver.getDriver().get(url);

        beymenPage.cerezKabulButon.click();
        beymenPage.erkekSecimButonu.click();
   /*     try {
            beymenPage.updatesNoThanksButon.click();
        }catch (Exception e) {
            System.out.println("Updates butonu bulunamadı");
        } */

    }

    @Then("Ana sayfanin acildigini dogrular")
    public void ana_sayfanin_acildigini_dogrular() {
        Assert.assertTrue(beymenPage.beymenLogo.isDisplayed());
    }

    @When("Kullanici arama kutucuguna Excel dosyasindan {string} hucresindeki {string} kelimesini girer")
    public void kullanici_arama_kutucuguna_excel_dosyasindan_hucresindeki_kelimesini_girer(String string, String string2) {
        try {
            beymenPage.aramaKutusu.click();
            String searchData = ReusableMethods.getDataFromExcel(excelPath, 1, 1);
            beymenPage.aramaKutusuYeni.sendKeys(searchData);
        } catch (Exception e) {

        }


    }

    @When("Kullanici arama kutucuguna girilen {string} kelimesini siler")
    public void kullanici_arama_kutucuguna_girilen_kelimesini_siler(String string) {
        beymenPage.aramaKutusuYeni.sendKeys(Keys.CONTROL + "a");
        beymenPage.aramaKutusuYeni.sendKeys(Keys.DELETE);
    }

    @When("Kullanici arama kutucuguna Excel den {string} hucresindeki {string} kelimesini girer")
    public void kullanici_arama_kutucuguna_excel_den_hucresindeki_kelimesini_girer(String string, String string2) {
        try {
            String searchData = ReusableMethods.getDataFromExcel(excelPath, 1, 2);
            beymenPage.aramaKutusuYeni.sendKeys(searchData);
        } catch (Exception e) {

        }

    }

    @When("Kullanici klavye uzerinden {string} tusuna basar")
    public void kullanici_klavye_uzerinden_tusuna_basar(String string) {
        beymenPage.aramaKutusuYeni.sendKeys(Keys.ENTER);
    }

    @Then("Sonuclara gore sergilenen urunlerden rastgele bir urun secilir")
    public void sonuclara_gore_sergilenen_urunlerden_rastgele_bir_urun_secilir() {
        actions.moveToElement(beymenPage.rastgeleUrunSec).perform();
        beymenPage.rastgeleUrunSec.click();

    }

    @Then("Secilen urunun bilgisi ve tutar bilgisi {string} dosyasina yazilir")
    public void secilen_urunun_bilgisi_ve_tutar_bilgisi_dosyasina_yazilir(String string) {
        String urunBilgisi = beymenPage.urunBilgisi.getText();
        urunFiyati = beymenPage.urunFiyati.getText();
        ReusableMethods.yazUrunBilgileri(urunBilgisi, urunFiyati);
    }

    @When("Secilen urun sepete eklenir")
    public void secilen_urun_sepete_eklenir() {
        beymenPage.urunBedenSecim.click();
        beymenPage.sepeteEkleButon.click();
    }

    @Then("Urun sayfasindaki fiyat ile sepetteki fiyatin dogrulugu karsilastirilir")
    public void urun_sayfasindaki_fiyat_ile_sepetteki_fiyatin_dogrulugu_karsilastirilir() {
        beymenPage.sepeteGitButon.click();
        urunSepetfiyati = beymenPage.sepetFiyati.getText();
        double urunFiyat = ReusableMethods.fiyatFormatla(urunFiyati);
        double urunSepetfiy = ReusableMethods.fiyatFormatla(urunSepetfiyati);
        Assert.assertEquals(urunFiyat, urunSepetfiy, 0.01);


    }

    @When("Kullanici sepetteki urun adedini {int}'ye cikarir")
    public void kullanici_sepetteki_urun_adedini_ye_cikarir(Integer int1) {
        beymenPage.ikinciUrunEkleButon.click();
        beymenPage.ikinciUrunEkleOptions2.click();
    }

    @Then("Urun adedinin {int} oldugu dogrulanir")
    public void urun_adedinin_oldugu_dogrulanir(Integer int1) throws InterruptedException {
        beymenPage.sepetguncellemeKapat.click();
        String urunadet2 = beymenPage.urunAdedi2.getText();
        Assert.assertTrue(urunadet2.contains("2 adet"));
    }

    @When("Kullanici urunu sepetten siler")
    public void kullanici_urunu_sepetten_siler() {
        beymenPage.sepetiSilButonu.click();
    }

    @Then("Sepetin bos oldugu dogrulanir")
    public void sepetin_bos_oldugu_dogrulanir() throws InterruptedException {
        Thread.sleep(9000);
        Assert.assertTrue(beymenPage.sepetBosDogrula.getText().contains("SEPETINIZDE ÜRÜN BULUNMAMAKTADIR"));
    }

}
