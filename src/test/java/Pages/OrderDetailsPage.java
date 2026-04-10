package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/div[1]/h4")
    private WebElement orderSuccessToast;

    @FindBy(id = "view-history-btn")
    private WebElement viewInvoiceButton;

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyOrderSuccessToastIsDisplayed() {
        Assert.assertTrue(orderSuccessToast.isDisplayed(),
                "Success toast is IS displayed");
    }
    public void clickViewInvoice() {
        viewInvoiceButton.click();
    }


}
