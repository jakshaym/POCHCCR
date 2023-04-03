import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/////// Test Case TC-D-043 Please refer Pdf
public class AndroidEmulator {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc= new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\8872\\Documents\\DPTmobile_7.6.33_DEBUG.apk"); // Application path
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
        driver.findElement(By.id("com.survey_compass.dptmobile:id/button_sign_in")) // log in application
                .click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!driver.findElements(By.xpath(".//android.widget.TextView[@text='Password reminder']")).isEmpty()) // Incase password reminder pops up
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
        driver.findElement(By.id("com.survey_compass.dptmobile:id/button_close_sync")).click(); // close sync window
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        boolean hccrFound = false; // select desired entry in HCCR dropdown
        do {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.Spinner/android.widget.LinearLayout")).click();

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

        // container number
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_1_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_2_3")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_1")).click();
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
        // gate iso number
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
        // license plate number
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
        WebElement elementCarrier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/activity_gate_in_carrier")));
        elementCarrier.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'ANHALT - ANHALT']")).click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebElement elementOperator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/activity_gate_in_operator")));
        elementOperator.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"HLM - HAPAG-LLOYD AG\").instance(0))").click(); //scroll down to the element and click

        WebElement elementRequestButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/activity_gate_in_confirm")));
        elementRequestButton.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        WebElement elementConfirmRequestButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[normalize-space(@text) = 'Confirm Request']")));
        elementConfirmRequestButton.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        WebElement elementBuildYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/input_build_year")));
        elementBuildYear.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // build year
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_4_2")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_1")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_3_2")).click();
        driver.findElement(By.id("com.survey_compass.dptmobile:id/keypad_4_2")).click();

        WebElement elementCarcassManufacturer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/android.widget.Spinner/android.widget.LinearLayout")));
        elementCarcassManufacturer.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'Hyundai']")).click();

        WebElement elementAecp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/checkbox_csc_acep")));
        elementAecp.click();

        driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'DETAIL']")).click();
        WebElement elementBlueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Delete this damage image\"]")));
        elementBlueButton.click();

        WebElement elementPartlyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/button_partly")));
        elementPartlyButton.click();
        driver.findElement(By.xpath("//android.widget.TextView[normalize-space(@text) = 'D - Damaged']")).click();
        WebElement elementListItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[normalize-space(@text) = 'GC - General Cargo']")));
        elementListItem.click();

        WebElement elementOkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        elementOkButton.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebElement elementDestinationArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/spinner_option")));
        elementDestinationArea.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"D\").instance(0))").click();
        WebElement elementSendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        elementSendButton.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebElement elementOk2Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        elementOk2Button.click();


        WebElement elementTransferredButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.survey_compass.dptmobile:id/button_state_finished")));
        elementTransferredButton.click();
        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        WebElement elementDeleteIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Delete this damage case\"]")));
        elementDeleteIcon.click();

        WebElement elementDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        elementDeleteButton.click();
        synchronized (driver) {
            try {
                driver.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.navigate().back();
        driver.closeApp();

        //driver.navigate().back();
        //WebElement elementExitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[normalize-space(@text) = 'Exit']")));
        //elementExitButton.click();
        //driver.quit();



    }
}
