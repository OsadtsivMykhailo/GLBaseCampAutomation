package com.it;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        final ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mvnrepository.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://mvnrepository.com/");
        driver.quit();
    }
}
