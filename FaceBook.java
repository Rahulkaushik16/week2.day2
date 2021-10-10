package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();

		// Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Name1");

		// Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Name2");

		// Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");

		// Enterthe password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("123@456_0079Abc");

		// Handle all the three drop downs
		Select dobDay = new Select(driver.findElement(By.id("day")));
		dobDay.selectByIndex(10);

		Select dobMonth = new Select(driver.findElement(By.id("month")));
		dobMonth.selectByVisibleText("Feb");

		Select dobYear = new Select(driver.findElement(By.id("year")));
		dobYear.selectByValue("2000");

		// Select the radio button "Female"

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[1]/label[1]"))
				.click();

	}

}
