package ui;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.OwnerFindPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

public class AddNewOwnerTest {

    private WebDriver driver;
    private HomePage homePage;
    private OwnerFindPage ownerFindPage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        ownerFindPage = new OwnerFindPage(driver);
        driver.get("http://localhost:8080/");
    }

    @Test
    public void addNewOwner(){
        homePage.clickFindOwnerLink();
        ownerFindPage.clickAddOwner();
    }
}
