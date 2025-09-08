// src/test/java/com/swag/core/Hooks.java
package com.swag.core;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] shot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(shot, "image/png", "FailedStep");
            }
        } catch (Exception ignored) {}
        DriverFactory.quitDriver();
    }
}
