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


    //Find the element "Web Automation Advance"
    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]/span[2]")
    private WebElement webAutomationAdvanceCard;

    //Find the element 'Inventory Form Title'
    @FindBy(id = "inventory-title")
    private WebElement inventoryForm;

    //Find the element 'Inventory Form Requirements'
    @FindBy(xpath = "//*[@id=\"assessment-instructions\"]/summary")
    private WebElement inventoryFormRequirements;

    //Find the element 'Device Type'
    @FindBy(id = "deviceType")
    private WebElement deviceTypeDropdown;

    //Find the element 'Phone'
    @FindBy(xpath = "//div[contains(text(),'Phone')]")
    private WebElement phoneOption;

    //Find the element
    @FindBy(id = "brand")
    private WebElement brandDropdown;

    @FindBy(xpath = "//div[contains(text(),'Apple')]")
    private WebElement appleOption;


    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[4]/div/label[2]/span")
    private WebElement storage128;

    @FindBy(id = "unit-price-value")
    private WebElement unitPrice;


    @FindBy(id = "color")
    private WebElement colorDropdown;

    @FindBy(xpath = "//*[@id=\"device-preview\"]/div/div/div[3]/strong[1]")
    private WebElement displayedColorText;

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(id = "subtotal-value")
    private WebElement subtotalValue;

    @FindBy(id = "address")
    private WebElement deliveryAddressInput;

    @FindBy(id = "inventory-next-btn")
    private WebElement nextButton;

    @FindBy(id = "breakdown-total-label")
    private WebElement totalLabel;

    @FindBy(id = "shipping-option-express")
    private WebElement expressShippingChoice;

    @FindBy(id = "warranty-option-1yr")
    private WebElement oneYearWarrantyChoice;

    @FindBy(id = "discount-code")
    private WebElement discountCodeInput;

    @FindBy(id = "apply-discount-btn")
    private WebElement applyButton;

    @FindBy(id = "purchase-device-btn")
    private WebElement confirmPurchaseButton;


    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateTolearningMaterials() {
        learnMenu.click();
        learningMaterials.click();
    }

    public void clickWebAutomationAdvance() {
        webAutomationAdvanceCard.click();
    }

    public void verifyInventoryFormIsDisplayed() {
        if (inventoryForm.isDisplayed()) {
            System.out.println("Inventory Form is displayed");
        } else {
            System.out.println("Inventory Form is NOT displayed");
        }
    }

    public void clickInventoryFormRequirements() {
        inventoryFormRequirements.click();
    }

    public void selectDeviceType(String deviceType) {
        Select select = new Select(deviceTypeDropdown);
        select.selectByVisibleText(deviceType);
    }

    public void selectPhone() {
        deviceTypeDropdown.click();
        phoneOption.click();
    }

    public void selectIphoneBrand() {
        brandDropdown.click();
        appleOption.click();
    }

    public void select128GB() {
        storage128.click();
    }

    public void verifyUnitPriceFor128GB() {
        String expectedPrice = "R480.00";
        String actualPrice = unitPrice.getText().trim();
        Assert.assertEquals(actualPrice, expectedPrice,
                "Unit price for 128GB is incorrect");
    }

    public void selectColor(String colorName) {
        Select select = new Select(colorDropdown);
        select.selectByVisibleText(colorName);
    }

    public void verifyColorBlueIsApplied() {
        String expected = "blue";
        String actual = displayedColorText.getText().toLowerCase();

        Assert.assertTrue(actual.contains(expected),
                "Selected color was not applied. Expected: blue, but got: " + actual);
    }

    public void enterQuantity(String qty) {
        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }

    public void verifySubtotalForQuantityTwo() {
        String expectedSubtotal = "R960.00";

        // Read the actual subtotal text
        String actualSubtotal = subtotalValue.getText().trim();

        Assert.assertEquals(actualSubtotal, expectedSubtotal,
                "Subtotal is incorrect when quantity is 2");
    }

    public void enterDeliveryAddress(String address) {
        deliveryAddressInput.clear();
        deliveryAddressInput.sendKeys(address);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void verifyOrderPreviewIsDisplayed() {
        Assert.assertTrue(totalLabel.isDisplayed(),
                "Order Preview section is NOT displayed");
    }

    public void selectExpressShipping() {
        expressShippingChoice.click();
    }

    public void selectOneYearWarranty() {
        oneYearWarrantyChoice.click();
    }

    public void applyDiscountCode(String code) {
        discountCodeInput.clear();
        discountCodeInput.sendKeys(code);
        applyButton.click();
    }

    public void clickConfirmPurchase() {
        confirmPurchaseButton.click();
    }
}
