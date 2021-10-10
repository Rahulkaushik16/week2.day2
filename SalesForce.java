package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// Download and set the path
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		// options.addArguments("Start-Maximized");

		// Launch the chromebrowser
		WebDriver driver = new ChromeDriver(options);

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Load the URL https://en-gb.facebook.com/
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		// Maximize the browser
		driver.manage().window().maximize();

		// Fill in all the text boxes
		driver.findElement(By.name("UserFirstName")).sendKeys("Name1");
		driver.findElement(By.name("UserLastName")).sendKeys("Name2");
		driver.findElement(By.xpath("//input[@name='UserEmail']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("CompanyOne");
		driver.findElement(By.xpath("//input[@name='UserPhone']")).sendKeys("9876543210");

		// Handle all the dropdowns
		Select job = new Select(driver.findElement(By.name("UserTitle")));
		job.selectByIndex(3);

		Select emp = new Select(driver.findElement(By.name("CompanyEmployees")));
		emp.selectByVisibleText("15 - 100 employees");

		Select country = new Select(driver.findElement(By.name("CompanyCountry")));
		country.selectByValue("SG");

		Select state = new Select(driver.findElement(By.name("CompanyState")));
		state.selectByIndex(1);

		// Click the check box
		driver.findElement(By.xpath("(//div[contains(@class,'checkbox-ui')])[1]")).click();

		// Close the browser
		driver.close();

	}

}
