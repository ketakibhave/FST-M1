package activities_Board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

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

        driver.findElement(By.id("menu-item-24")).click();

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Jobs � Alchemy Jobs", title);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
