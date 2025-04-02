package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BeymenPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class BeymenStepDef {
    BeymenPage beymenPage=new BeymenPage();
   String  excelPath="src/test/resources/testdata/Testinium.xlsx";
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
     System.out.println("******************************************0************************************************");
    }
    @When("Kullanici arama kutucuguna Excel dosyasindan {string} hucresindeki {string} kelimesini girer")
    public void kullanici_arama_kutucuguna_excel_dosyasindan_hucresindeki_kelimesini_girer(String string, String string2) {
     System.out.println("******************************************1************************************************");
     beymenPage.aramaKutusuAlani.sendKeys("arama test");
      ReusableMethods.clickWithJS(beymenPage.aramaKutusuAlani);
     System.out.println("******************************************2************************************************");
        String searchData = ReusableMethods.getDataFromExcel(excelPath,1,1);

        beymenPage.aramaKutusuAlani.sendKeys(searchData);

     System.out.println("******************************************3************************************************");
    }
    @When("Kullanici arama kutucuguna girilen {string} kelimesini siler")
    public void kullanici_arama_kutucuguna_girilen_kelimesini_siler(String string) {

    }
    @When("Kullanici klavye uzerinden {string} tusuna basar")
    public void kullanici_klavye_uzerinden_tusuna_basar(String string) {

    }
    @Then("Sonuclara gore sergilenen urunlerden rastgele bir urun secilir")
    public void sonuclara_gore_sergilenen_urunlerden_rastgele_bir_urun_secilir() {

    }
    @Then("Secilen urunun bilgisi ve tutar bilgisi {string} dosyasina yazilir")
    public void secilen_urunun_bilgisi_ve_tutar_bilgisi_dosyasina_yazilir(String string) {

    }
    @When("Secilen urun sepete eklenir")
    public void secilen_urun_sepete_eklenir() {

    }
    @Then("Urun sayfasindaki fiyat ile sepetteki fiyatin dogrulugu karsilastirilir")
    public void urun_sayfasindaki_fiyat_ile_sepetteki_fiyatin_dogrulugu_karsilastirilir() {

    }
    @When("Kullanici sepetteki urun adedini {int}'ye cikarir")
    public void kullanici_sepetteki_urun_adedini_ye_cikarir(Integer int1) {

    }
    @Then("Urun adedinin {int} oldugu dogrulanir")
    public void urun_adedinin_oldugu_dogrulanir(Integer int1) {

    }
    @When("Kullanici urunu sepetten siler")
    public void kullanici_urunu_sepetten_siler() {

    }
    @Then("Sepetin bos oldugu dogrulanir")
    public void sepetin_bos_oldugu_dogrulanir() {

    }

}
