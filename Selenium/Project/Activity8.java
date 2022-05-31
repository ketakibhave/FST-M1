package activities_Board;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
        // Check the text on the page

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(2000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));

        WebElement userName= driver.findElement(By.id("user_login"));
        WebElement passWord= driver.findElement(By.id("user_pass"));
        WebElement submitBtn= driver.findElement(By.id("wp-submit"));

        userName.sendKeys("root");
        passWord.sendKeys("pa$$w0rd");
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("display-name")));
        System.out.println("UserName displayed= "+driver.findElement(By.className("display-name")).getText());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }

}
