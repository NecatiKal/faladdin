package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Action {
    public static final Logger LOGGER = Logger.getLogger(String.valueOf(Action.class));
    public static int minTime = 30;
    public static AndroidDriver androidDriver;
    public Driver objectDriver = new Driver();


    public void startDriver() throws MalformedURLException {
        objectDriver.initializeTest();
    }

    public void endDriver() {
        objectDriver.tearDownTest();
    }

    public void staticWait(int waitInMSeconds) {
        try {
            Thread.sleep(waitInMSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void confirm(By element, String log) {
        try {
            if (isElementPresent(element, minTime)) {
                LOGGER.info(log);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void enter(By element, String text, String log) {
        try {
            if (isElementPresent(element, minTime)) {
                androidDriver.findElement(element).clear();
                androidDriver.findElement(element).sendKeys(text);
                LOGGER.info(log);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void click(By element, String log) {
        try {
            if (isElementPresent(element, minTime)) {
                androidDriver.findElement(element).click();
                LOGGER.info(log);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public boolean isElementPresent(By by, int waitInSeconds) {
        try {
            LOGGER.info("Checking is element present");
            androidDriver.manage().timeouts()
                    .implicitlyWait(waitInSeconds, TimeUnit.SECONDS);
            androidDriver.findElement(by);
            androidDriver.manage().timeouts().implicitlyWait(35L, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException var4) {
            return false;
        }
    }

    public void pressBackButton(String log) {
        try {
            ((AndroidDriver) androidDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void fluentWaitForVisibility(By by, int waitInSeconds) {
        FluentWait<AndroidDriver> wait = new FluentWait<>(androidDriver);
        wait.withTimeout(Duration.ofSeconds(waitInSeconds))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
