package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage{

    public static final String url = "https://e.mail.ru/inbox";

    public WebDriver driver;
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[@data-title-shortcut='N']")
    WebElement writeEmailButton;
    @FindBy(xpath = "//a[@href='/inbox/?']")
    WebElement inboxFolder;

    public void assertPageIsOpened() {
        Assert.assertTrue("Не найден элемент [%s]".formatted(writeEmailButton), writeEmailButton.isDisplayed());
        Assert.assertTrue("Не найден элемент [%s]".formatted(inboxFolder), inboxFolder.isDisplayed());
    }
}
