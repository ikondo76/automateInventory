package Tests;

import Pages.*;
import Utils.BrowserFactory;
import Utils.TakeScreenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected TakeScreenshots takeScreenshots;
    protected DashBoardPage dashBoardPage;
    protected InvoiceHistoryPage invoiceHistoryPage;
    protected OrderDetailsPage orderDetailsPage;
    protected WebElement learnTab;

    @BeforeClass
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        driver = BrowserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/",headless);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        invoiceHistoryPage = new InvoiceHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        dashBoardPage = new DashBoardPage(driver);


        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, dashBoardPage);
        PageFactory.initElements(driver, invoiceHistoryPage);
        PageFactory.initElements(driver, orderDetailsPage);


        takeScreenshots = new TakeScreenshots();

        learnTab = dashBoardPage.learnMenu;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
