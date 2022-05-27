package activities1;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;

public class ActivityGoogleTasks {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5000);
    }

    @Test
    public void add() {

        //Click on Add task icon and enter Task1 details
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        MobileElement firstName = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        firstName.sendKeys("Complete Activity with Google Tasks");
        MobileElement saveBtn1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
        saveBtn1.click();

        //Wait for the task1 to show up on list
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
        String task1Title = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        boolean title1= task1Title.equalsIgnoreCase("Complete Activity with Google Tasks");

        //Enter details for Task2
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        MobileElement secName = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        secName.sendKeys("Complete Activity with Google Keep");
        MobileElement saveBtn2 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
        saveBtn2.click();

        //Wait for the task2 to show up on list
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
        String task2Title = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        boolean title2= task2Title.equalsIgnoreCase("Complete Activity with Google Keep");

        //Enter details for Task3
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        MobileElement thirdName = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        thirdName.sendKeys("Complete the second Activity with Google Keep");
        MobileElement saveBtn3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
        saveBtn3.click();

        //Wait for the task3 to show up on list
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
        String task3Title = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        boolean title3= task3Title.equalsIgnoreCase("Complete the second Activity with Google Keep");

        boolean namesMatch = title1 && title2 && title3;

        //Validate if added all 3 task names are showing up in list
        Assert.assertEquals(true, namesMatch );
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
