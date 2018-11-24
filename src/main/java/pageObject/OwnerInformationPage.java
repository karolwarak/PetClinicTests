package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waits.CustomWait;

public class OwnerInformationPage {

    private WebDriver driver;
    private CustomWait waits;

    @FindBy (xpath = "//b[contains(text(),'George Franklin')]")
    private WebElement ownerNameAndSurname;

    @FindBy (xpath = "//h2[contains(text(),'Owner Information')]")
    private WebElement ownerInformationHeader;

    public OwnerInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOwnerNameAndSurname(){
        return ownerNameAndSurname.getText();
    }

    public String getOwnerInformatonHeaderText(){ return ownerInformationHeader.getText();}
}
