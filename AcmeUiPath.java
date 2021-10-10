package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeUiPath {

	public static void main(String[] args) {

		// Download and set the path
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize browser on open

		// Launch the chromebrowser
		WebDriver driver = new ChromeDriver(options);

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");

		// Enter email as "kumar.testleaf@gmail.com"
		WebElement eleUser = driver.findElement(By.id("email"));
		eleUser.clear();
		eleUser.sendKeys("kumar.testleaf@gmail.com");

		// Enter Password as "leaf@12"
		WebElement elePass = driver.findElement(By.id("password"));
		elePass.clear();
		elePass.sendKeys("leaf@12");

		// Click login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Get the title of the page and print
		System.out.println("The Page Title is : " + driver.getTitle());

		// Click on Log Out
		driver.findElement(By.linkText("Log Out")).click();

		// Close the browser
		driver.close();

	}

}
