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
        takeScreenshots.takeSnapShots(driver, "LoginPageScreenshot001");
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
        takeScreenshots.takeSnapShots(driver, "LoginPageScreenshot001");
    }

    @Test(dependsOnMethods = "loginPageIsDisplayed")
    public void clickLearnTab() {
        takeScreenshots.takeSnapShots(driver, "DashboardPageScreenshot001");
        learnTab.click();
        takeScreenshots.takeSnapShots(driver, "LearnTabScreenshot001");
    }

    @Test(dependsOnMethods = "clickLearnTab")
        public void navigateTolearningMaterials() {
        dashBoardPage.navigateTolearningMaterials();
        takeScreenshots.takeSnapShots(driver, "LearningMaterialScreenshot001");

    }


    @Test(dependsOnMethods = "navigateTolearningMaterials")
    public void clickWebAutomationAdvance() {
        practicePage.clickWebAutomationAdvance();
        takeScreenshots.takeSnapShots(driver, "InventoryFormScreenshot001");
    }

    @Test(dependsOnMethods = "clickWebAutomationAdvance")
    public void verifyInventoryFormIsDisplayed() {
        practicePage.verifyInventoryFormIsDisplayed();
        takeScreenshots.takeSnapShots(driver, "InventoryFormScreenshot002");
    }
    @Test(dependsOnMethods = "verifyInventoryFormIsDisplayed")
    public void clickInventoryFormRequirements() {
        practicePage.clickInventoryFormRequirements();
        takeScreenshots.takeSnapShots(driver, "InventoryFormRequirementsScreenshot001");
    }


    @Test(dependsOnMethods = "clickInventoryFormRequirements")
    public void selectPhone() {
        practicePage.selectPhone();
        takeScreenshots.takeSnapShots(driver, "PhoneScreenshot001");
        practicePage.selectIphoneBrand();
        takeScreenshots.takeSnapShots(driver, "BrandScreenshot001");
    }

    @Test(dependsOnMethods = "selectPhone")
    public void select128GB() {
        practicePage.select128GB();
        takeScreenshots.takeSnapShots(driver, "Select128GBScreenshot001");
    }

    @Test(dependsOnMethods = "select128GB")
    public void verifyUnitPriceFor128GB() {
        practicePage.verifyUnitPriceFor128GB();
        takeScreenshots.takeSnapShots(driver, "VerifyUnitPriceScreenshot001");
    }


    @Test(dependsOnMethods = "verifyUnitPriceFor128GB()")
    public void selectColor() {
        practicePage.selectColor("Blue");
        takeScreenshots.takeSnapShots(driver, "SelectColorScreenshot001");
    }


//    public void selectColor(String colorName) {
//        practicePage.selectColor("Blue");
//    }


    @Test(dependsOnMethods = "selectColor")
    public void verifyColorBlueIsApplied() {
        practicePage.verifyColorBlueIsApplied();
        takeScreenshots.takeSnapShots(driver, "VerifyBlueColorScreenshot001");
    }

    @Test(dependsOnMethods = "verifyColorBlueIsApplied")
    public void enterQuantity() {
        practicePage.enterQuantity("2");
        takeScreenshots.takeSnapShots(driver, "EnterQuantityScreenshot001");
    }


//    @Test(dependsOnMethods = "verifyColorBlueIsApplied")
//    public void enterQuantity(String qty) {
//        practicePage.enterQuantity("2");
//    }

    @Test(dependsOnMethods = "enterQuantity")
    public void verifySubtotalForQuantityTwo() {
       practicePage.verifySubtotalForQuantityTwo();
        takeScreenshots.takeSnapShots(driver, "VerifySubTotalForQuantityTwoScreenshot001");
    }

    @Test(dependsOnMethods = "verifySubtotalForQuantityTwo")
    public void enterDeliveryAddress() {
        practicePage.enterDeliveryAddress("13 Test Street");
        takeScreenshots.takeSnapShots(driver, "EnterDeliveryAddressScreenshot001");
    }


    @Test(dependsOnMethods = "enterDeliveryAddress")
    public void clickNextButton() {
        practicePage.clickNextButton();
    }

    @Test(dependsOnMethods = "clickNextButton")
    public void verifyOrderPreviewIsDisplayed() {
        practicePage.verifyOrderPreviewIsDisplayed();
        takeScreenshots.takeSnapShots(driver, "OrderPreviewScreenshot001");
    }

    @Test(dependsOnMethods = "verifyOrderPreviewIsDisplayed")
    public void selectExpressShipping() {
        practicePage.selectExpressShipping();
        takeScreenshots.takeSnapShots(driver, "SelectShippingAddressScreenshot001");
    }

    @Test(dependsOnMethods = "selectExpressShipping")
    public void selectOneYearWarranty() {
        practicePage.selectOneYearWarranty();
        takeScreenshots.takeSnapShots(driver, "SelectOneYearWarrantyScreenshot001");
    }

    @Test(dependsOnMethods = "selectOneYearWarranty")
    public void applyDiscountCode() {
        practicePage.applyDiscountCode("SAVE10");
        takeScreenshots.takeSnapShots(driver, "ApplyDiscountScreenshot001");
    }

    @Test(dependsOnMethods = "applyDiscountCode")
    public void clickConfirmPurchase() {
        practicePage.clickConfirmPurchase();
        takeScreenshots.takeSnapShots(driver, "ConfirmedPurchaseScreenshot001");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
