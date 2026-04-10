package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utils.BrowserFactory.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DashBoardPage {
    WebDriver driver;

    //Verify that Login is successful and Dashboard is displayed

//    String expectedURl = "https://ndosisimplifiedautomation.vercel.app/#dashboard";
//    String actualURL = driver.getCurrentUrl();
//        if (actualURL.equals(expectedURl)) {
//        System.out.println("Login successful. Dashboard page is displayed");
//    }

    public void verifyDashboardPageIsDisplayed() {
        String expectedURl = "https://ndosisimplifiedautomation.vercel.app/#dashboard";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURl)) {
            System.out.println("Login successful. Dashboard page is displayed");
        } else {
            System.out.println("Dashboard page NOT displayed. Actual URL: " + actualURL);
        }
    }

    //Navigate to Learning Materials

    //Find the element "Learn"
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")
    public WebElement learnMenu;


    //Find the element "Learning Materials"
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    private WebElement learningMaterials;



    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateTolearningMaterials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(learnMenu));
        learnMenu.click();
        wait.until(visibilityOf(learningMaterials));
        learningMaterials.click();
    }


}

