package Tests;

import Utils.ReadFromFile;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InventoryTest extends Base{

    public void verifyHomePageIsDisplayed() {
        homePage.verifyHomePageIsDisplayed();
        takeScreenshots.takeSnapShots(driver, "HomePageScreenshot001");
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayed")
    public void clickLoginButton() {

        homePage.clickLoginButton();
        takeScreenshots.takeSnapShots(driver, "loginPageScreenshot001");
    }

    @Test(dependsOnMethods = "clickLoginButton")
    public void userEnterEmail() {

        loginPage.enterEmail(ReadFromFile.email);
        takeScreenshots.takeSnapShots(driver, "EmailAddressCapturedScreenshot001");
    }

    @Test(dependsOnMethods = "userEnterEmail")
    public void userEnterPassword() {

        loginPage.enterPassword(ReadFromFile.password);
        takeScreenshots.takeSnapShots(driver, "PasswordCapturedScreenshot001");
    }

    @Test(dependsOnMethods = "userEnterPassword")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "userClicksLoginButton")
    public void loginPageIsDisplayed(){
        loginPage.verifyLoginPageIsDisplayed();
    }

    @Test(dependsOnMethods = "loginPageIsDisplayed")
    public void clickLearnTab() {
        takeScreenshots.takeSnapShots(driver, "dashboardPageScreenshot001");
        learnTab.click();
    }

    @Test(dependsOnMethods = "clickLearnTab")
        public void navigateTolearningMaterials() {
        navigateTolearningMaterials();

    }


    @Test(dependsOnMethods = "clickLearnTab")
    public void clickWebAutomationAdvance() {
        clickWebAutomationAdvance();
        takeScreenshots.takeSnapShots(driver, "inventoryFormScreenshot001");
    }

    @Test(dependsOnMethods = "clickWebAutomationAdvance")
    public void verifyInventoryFormIsDisplayed() {
        verifyInventoryFormIsDisplayed();
        takeScreenshots.takeSnapShots(driver, "inventoryFormScreenshot002");
    }




    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
