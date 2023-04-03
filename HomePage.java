package pageobjects;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "tbody .clickable .vgt-left-align span")
    private MobileElement statusTab;

}
