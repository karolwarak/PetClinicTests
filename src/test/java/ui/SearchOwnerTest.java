package ui;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.FindOwnerPage;
import pageObject.HomePage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

public class SearchOwnerTest {

    private WebDriver driver;
    private HomePage homePage;
    private FindOwnerPage findOwnerPage;


    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        findOwnerPage = new FindOwnerPage(driver);
        driver.get("http://localhost:8080/");
    }

    @Test
    public void findOwner(){
        homePage.clickFindOwnerLink();
        findOwnerPage.searchOwnerByLastName();

        // nie wyszukuje przycisku find owner
    }
}
