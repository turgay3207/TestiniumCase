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
    @FindBy(xpath = "//div[@class='dn-slide-buttons horizontal']//button[@class='dn-slide-deny-btn'][normalize-space()='No Thanks']")
    public WebElement updatesNoThanksButon;

    @FindBy(xpath = "//img[@alt='Beymen']")
    public WebElement beymenLogo;

    @FindBy(id = "o-searchSuggestion__input")
    public WebElement aramaKutusuAlani;

/*


    @FindBy(xpath = "")
    public WebElement ;   */
}
