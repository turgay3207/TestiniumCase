package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BeymenPage {
    public BeymenPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cerezKabulButon;

    @FindBy(id = "genderManButton")
    public WebElement erkekSecimButonu;

    @FindBy(xpath = "//img[@alt='Beymen']")
    public WebElement beymenLogo;
    @FindBy(xpath = "//input[@class='o-header__search--input']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//input[@id='o-searchSuggestion__input']")
    public WebElement aramaKutusuYeni;

    @FindBy(xpath = "//span[contains(text(),'Deve Tüyü Dış Gömlek')]")
    public WebElement rastgeleUrunSec;

    @FindBy(xpath = "//div[@class='m-price__lastPrice']")
    public WebElement urunFiyati;

    @FindBy(xpath = "//span[@class='o-productDetail__description']")
    public WebElement urunBilgisi;

    @FindBy(id = "addBasket")
    public WebElement sepeteEkleButon;
    @FindBy(xpath = "//span[@class='m-variation__item -criticalStock']")
    public WebElement urunBedenSecim;
    @FindBy(xpath = "//button[normalize-space()='Sepete Git']")
    public WebElement sepeteGitButon;

    @FindBy(xpath = "//span[@class='m-orderSummary__value'][normalize-space()='6.295,00 TL']")
    public WebElement sepetFiyati;

    @FindBy(xpath = "//select[@id='quantitySelect0-key-0']")
    public WebElement ikinciUrunEkleButon;

    @FindBy(xpath = "//*[@id=\"quantitySelect0-key-0\"]/option[2]")
    public WebElement ikinciUrunEkleOptions2;

    @FindBy(id = "quantitySelect0-key-0")
    public WebElement urunAdedi2;

    @FindBy(xpath = "//button[@class='m-notification__close']//*[name()='svg']//*[name()='path' and contains(@fill,'#4A4A4A')]")
    public WebElement sepetguncellemeKapat;


    @FindBy(xpath = "//button[@id='removeCartItemBtn0-key-0']//*[name()='svg']")
    public WebElement sepetiSilButonu;

    @FindBy(xpath = "//strong[contains(text(),'Sepetinizde Ürün Bulunmamaktadır')]")
    public WebElement sepetBosDogrula;




}
