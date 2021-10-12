package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String[] args) {
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize the browser on open

		// InitiatingChromeBrowser
		WebDriver driver = new ChromeDriver(options);

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leafground.com/pages/checkbox.html");

		// Select the languages that you know?
		driver.findElement(By.xpath("//div[normalize-space()='Java']//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='SQL']//input[@type='checkbox']")).click();

		// Confirm Selenium is checked
		System.out.println(driver.findElement(By.xpath("//div[normalize-space()='Selenium']//input[@type='checkbox']"))
				.isSelected());

		// DeSelect only checked
		driver.findElement(By.xpath("//div[normalize-space()='I am Selected']//input[@type='checkbox']")).click();
		System.out.println(
				driver.findElement(By.xpath("//div[normalize-space()='I am Selected']//input[@type='checkbox']"))
						.isSelected());

		// Select all below checkboxes

		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[2]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[3]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[4]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[5]")).click();

	}

}
