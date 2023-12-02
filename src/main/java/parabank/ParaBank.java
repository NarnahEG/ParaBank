package parabank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static parabank.Selectors.verifiableElement;

public class ParaBank {

    WebDriver driver;
    WebDriverWait wait;
    private boolean originalText;
    //java wait;


    public void loadPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void regRedirect(){
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        /*wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Register")));
        driver.findElement(By.cssSelector(String.valueOf(By.linkText("Register"))));*/
    }

    public void fillDetails(){
       /* WebElement until = wait.until(
                ExpectedConditions.
                        presenceOfElementLocated(
                                By.id(Selectors.user)));*/
        driver.findElement(By.cssSelector(Selectors.fName)).sendKeys(Selectors.firstName);
        driver.findElement(By.cssSelector(Selectors.lName)).sendKeys(Selectors.lastName);
        driver.findElement(By.cssSelector(Selectors.add)).sendKeys(Selectors.address);
        driver.findElement(By.cssSelector(Selectors.city)).sendKeys(Selectors.cityName);
        driver.findElement(By.cssSelector(Selectors.state)).sendKeys(Selectors.stateName);
        driver.findElement(By.cssSelector(Selectors.zip)).sendKeys(Selectors.zipCode);
        driver.findElement(By.cssSelector(Selectors.phone)).sendKeys(Selectors.phoneNumber);
        driver.findElement(By.cssSelector(Selectors.ssn)).sendKeys(Selectors.ssNumber);
        driver.findElement(By.cssSelector(Selectors.user)).sendKeys(Selectors.username);
        driver.findElement(By.cssSelector(Selectors.pwd)).sendKeys(Selectors.pwdDetails);
        driver.findElement(By.cssSelector(Selectors.confPwd)).sendKeys(Selectors.pwdDetails);
        driver.findElement(By.cssSelector(Selectors.register)).click();
    }

  /*  public void regConfirmation(){
        WebElement successMessage = driver.findElement(By.cssSelector(".title"));
        //Assert.assertEquals(successMessage.getText(), "Your account was created successfully. You are now logged in.");
        String verifiableText = verifiableElement.repeat();
        Assert.state(originalText, verifiableText);
    }*/

    public void verifyText(){
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".title"), verifiableElement));

    }

    public void tearDown(){
        driver.quit();
    }
}
