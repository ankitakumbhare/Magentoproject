package luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchBox {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchFunctionality() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");

        // Find the search bar element
        WebElement searchBar = driver.findElement(By.id("search"));

        // Enter the search query
        searchBar.sendKeys("T-shirt for Women");

        // Find the search button and click it
        WebElement searchButton = driver.findElement(By.xpath("//button[@title='Search']"));
        searchButton.click();

        // Wait for the search results page to load
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

