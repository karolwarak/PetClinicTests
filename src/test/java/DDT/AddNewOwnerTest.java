package DDT;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import dataGenerator.DataReader;
import dataGenerator.Owner;
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
    private static DataReader dataReader = new DataReader();

    private WebDriver driver;
    private HomePage homePage;
    private OwnerFindPage ownerFindPage;
    private OwnerAddNewPage ownerAddNewPage;
    private OwnerInformationPage ownerInformationPage;

    @DataProvider
    public static Object[][] testDataForAddNewOwner() {
        return new Object[][]{
                new Owner[] { dataReader.randomOwnerObjectFromJson() },
                new Owner[] { dataReader.randomOwnerObjectFromJson() },
                new Owner[] { dataReader.randomOwnerObjectFromJson() },
                new Owner[] { dataReader.randomOwnerObjectFromJson() },
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
    public void addNewOwner(Owner owner) {
        homePage.clickFindOwnerLink();
        ownerFindPage.clickAddOwner();
        ownerAddNewPage.inputOwnerInformationForm(owner);
        ownerAddNewPage.clickAddOwnerAfterFillInForm();

        assertThat(ownerInformationPage.getOwnerInformatonHeaderText())
                .as("User was not created")
                .isEqualTo(owner.getName() + " " + owner.getSurname());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
