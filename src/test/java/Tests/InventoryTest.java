package Tests;

import Utils.ReadFromFile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InventoryTest extends Base{

    @Test
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
        dashBoardPage.navigateTolearningMaterials();

    }


    @Test(dependsOnMethods = "navigateTolearningMaterials")
    public void clickWebAutomationAdvance() {
        practicePage.clickWebAutomationAdvance();
        takeScreenshots.takeSnapShots(driver, "inventoryFormScreenshot001");
    }

    @Test(dependsOnMethods = "clickWebAutomationAdvance")
    public void verifyInventoryFormIsDisplayed() {
        practicePage.verifyInventoryFormIsDisplayed();
        takeScreenshots.takeSnapShots(driver, "inventoryFormScreenshot002");
    }
    @Test(dependsOnMethods = "verifyInventoryFormIsDisplayed")
    public void clickInventoryFormRequirements() {
        practicePage.clickInventoryFormRequirements();
    }


    @Test(dependsOnMethods = "clickInventoryFormRequirements")
    public void selectPhone() {
        practicePage.selectPhone();
        practicePage.selectIphoneBrand();
    }

    @Test(dependsOnMethods = "selectPhone")
    public void select128GB() {
        practicePage.select128GB();
    }

    @Test(dependsOnMethods = "select128GB")
    public void verifyUnitPriceFor128GB() {
        practicePage.verifyUnitPriceFor128GB();
    }


    @Test(dependsOnMethods = "verifyUnitPriceFor128GB()")
    public void selectColor() {
        practicePage.selectColor("Blue");
    }


//    public void selectColor(String colorName) {
//        practicePage.selectColor("Blue");
//    }


    @Test(dependsOnMethods = "selectColor")
    public void verifyColorBlueIsApplied() {
        practicePage.verifyColorBlueIsApplied();
    }

    @Test(dependsOnMethods = "verifyColorBlueIsApplied")
    public void enterQuantity() {
        practicePage.enterQuantity("2");
    }


//    @Test(dependsOnMethods = "verifyColorBlueIsApplied")
//    public void enterQuantity(String qty) {
//        practicePage.enterQuantity("2");
//    }

    @Test(dependsOnMethods = "enterQuantity")
    public void verifySubtotalForQuantityTwo() {
       practicePage.verifySubtotalForQuantityTwo();
    }

    @Test(dependsOnMethods = "verifySubtotalForQuantityTwo")
    public void enterDeliveryAddress() {
        practicePage.enterDeliveryAddress("13 Test Street");
    }


    @Test(dependsOnMethods = "enterDeliveryAddress")
    public void clickNextButton() {
        practicePage.clickNextButton();
    }

    @Test(dependsOnMethods = "clickNextButton")
    public void verifyOrderPreviewIsDisplayed() {
        practicePage.verifyOrderPreviewIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyOrderPreviewIsDisplayed")
    public void selectExpressShipping() {
        practicePage.selectExpressShipping();
    }

    @Test(dependsOnMethods = "selectExpressShipping")
    public void selectOneYearWarranty() {
        practicePage.selectOneYearWarranty();
    }

    @Test(dependsOnMethods = "selectOneYearWarranty")
    public void applyDiscountCode() {
        practicePage.applyDiscountCode("SAVE10");
    }

    @Test(dependsOnMethods = "applyDiscountCode")
    public void clickConfirmPurchase() {
        practicePage.clickConfirmPurchase();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
