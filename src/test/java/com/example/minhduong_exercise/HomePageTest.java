package com.example.minhduong_exercise;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;



    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:/ChromeDriver/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.railwayb2.somee.com/");
    }

    @Test
    public void loginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.tabNavigate("Login");
        loginPage.loginAccount();
        Assert.assertEquals(basePage.welcomeText.getText(),"Welcome abc@gmail.com");
    }

    @Test
    public void registerSuccessfully(){
        RegisterPage registerPage = new RegisterPage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.tabNavigate("Log out");
        basePage.tabNavigate("Register");
        registerPage.registerAccount("1ab1@gmail.com","111111111","111111111","111111111");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
