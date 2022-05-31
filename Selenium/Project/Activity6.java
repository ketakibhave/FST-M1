package activities_Board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void exampleTestCase()  {
        // Check the text on the page
        WebElement navBar = driver.findElement(By.className("main-navigation"));

        System.out.println("Navigation bar found?"+navBar.isDisplayed());

        driver.findElement(By.id("menu-item-24")).click();

        // Search banking projects
        WebElement searchText= driver.findElement(By.id("search_keywords"));
        searchText.click();
        searchText.sendKeys("banking");
        driver.findElement(By.className("search_submit")).click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(2000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h3")));
        System.out.println("Is it visible?= "+driver.findElement(By.xpath("//div/h3")).isDisplayed());
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("position")));

        //click on first job
        //List<WebElement> columnList = driver.findElements(By.xpath("//div/h3"));
        //System.out.println(rows.lastIndexOf(rows));

        WebElement firstJob= driver.findElement(By.xpath("//div/h3"));
        String jobname=firstJob.getText();
        System.out.println("jobname : "+jobname);
        firstJob.click();

        //apply the job
        System.out.println("Page title= "+driver.getTitle());
        WebElement applyButton= driver.findElement(By.xpath("//input"));
        applyButton.click();

        WebElement mailtoAbhiram= driver.findElement(By.className("application_details"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'To apply for this job email your details')]")));
        System.out.println("Is message displayed?= "+mailtoAbhiram.isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p")).isDisplayed());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
