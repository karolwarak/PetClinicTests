package DDT;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.OwnerAddNewPage;
import pageObject.OwnerFindPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

@RunWith(DataProviderRunner.class)
public class AddNewOwnerTest {

    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;
    private HomePage homePage;
    private OwnerFindPage ownerFindPage;
    private OwnerAddNewPage ownerAddNewPage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        ownerFindPage = new OwnerFindPage(driver);
        ownerAddNewPage = new OwnerAddNewPage(driver);
        driver.get(PAGE_URL);
    }

    @Test
    public void addNewOwner(){
        homePage.clickFindOwnerLink();
        ownerFindPage.clickAddOwner();
        ownerAddNewPage.inputOwnerInformationForm();
        ownerAddNewPage.clickAddOwnerAfterFillInForm();

        //assertThat
    }
}
