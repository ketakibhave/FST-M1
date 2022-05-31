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

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
        // Check the text on the page
        WebElement navBar = driver.findElement(By.className("main-navigation"));

        System.out.println("Navigation bar found?"+navBar.isDisplayed());

        driver.findElement(By.id("menu-item-26")).click();

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(2000));
        WebDriverWait wait1 = new WebDriverWait (driver, Duration.ofSeconds(200000));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_email")));
        WebElement createAccountEmail = driver.findElement(By.id("create_account_email"));
        createAccountEmail.sendKeys("keatp6@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_title")));
        WebElement jobTitle = driver.findElement(By.id("job_title"));
        String jobTitlesend ="Test Lead32";
        jobTitle.sendKeys(jobTitlesend);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_location")));
        WebElement jobLocation = driver.findElement(By.id("job_location"));
        String jobLocationtoSend = "Mumbai";
        jobTitle.sendKeys(jobLocationtoSend);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_type")));
        Select jobType= new Select(driver.findElement(By.id("job_type")));
        jobType.selectByIndex(2);
        System.out.println("selected value: "+jobType.getFirstSelectedOption());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mceu_16")));
        driver.switchTo().frame("job_description_ifr");
        WebElement description = driver.findElement(By.id("tinymce"));
        description.sendKeys("Description test1");
        driver.switchTo().parentFrame();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("application")));
        WebElement applicationURL = driver.findElement(By.id("application"));
        applicationURL.sendKeys("ketu1@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company_name")));
        WebElement companyName = driver.findElement(By.id("company_name"));
        companyName.sendKeys("IBM!!!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='button']")));
        WebElement previewButton = driver.findElement(By.xpath("//input[@class='button']"));
        previewButton.click();

        System.out.println("New page title===>"+driver.getTitle());

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='job_listing_preview single_job_listing']"))));
        String getJobtitle= driver.findElement(By.xpath("//div[@class='job_listing_preview single_job_listing']")).getText();
        System.out.println("Job posting with title== "+getJobtitle);

        driver.findElement(By.id("job_preview_submit_button")).click();
        System.out.println("Confirmation message shows up::");
        System.out.println(driver.findElement(By.xpath("//div[@itemprop='text']")).getText());

        //to see if job shows up on Jobs tab search

        driver.findElement(By.id("menu-item-24")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords")));
        // Search new job
        WebElement searchText= driver.findElement(By.id("search_keywords"));
        searchText.click();
        searchText.sendKeys(jobTitlesend);
        driver.findElement(By.className("search_submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='position']"))));
        String jobDisplayed = driver.findElement(By.xpath("//div[@class='position']")).getText();
        boolean isJobdisp = jobDisplayed.contains(jobTitlesend);
        Assert.assertEquals(true, isJobdisp);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
