package luma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccount {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testCreateAccount() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");

        // Find the "Create an Account" link and click it
        WebElement createAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAccountLink.click();

        // Wait for the create account page to load
        Thread.sleep(2000);

        // Fill in the account details
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        firstNameField.sendKeys("Naysha");

        WebElement lastNameField = driver.findElement(By.id("lastname"));
        lastNameField.sendKeys("Sharma");

        WebElement emailField = driver.findElement(By.id("email_address"));
        emailField.sendKeys("naysha@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password@345");

        WebElement confirmPasswordField = driver.findElement(By.id("password-confirmation"));
        confirmPasswordField.sendKeys("Password@345");

        // Find the "Create an Account" button and click it
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
        createAccountButton.click();

        // Wait for account creation process
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
