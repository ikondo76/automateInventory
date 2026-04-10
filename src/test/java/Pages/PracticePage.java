package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PracticePage {

    WebDriver driver;


    //Find the element "Web Automation Advance"
    @FindBy(xpath = "//button[.//span[contains(text(),'Web Automation Advance')]]")
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
    @FindBy(xpath = "//*[@id=\"deviceType\"]/option[2]")
    private WebElement phoneOption;

    //Find the element
    @FindBy(id = "brand")
    private WebElement brandDropdown;

    @FindBy(xpath = "//*[@id=\"brand\"]/option[3]")
    private WebElement appleOption;


    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[4]/div/label[2]/span")
    private WebElement storage128;

    @FindBy(id = "unit-price-value")
    private WebElement unitPrice;


    @FindBy(xpath = "//*[@id=\"color\"]/option[4]")
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

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPracticePageIsDisplayed() {
        String expectedURl = "https://ndosisimplifiedautomation.vercel.app/#practice";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURl)) {
            System.out.println("Practice page is displayed");
        } else {
            System.out.println("Practice page NOT displayed. Actual URL: " + actualURL);
        }
    }

    public void clickWebAutomationAdvance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(webAutomationAdvanceCard));
        webAutomationAdvanceCard.click();
    }

    public void verifyInventoryFormIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(inventoryForm));
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
