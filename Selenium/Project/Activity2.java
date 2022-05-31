package activities_Board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page

        String heading = driver.findElement(By.className("entry-title")).getText();

        //Print the title of the page
        System.out.println("Page heading is: " + heading);

        //Assertion for page title
        //Assert.assertEquals("Alchemy Jobs – Job Board Application", title);

        //Print title of new page
        //System.out.println("New page title is: " + driver.getTitle());

        Assert.assertEquals(heading, "Welcome to Alchemy Jobs");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
