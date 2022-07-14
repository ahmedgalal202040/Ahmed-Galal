import com.beust.jcommander.converters.IntegerConverter;
import com.beust.jcommander.converters.StringConverter;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.time.Duration;

public class Facebook_Registration {
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
    public Object[][] RegValidData() throws IOException
    {
        // get data from Excel Reader class
        ExcelReaderReg ER = new ExcelReaderReg();
        return ER.getExcelData();
    }
    @Test(priority = 1,dataProvider ="ValidData")
    public  void Registraion(String First , String Last , String Mail , String Pass, String Assertion)
    {
        WebElement RegButton = driver.findElement(By.xpath("//*[@class ='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        RegButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement FirstName =driver.findElement(By.name("firstname"));
        FirstName.sendKeys(First);
        WebElement LastName =driver.findElement(By.name("lastname"));
        LastName.sendKeys(Last);
        WebElement Mail_Phone =driver.findElement(By.name("reg_email__"));
        Mail_Phone.sendKeys(Mail);
        WebElement Password =driver.findElement(By.name("reg_passwd__"));
        Password.sendKeys(Pass);
        WebElement Day = driver.findElement(By.id("day"));
        Select Days = new Select(Day);
        Days.selectByIndex(1);
        WebElement Month = driver.findElement(By.name("birthday_month"));
        Select Months = new Select(Month);
        Months.selectByIndex(1);
        WebElement Year = driver.findElement(By.name("birthday_year"));
        Select Years = new Select(Year);
        Years.selectByIndex(25);
        WebElement Gender = driver.findElement(By.xpath("//input[@value='1']"));
        Gender.click();
        WebElement Signup = driver.findElement(By.xpath("//*[@Class ='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"));
        Signup.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement Message = driver.findElement(By.xpath("//*[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 qg6bub1s iv3no6db o0t2es00 f530mmz5 hnhda86s oo9gr5id hzawbc8m']"));
        // when user submit valid data for registration , there is assertion on message in the screen that required the code that sent to mobile
        Assert.assertEquals(Message.getText(),Assertion);
        driver.quit();
        OpenBrowser();

    }
    @DataProvider(name="InvalidData")
    public Object[][] RegInvalidData() throws IOException
    {
        // get data from Excel Reader class
        ExcelReaderReg2 ER = new ExcelReaderReg2();
        return ER.getExcelData();
    }
    @Test(priority = 2,dataProvider ="InvalidData")
    public  void InvalidRegistraion(String First , String Last , String Mail , String Pass, String Assertion, String Gendertype)
    {
        WebElement RegButton = driver.findElement(By.xpath("//*[@class ='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        RegButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.sendKeys(First);
        WebElement LastName = driver.findElement(By.name("lastname"));
        LastName.sendKeys(Last);
        WebElement Mail_Phone = driver.findElement(By.name("reg_email__"));
        Mail_Phone.sendKeys(Mail);
        WebElement Password = driver.findElement(By.name("reg_passwd__"));
        Password.sendKeys(Pass);
        WebElement Day = driver.findElement(By.name("birthday_day"));
        Select Days = new Select(Day);
        Days.selectByIndex(1);
        WebElement Month = driver.findElement(By.name("birthday_month"));
        Select Months = new Select(Month);
        Months.selectByIndex(1);
        WebElement Year = driver.findElement(By.name("birthday_year"));
        Select Years = new Select(Year);
        Years.selectByIndex(25);
        WebElement Gender = driver.findElement(By.xpath(Gendertype));
        Gender.click();
        WebElement Signup = driver.findElement(By.xpath("//*[@Class ='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"));
        Signup.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement First_Mandatory = driver.findElement(By.xpath("//*[@Class='_5633 _5634 _53ij']"));
        System.out.println(First_Mandatory.getText());
        //check on all error messages with all invalid scenarios
        Assert.assertEquals(First_Mandatory.getText(), Assertion);
    }

}
