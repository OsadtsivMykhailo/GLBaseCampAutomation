package com.it.tests;

import com.it.users.User;
import com.it.users.UserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.it.common.Constants.BASE_URL;

public class MyTest {
    ChromeDriver driver;
    static User validUser = UserFactory.getValidUser();

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
    //    @Test
//    public void test() {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://mvnrepository.com/");
//        Assert.assertEquals(driver.getCurrentUrl(), "https://mvnrepository.com/");
//        driver.quit();
//    }

    @Test
    public void test2() {
        driver.findElement(By.name("login")).sendKeys(validUser.login);
        driver.findElement(By.name("pass")).sendKeys(validUser.password);
        driver.findElement(By.xpath("//input[@tabindex='5']")).click();
        String text = driver.findElement(By.xpath("//span [@class='sn_menu_title']")).getText();
        Assert.assertEquals(text, validUser.email);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
