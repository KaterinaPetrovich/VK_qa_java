package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public static final String url = "https://mail.ru/";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement loginField;

    @FindBy(xpath = "//button[@data-test-id='next-button']")
    WebElement enterPasswordButton;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath ="//button[@data-testid='enter-mail-primary']")
    WebElement loginButton;

    @FindBy(xpath =".//button[@data-test-id='submit-button']")
    WebElement submitButton;

    public MailPage login(String login, String password) {
        loginButton.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        loginField.sendKeys(login);
        enterPasswordButton.click();
        passwordField.sendKeys(password);
        submitButton.click();
        return new MailPage(driver);
    }
}
