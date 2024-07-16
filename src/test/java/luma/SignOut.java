package luma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignOut {
    private WebDriver driver;
    private String baseUrl = "https://magento.softwaretestingboard.com";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testSignOut() {
        // Log in to the account
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement signInButton = driver.findElement(By.id("send2"));

        emailField.sendKeys("ankitakumbhare199@gmail.com"); // replace with the actual email
        passwordField.sendKeys("Password@345"); // replace with the actual password
        signInButton.click();

        // Wait for the account menu to appear and sign out
        WebElement accountMenu = driver.findElement(By.xpath("//div[@class='panel header']//button[@data-action='customer-menu-toggle']"));
        accountMenu.click();
        
        WebElement signOutButton = driver.findElement(By.xpath("//li[@class='authorization-link']/a"));
        signOutButton.click();

        // Verify if the user is signed out
        WebElement signInLink = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
        Assert.assertTrue(signInLink.isDisplayed(), "Sign out was not successful");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
