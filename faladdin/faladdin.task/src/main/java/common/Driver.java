package common;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class Driver {

    public void initializeTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("autoGrantPermissions", "true");


        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("app", "path.apk");
        capabilities.setCapability("appPackage", "com.faladdin.app");
        capabilities.setCapability("appActivity", "com.faladdin.app.ui.launcher.LauncherActivity");
        Action.androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

    }

    public void tearDownTest() {
        if (null != Action.androidDriver) {
            Action.androidDriver.quit();
        }
    }
}