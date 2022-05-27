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

import java.net.MalformedURLException;
import java.net.URL;

public class ActivityGoogleKeep {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5000);
    }

    @Test
    public void add() {

        //Click on Add Note icon and enter Task1 details
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/new_note_button")));
        driver.findElementById("com.google.android.keep:id/new_note_button").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
        MobileElement noteTitle = driver.findElementById("com.google.android.keep:id/editable_title");
        noteTitle.sendKeys("Note1");
        MobileElement noteDescr = driver.findElementById("com.google.android.keep:id/edit_note_text");
        noteDescr.sendKeys("Adding Note1");
        MobileElement backBtn = driver.findElementByAccessibilityId("Open navigation drawer");
        backBtn.click();

        String savedTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
        //Validate if added all 3 task names are showing up in list
        Assert.assertEquals("Note1", savedTitle );
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
