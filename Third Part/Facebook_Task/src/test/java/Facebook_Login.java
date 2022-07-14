import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;


public class Facebook_Login {

    WebDriver driver;
    @BeforeTest
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void OpenFaceBook()
    {
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
    }
    @DataProvider(name="ValidData")
    public Object[][] UserValidData() throws IOException
    {
        // get data from Excel Reader class
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }
    @Test(priority = 2, dataProvider = "ValidData")
    public void ValidLogin( String user, String pass, String Assertion)
    {
        WebElement UserName = driver.findElement(By.xpath("//*[@id='email']"));
        WebElement Password = driver.findElement(By.xpath("//*[@id='pass']"));
        WebElement LoginButton = driver.findElement(By.xpath("//*[@Name='login']"));
        UserName.sendKeys(user);
        Password.sendKeys(pass);
        LoginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement Message =driver.findElement(By.xpath("//*[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 qg6bub1s iv3no6db o0t2es00 f530mmz5 hnhda86s oo9gr5id']"));
        System.out.println(Message.getText());
        // check on welcome message after the user logged in
        Assert.assertEquals(Message.getText(),Assertion);

    }
    @DataProvider(name="InvalidData")
    public Object[][] UserInvalidData() throws IOException
    {
        // get data from Excel Reader class
        ExcelReader2 ER = new ExcelReader2();
        return ER.getExcelData();
    }
    @Test (priority = 1, dataProvider ="InvalidData")
    public void InvalidLogin(String User2 , String Pass2 , String ErrorMessage)
    {
        WebElement UserName = driver.findElement(By.xpath("//*[@id='email']"));
        WebElement Password = driver.findElement(By.xpath("//*[@id='pass']"));
        WebElement LoginButton = driver.findElement(By.xpath("//*[@Name='login']"));
        UserName.sendKeys(User2);
        Password.sendKeys(Pass2);
        LoginButton.click();
        WebElement Message =driver.findElement(By.xpath("//*[@class='_9ay7']"));
        System.out.println(Message.getText());
        // check on different error messages with the all invalid scenarios
        Assert.assertEquals(Message.getText(),ErrorMessage);
    }


    @AfterTest
    public void CloseWindow()
    {
        driver.quit();
    }
}
