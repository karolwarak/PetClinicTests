package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waits.CustomWait;

public class OwnerAddNewPage {

    private WebDriver driver;
    private CustomWait waits;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressNameField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityNameField;

    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement telephoneNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addOwnerButton;

    public OwnerAddNewPage(WebDriver driver){
        this.driver = driver;
        waits = new CustomWait(driver);
        PageFactory.initElements(driver, this);
    }


}