package sixteenpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAutomation {

    public static void main(String[] args) {
    	
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // URL of the login page
        String url = "https://www.saucedemo.com/";
        driver.manage().window().maximize();

        // Array of usernames
        String[] usernames = { "standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"};

        // Password (same for all users)
        String password = "secret_sauce";  

        // Iterate over each username
        for (String username : usernames) {
            try {
                // Open the login page
                driver.get(url);

                // Locate username and password fields
                WebElement usernameField = driver.findElement(By.id("user-name"));  
                WebElement passwordField = driver.findElement(By.id("password")); 

                // Clear the fields (in case they have any default values)
                usernameField.clear();
                passwordField.clear();

                // Enter username and password
                usernameField.sendKeys(username);
                passwordField.sendKeys(password);

                // Locate and click the login button
                WebElement loginButton = driver.findElement(By.id("login-button")); 
                loginButton.click();

                // Pause for demonstration purposes (wait for the login to process)
                Thread.sleep(5000);

                // Simulate clicking the back button on the browser
                driver.navigate().back();

                // Pause for demonstration purposes (wait for the page to load)
                Thread.sleep(3000);

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Close the browser
        driver.quit();
    }
}