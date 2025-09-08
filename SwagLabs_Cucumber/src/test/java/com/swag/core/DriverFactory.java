// src/test/java/com/swag/core/DriverFactory.java
package com.swag.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void launchBrowser(String browser) {
        if (tlDriver.get() != null) return;

        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            tlDriver.set(new ChromeDriver(options));
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver getDriver() {
        WebDriver d = tlDriver.get();
        if (d == null) throw new IllegalStateException("WebDriver not initialized. Call launchBrowser() first.");
        return d;
    }

    public static void quitDriver() {
        WebDriver d = tlDriver.get();
        if (d != null) {
            d.quit();
            tlDriver.remove();
        }
    }
}
