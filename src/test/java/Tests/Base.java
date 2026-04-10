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

import java.time.Duration;

public class Base {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected TakeScreenshots takeScreenshots;
    protected DashBoardPage dashBoardPage;
    protected InvoiceHistoryPage invoiceHistoryPage;
    protected OrderDetailsPage orderDetailsPage;
    protected PracticePage practicePage;
    protected WebElement learnTab;

    @BeforeClass
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        driver = BrowserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/",headless);
        
        // Add implicit wait to handle element loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        invoiceHistoryPage = new InvoiceHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        practicePage = new PracticePage(driver);


        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, dashBoardPage);
        PageFactory.initElements(driver, invoiceHistoryPage);
        PageFactory.initElements(driver, orderDetailsPage);
        PageFactory.initElements(driver, practicePage);



        takeScreenshots = new TakeScreenshots();

        // Initialize learnTab with proper error handling
        try {
            learnTab = dashBoardPage.learnMenu;
            if (learnTab == null) {
                System.out.println("Warning: learnTab is null. It may not be initialized yet.");
            }
        } catch (Exception e) {
            System.out.println("Error initializing learnTab: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
