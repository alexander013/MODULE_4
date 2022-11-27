import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TEST_MODUL_4_2 {
    private WebDriver driver;

    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    private By emaillocator = By.className("email");
    private By WriteToMeLocator = By.id("write-to-me");
    private By resultEmailLOcator = By.className("notification-email");

    private By resultEmailDog = By.className("your-email");
    private By buttonDog = By.id("sendMe");
    private By radioButtonGirl = By.id("girl");
    private By emailDog = By.name("email");


    @Test
    public void TestKitens()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        var email = "test@test.ru";
        driver.findElement(emaillocator).sendKeys(email);
        driver.findElement(WriteToMeLocator).click();

        Assert.assertTrue("Не отображается текст про email", driver.findElement(resultEmailLOcator).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email, driver.findElement(resultEmailLOcator).getText());

    }

    @Test
    public void TestKitens_2()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        driver.findElement(WriteToMeLocator).click();
        Assert.assertEquals("Неправильный текст про email", "", driver.findElement(resultEmailLOcator).getText());
    }

    @Test
    public  void TestDog_1()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(buttonDog).click();
        Assert.assertEquals("Неправильный текст про email", "", driver.findElement(resultEmailDog).getText());
    }

    @Test
    public  void TestDog_2()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(radioButtonGirl).click();
        var email = "test@test.ru";
        driver.findElement(emailDog).sendKeys(email);
        driver.findElement(buttonDog).click();
        Assert.assertTrue("Не отображается текст про email", driver.findElement(resultEmailDog).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email, driver.findElement(resultEmailDog).getText());

    }

    @Test
    public void TestFeedBack()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var nameLocator = By.cssSelector(".data.text");
        var emailLocator = By.cssSelector(".data.field");
        var otzivLocator = By.cssSelector(".field.text");
        var buttonLocator = By.id("comment");
        var resultTextLocator = By.className("message-header");

        driver.findElement(nameLocator).sendKeys("Вася");
        driver.findElement(emailLocator).sendKeys("test@test.ru");
        driver.findElement(otzivLocator).sendKeys("Всё отлично !");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Не отобразился текст про спасибо", driver.findElement(resultTextLocator).isDisplayed());
        Assert.assertEquals("Неверный текст про спасибо", "Спасибо за отзыв!", driver.findElement(resultTextLocator).getText() );
    }

    @Test
    public void TestRemont_1()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        var FioLocator = By.cssSelector(".form-input.fio");
        var StreetLocator = By.cssSelector(".data.form-input.street");
        var NomerHouseLocator = By.cssSelector(".form-input.house");
        var KvartiraLocator = By.cssSelector(".form-input.flat");
        var RemontDataLocator = By.cssSelector(".form-input.date");
        var ButtonVizvatMasterLocator = By.className("form-submit");
        var ResultDannieLocator = By.className("form-result-description");

        driver.findElement(FioLocator).sendKeys("Попов Антон Николаевич");
        driver.findElement(StreetLocator).sendKeys("Пушкина");
        driver.findElement(NomerHouseLocator).sendKeys("13");
        driver.findElement(KvartiraLocator).sendKeys("13");
        driver.findElement(RemontDataLocator).sendKeys("13.12.2022");
        driver.findElement(ButtonVizvatMasterLocator).click();
        Assert.assertTrue("Элемент с заголовком результата отсутствует", driver.findElement(ResultDannieLocator).isDisplayed());
        Assert.assertEquals("Неверный текст заголовка результата", "Вы ввели следующие данные:", driver.findElement(ResultDannieLocator).getText());
    }


}
