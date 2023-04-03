package runners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.HomePage;

import java.net.MalformedURLException;
import java.net.URL;


public class AndroidEmulator {
    private AndroidDriver driver;

    @Before("")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\8872\\Documents\\DPTmobile_7.6.33_DEBUG.apk");
        desiredCapabilities.setCapability("appium:automationName", "Appium");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Android Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "8.0");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"))
                .click();
    }
    @Test
    public void AndroidEmulator() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"))
                .click();


    }

    @After
    public void tearDown() {
      //  driver.quit();
   }
}

