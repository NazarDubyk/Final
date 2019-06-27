package objects;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotePad {

    private static final By registerTitleButton = By.cssSelector(".register");
    private static final By emailField = By.id("loginEmail");
    private static final By passwordField = By.xpath("//input[@value='login']/..//input[@type='password']");
    private static final By loginButton = By.cssSelector("#submit");
    private static final By PublicButton = By.cssSelector("#noteAccessText");
    private static final By PrivateButton = By.xpath("//*[@id=\"noteAccessText\"]");
    private static final By CloseButton = By.xpath("//*[@id='manageNoteAccessModal']/div/div/div[3]/button");
    private static final By noteTitle = By.id("edit_title");
    private static final By saveTitleButton = By.xpath("//*[@id='btnSaveNote']");
    private static final By PrivateButtonIs = By.cssSelector("#noteAccessText");
    private WebDriver driver;
    private WebDriverWait wait;

    public NotePad(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }
    @Step
    public NotePad open()
    {
        driver.get("https://anotepad.com/");
        return this;
    }
    @Step
    public NotePad register() {
        driver.findElement(registerTitleButton).click();
        return this;
    }
        @Step
    public NotePad enterEmail(String email) {
        driver.findElement(emailField).sendKeys("nazdubyk@gmail.com");
        return this;
    }
    @Step
    public NotePad enterPassword(String password) {
        driver.findElement(passwordField).sendKeys("asd");
        return this;
    }
    @Step
    public NotePad login() {
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("edit_title"),
                "Note Title" ));
        return this;
    }
    @Step
    public NotePad clickPublicNote() {
        driver.findElement(PublicButton).click();
        return this;
    }
    @Step
    public NotePad setPrivateNote() {
        driver.findElement(PrivateButton).click();
        return this;
    }
    @Step
    public NotePad checkPrivateMode() {
        driver.findElement(PrivateButtonIs);
        return this;
    }
    @Step
    public NotePad close() {
        driver.findElement(CloseButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("noteAccessText"),
                "Private Note" ));
        return this;
    }
    @Step
    public NotePad setTitle(String title) {
        driver.findElement(noteTitle).sendKeys("My New Note");
        return this;
    }
    @Step
    public NotePad save() {
        driver.findElement(saveTitleButton).click();
        return this;
    }
}


