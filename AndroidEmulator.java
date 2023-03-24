import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class AndroidEmulator {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc= new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\8872\\Documents\\DPTmobile_7.6.33_DEBUG.apk");
        dc.setCapability("appium:autoGrantPermissions","true");

        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver=new AndroidDriver<WebElement> (url,dc);
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.id("com.survey_compass.dptmobile:id/button_sign_in"))
                .click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!driver.findElements(By.xpath(".//android.widget.TextView[@text='Password reminder']")).isEmpty())
        {
            driver.findElement(By.xpath(".//android.widget.Button[@text='OK']")).click();
        }
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.id("com.survey_compass.dptmobile:id/button_close_sync")).click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.Spinner/android.widget.LinearLayout")).click();
       // driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")).click();

        boolean hccrFound = false;
        do {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.Spinner/android.widget.LinearLayout")).click();
            // driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")).click();
            synchronized (driver) {
                try {
                    driver.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            List<WebElement> elements = driver.findElements(By.xpath("//android.widget.TextView[normalize-space(@text) = 'HCCR-AWD']"));
            if(elements.isEmpty()){
                driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'Here']")).click();
                synchronized (driver) {
                    try {
                        driver.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
                else {
                elements.get(0).click();
                hccrFound = true;}
        } while(!hccrFound);
      //  driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'HCCR-AWD']")).click();
        boolean gateFound = false;
        do {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.Spinner/android.widget.LinearLayout")).click();
            // driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")).click();
            synchronized (driver) {
                try {
                    driver.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'Inspection (Gate)']")).click();
            List<WebElement> elements = driver.findElements(By.id("com.survey_compass.dptmobile:id/activity_gate_in_top_title"));
            if(elements.isEmpty()){
                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.Spinner/android.widget.LinearLayout")).click();
                synchronized (driver) {
                    try {
                        driver.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'Inspection']")).click();
                synchronized (driver) {
                    try {
                        driver.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            else {
                gateFound = true;}
        } while(!gateFound);




        long timeLimitInSeconds = 3;
        WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/activity_gate_in_container_nr")));
        element.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //driver.findElement(By.id("com.survey_compass.dptmobile:id/activity_gate_in_container_nr")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/btn_container_id_ok")).click();

        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/activity_gate_in_iso")));
        element2.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //driver.findElement(By.id("com.survey_compass.dptmobile:id/activity_gate_in_iso")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_2")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/title_list_item")).click();

        driver.findElement(By.id("com.survey_compass.dptmobile:id/activity_gate_in_licence_plate")).click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_4")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_4")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_4_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_1_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_4")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_1_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_1")).click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.navigate().back();




        //  driver.quit();
        //AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);


    }
}
