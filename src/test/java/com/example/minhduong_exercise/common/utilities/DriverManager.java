package com.example.minhduong_exercise.common.utilities;

import com.example.minhduong_exercise.dataObjects.Url;
import com.example.minhduong_exercise.common.utilities.reader.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

    private static void setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                initChromeDriver();
        }
    }

    private static void setupBrowser() {
        maximizeWindow();
        pageLoadTimeout();
        implicitlyWait();
    }

    private static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private static void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageloadTimeout()));
    }

    private static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
    }

    private static void initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setupBrowser();
    }

    private static void initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\Executables\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        setupBrowser();
    }

    private static Map<String, String> getParamsOfUrl() {
        String[] params = URI.create(driver.getCurrentUrl()).getQuery().split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split(name + "=")[1];
            map.put(name, value);
        }
        return map;
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String getParamValue(String paramName) {
        return getParamsOfUrl().get(paramName);
    }

    public static Alert alertDriver() {
        return DriverManager.getDriver().switchTo().alert();
    }

    public static void close() {
        driver.quit();
    }
}
