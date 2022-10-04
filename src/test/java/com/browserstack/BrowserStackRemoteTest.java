package com.browserstack;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserStackRemoteTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, String> bstackOptionsMap = new HashMap<String, String>();
        bstackOptionsMap.put("source", "testng:sample-sdk:v1.0");
        capabilities.setCapability("bstack:options", bstackOptionsMap);
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}

