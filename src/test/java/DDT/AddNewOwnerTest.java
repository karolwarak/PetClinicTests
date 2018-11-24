package DDT;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.OwnerAddNewPage;
import pageObject.OwnerFindPage;
import pageObject.OwnerInformationPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class AddNewOwnerTest {

    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;
    private HomePage homePage;
    private OwnerFindPage ownerFindPage;
    private OwnerAddNewPage ownerAddNewPage;
    private OwnerInformationPage ownerInformationPage;

    @DataProvider
    public static Object[][] testDataForAddNewOwner() {
        return new String[][]{
                new String[]{"Jan", "Malinowski", "Chlopska 14B/33", "Gdansk", "123456789"},
                new String[]{"Jan1", "Malinowski1", "Chlopska 14B/32", "Gdansk1", "123456788"},
                new String[]{"Jan2", "Malinowski2", "Chlopska 14B/31", "Gdansk2", "123456787"},
                new String[]{"Jan3", "Malinowski3", "Chlopska 14B/30", "Gdansk3", "123456786"}
        };
    }

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        ownerFindPage = new OwnerFindPage(driver);
        ownerAddNewPage = new OwnerAddNewPage(driver);
        ownerInformationPage = new OwnerInformationPage(driver);
        driver.get(PAGE_URL);
    }

    @Test
    @UseDataProvider("testDataForAddNewOwner")
    public void addNewOwner(String firstName, String lastName, String address,
                            String city, String telephone) {
        homePage.clickFindOwnerLink();
        ownerFindPage.clickAddOwner();
        ownerAddNewPage.inputOwnerInformationForm(firstName, lastName, address,
                city, telephone);
        ownerAddNewPage.clickAddOwnerAfterFillInForm();

        assertThat(ownerInformationPage.getOwnerInformatonHeaderText())
                .as("User was not created")
                .isEqualTo("Owner Information");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
