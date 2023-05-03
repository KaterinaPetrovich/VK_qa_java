import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MailPage;
import pages.LoginPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailTest {

    public static WebDriver driver;
    public static String login = "nastyusha.shu@mail.ru";
    public static String password = "1234qazwsx12";
    public static LoginPage mainPage;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(LoginPage.url);
        mainPage = new LoginPage(driver);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

    @Test
    public void mailLoginTest() {
        var mailPage = mainPage.login(login, password);
        wait.until(ExpectedConditions.urlContains(MailPage.url));
        mailPage.assertPageIsOpened();
    }
}

