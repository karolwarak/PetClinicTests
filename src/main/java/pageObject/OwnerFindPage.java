package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waits.CustomWait;

public class OwnerFindPage {

    private WebDriver driver;
    private CustomWait waits;

    @FindBy(id = "lastName")
    private WebElement lastNameFieldElement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement findOwnerButton;

    @FindBy(xpath = "//a[@href='/owners/new']")
    private WebElement addOwnerButton;

    public OwnerFindPage(WebDriver driver){
        this.driver = driver;
        waits = new CustomWait(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchOwnerByLastName(){
        lastNameFieldElement.sendKeys("Franklin");
        findOwnerButton.click();
    }

    public void clickAddOwner(){
        addOwnerButton.click();
    }
}
