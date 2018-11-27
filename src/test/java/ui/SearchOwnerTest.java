package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.OwnerFindPage;
import pageObject.HomePage;
import pageObject.OwnerInformationPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchOwnerTest {

    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;
    private HomePage homePage;
    private OwnerFindPage ownerFindPage;
    private OwnerInformationPage ownerInformationPage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        ownerFindPage = new OwnerFindPage(driver);
        ownerInformationPage = new OwnerInformationPage(driver);
        driver.get(PAGE_URL);
    }

    @Test
    public void findOwner() {
        homePage.clickFindOwnerLink();
        ownerFindPage.searchOwnerByLastName();

        assertThat(ownerInformationPage.getOwnerNameAndSurname())
                .as("dataGenerator.Owner Franklin was not find")
                .endsWith("Franklin");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
