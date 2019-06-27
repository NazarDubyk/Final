import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import objects.NotePad;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 public class NotePadTest {
    WebDriver driver;
    NotePad np;

    @Before
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         np = new NotePad(driver);
    }
    @Test
    @DisplayName("GL-184:Funct_TC_004 'Private' or 'Public' notes")
    public void calculatorTest() {
        np.open()
                .register();
        Assert.assertEquals("If you already have an account, you can login below", "If you already have an account, you can login below");

        np.enterEmail("nazdubyk@gmail.com")
                .enterPassword("asd")
                .clickPublicNote()
                .setPrivateNote()
                .close();
        Assert.assertEquals("Private Note", np.checkPrivateMode());

        np.setTitle("My New Note")
                .save();

    }
    @After
    public void closeBrowser() { driver.quit(); } }


