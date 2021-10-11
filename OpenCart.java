package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	public static void main(String[] args) {

		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize the browser on open

		// InitiatingChromeBrowser
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.opencart.com/index.php?route=account/register");

		driver.findElement(By.id("input-username")).sendKeys("TestUser");

		//
		driver.findElement(By.id("input-firstname")).sendKeys("Test");

		//
		driver.findElement(By.id("input-lastname")).sendKeys("User");

		//
		driver.findElement(By.id("input-email")).sendKeys("User@gmail.com");

		//
		Select country = new Select(driver.findElement(By.id("input-country")));
		country.selectByValue("99");

		//
		driver.findElement(By.id("input-password")).sendKeys("234@Password");

		//
		boolean flag = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		System.out.println(flag);

		driver.findElement(By.id("input-username")).clear();

		driver.findElement(By.xpath("(//a[@href='https://www.opencart.com/index.php?route=account/login'])[2]"))
				.click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(driver.findElement(By.xpath("//div[@id='account-login']/div[2]/div[1]")).getText());

		driver.close();
		
		
		// Snippet for Captcha

		/*
		 * driver.findElement(By.xpath("//ul[@class='list-inline']//img")).click();
		 * String str = driver.findElement(By.className("bg-info")).getText();
		 * System.out.println(str);
		 * 
		 * while(str.contains("Click or touch the")) {
		 * driver.findElement(By.xpath("//ul[@class='list-inline']//img")).click();
		 * break;
		 * 
		 * }
		 * 
		 * boolean register =
		 * driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		 * System.out.println(register);
		 */

	}

}
