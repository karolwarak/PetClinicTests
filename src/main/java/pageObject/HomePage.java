package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waits.CustomWait;

public class HomePage {

    private WebDriver driver;
    private CustomWait waits;

    @FindBy(xpath = "//a[@title='find owners']")
    private WebElement findOwnerLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new CustomWait(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickFindOwnerLink(){
        findOwnerLink.click();
    }
}
