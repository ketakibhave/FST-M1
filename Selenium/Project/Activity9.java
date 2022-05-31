package activities_Board;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {

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

        //Find Add New option

        WebElement jobListings = driver.findElement(By.xpath("//div[2]/ul/li[7]/a/div[3]"));
        //Creating object of an Actions class
        Actions action = new Actions(driver);

//Performing the mouse hover action on the target element.
        action.moveToElement(jobListings).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='post-new.php?post_type=job_listing']")));
        WebElement addNew = driver.findElement(By.xpath("//a[@href='post-new.php?post_type=job_listing']"));
        addNew.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("post-title-0")));
        WebElement position = driver.findElement(By.id("post-title-0"));
        String posttoPublish= "Test1213";
        position.sendKeys(posttoPublish);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_job_location")));
        action.moveToElement(driver.findElement(By.id("_job_location")));
        WebElement location = driver.findElement(By.id("_job_location"));
        location.click();
        location.sendKeys("Mumbai");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_company_name")));
        WebElement companyName= driver.findElement(By.id("_company_name"));
        companyName.sendKeys("IBM1");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_company_website")));
        WebElement companyWebsite = driver.findElement(By.id("_company_website"));
        companyWebsite.sendKeys("https://www.ibm.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[4]/div[1]//div[1]//div[2]/button[2]")));
        WebElement publishBtn = driver.findElement(By.xpath("//div[1]/div[4]/div[1]//div[1]//div[2]/button[2]"));
        publishBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/div[1]//div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")));
        WebElement publishConfirm= driver.findElement(By.xpath("//div[4]/div[1]//div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button"));
        publishConfirm.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Published')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[1]/div/ul[1]/li[3]/a")));
        WebElement alchemyJobs = driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/ul[1]/li[3]/a"));
        alchemyJobs.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[4]/div[1]//div[1]//div[2]/div[3]//div[2]//div[2]/div[2]/a")));
        driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[4]/div[1]//div[1]//div[2]/div[3]//div[2]//div[2]/div[2]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='entry-title']")));
        // Search new job
        WebElement searchText= driver.findElement(By.xpath("//h1[@class='entry-title']"));
        System.out.println("Job found!!= "+searchText.getText());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
