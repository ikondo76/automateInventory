package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InvoiceHistoryPage {
    WebDriver driver;

    @FindBy(id = "invoice-history-title")
    private WebElement invoiceHistory;

    @FindBy(xpath = "//*[@id=\"view-invoice-INV-1775832982674\"]")
    private WebElement viewButton;

    public InvoiceHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyInvoiceHistoryPageIsDisplayed() {
        Assert.assertTrue(invoiceHistory.isDisplayed(),
                "Invoice History page is NOT displayed");
    }

    public void clickViewButton() {
        viewButton.click();
    }
}
