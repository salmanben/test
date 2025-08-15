package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class Checkout {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void initWebDriverWait() {
    }
    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @Test
    void should_find_btn() {
        driver.get("http://127.0.0.1:5500/index.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button")));
        btn.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertTrue(alert.getText().equals("Hello"));
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
