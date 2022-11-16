package com.example.minhduong_exercise.common.utilities;

import com.example.minhduong_exercise.common.constant.Url;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void open() {
        setupDriver(configFileReader.getBrowserDriver());
        driver.get(Url.HOMEPAGE.getUrl());
    }

    public static void setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getPageloadTimeout(), TimeUnit.SECONDS);
    }

    public static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        maximizeWindow();
        pageLoadTimeout();
        implicitlyWait();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\Executables\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        maximizeWindow();
        pageLoadTimeout();
        implicitlyWait();
        return driver;
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static Alert alertDriver() {
        return DriverManager.getDriver().switchTo().alert();
    }

    public static void close() {
        driver.quit();
    }
}
