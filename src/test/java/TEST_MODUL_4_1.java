import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TEST_MODUL_4_1 {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestHomework() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        var EmailElementLocator = By.id("email");
        var PasswordElementLocator = By.name("password");
        var ButtonVoytiElement = By.className("form-submit");
        driver.findElement(EmailElementLocator).sendKeys("@");
        driver.findElement(PasswordElementLocator).sendKeys("123");
        driver.findElement(ButtonVoytiElement).click();
        var ResultElementVidimost = By.className("form-error-password-email");
        Assert.assertTrue("Элемент по проверки видимости не найден", driver.findElement(ResultElementVidimost).isDisplayed());
        Assert.assertEquals("Неверный текст", "Некорректный email или пароль", driver.findElement(ResultElementVidimost).getText());

    }


    //    Запишите для неё точно такой же тест.
//    В этом задании ищите все элементы с помощью By.cssSelector.
//    Там, где элемент нельзя найти уникально по одному классу, ищите по двум.
    @Test
    public void TestHomework_2()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var EmailElementLocator = By.cssSelector(".form-input.input-data");
        var PasswordElementLocator = By.cssSelector(".form-input.password");;
        var ButtonVoytiElement = By.cssSelector(".form-submit");
        driver.findElement(EmailElementLocator).sendKeys("@");
        driver.findElement(PasswordElementLocator).sendKeys("123");
        driver.findElement(ButtonVoytiElement).click();
        var ResultElementVidimost = By.cssSelector(".form-error-password-email");;
        Assert.assertTrue("Элемент по проверки видимости не найден", driver.findElement(ResultElementVidimost).isDisplayed());
        Assert.assertEquals("Неверный текст", "Некорректный email или пароль", driver.findElement(ResultElementVidimost).getText());
    }

    //    Используйте сценарий и тест как в задании 2,
//    только теперь ищите элементы с помощью By.cssSelector с поиском по тегу и одному или двум классам одновременно.
    @Test
    public void TestHomework_3()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var EmailElementLocator = By.cssSelector("input.form-input.input-data");
        var PasswordElementLocator = By.cssSelector("input.form-input.password");;
        var ButtonVoytiElement = By.cssSelector("button.form-submit");
        driver.findElement(EmailElementLocator).sendKeys("@");
        driver.findElement(PasswordElementLocator).sendKeys("123");
        driver.findElement(ButtonVoytiElement).click();
        var ResultElementVidimost = By.cssSelector("pre.form-error-password-email");;
        Assert.assertTrue("Элемент по проверки видимости не найден", driver.findElement(ResultElementVidimost).isDisplayed());
        Assert.assertEquals("Неверный текст", "Некорректный email или пароль", driver.findElement(ResultElementVidimost).getText());
    }


    //  Используйте сценарий и тест как в задании 2, только теперь ищите элементы с помощью By.cssSelector с поиском по ID.
    @Test
    public void TestHomework_4()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var EmailElementLocator = By.cssSelector("#email");
        var PasswordElementLocator = By.cssSelector("#password");;
        var ButtonVoytiElement = By.cssSelector("#submit");
        driver.findElement(EmailElementLocator).sendKeys("@");
        driver.findElement(PasswordElementLocator).sendKeys("123");
        driver.findElement(ButtonVoytiElement).click();
        var ResultElementVidimost = By.cssSelector("#error");;
        Assert.assertTrue("Элемент по проверки видимости не найден", driver.findElement(ResultElementVidimost).isDisplayed());
        Assert.assertEquals("Неверный текст", "Некорректный email или пароль", driver.findElement(ResultElementVidimost).getText());
    }


    //    Используйте сценарий и тест как в задании 2. Элементы с одним классом ищите с помощью By.cssSelector
//    с поиском по ID, тегу и классу одновременно. Элементы с двумя классами ищите по ID, тегу и двум классам.
    @Test
    public void TestHomework_5()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var EmailElementLocator = By.cssSelector("input#email.form-input.input-data");
        var PasswordElementLocator = By.cssSelector("input#password.form-input.password");;
        var ButtonVoytiElement = By.cssSelector("button#submit.form-submit");
        driver.findElement(EmailElementLocator).sendKeys("@");
        driver.findElement(PasswordElementLocator).sendKeys("123");
        driver.findElement(ButtonVoytiElement).click();
        var ResultElementVidimost = By.cssSelector("pre#error.form-error-password-email");;
        Assert.assertTrue("Элемент по проверки видимости не найден", driver.findElement(ResultElementVidimost).isDisplayed());
        Assert.assertEquals("Неверный текст", "Некорректный email или пароль", driver.findElement(ResultElementVidimost).getText());
    }
}
