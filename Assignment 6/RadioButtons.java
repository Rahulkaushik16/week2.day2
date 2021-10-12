package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize the browser on open

		// InitiatingChromeBrowser
		WebDriver driver = new ChromeDriver(options);

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leafground.com/pages/radio.html");

		// Are you enjoying the classes?
		driver.findElement(By.xpath("//input[@id='yes']")).click();

		// Find default selected radio button
		System.out.println(driver.findElement(By.xpath("//label[@for='Checked']")).getAttribute("for"));

		// Select your age group (Only if choice wasn't selected)
		driver.findElement(By.xpath("(//input[@name='age'])[2]")).click();

	}

}
