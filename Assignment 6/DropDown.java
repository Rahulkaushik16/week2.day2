package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

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
		driver.get("http://leafground.com/pages/Dropdown.html");

		// Select training program using Index
		Select d1 = new Select(driver.findElement(By.id("dropdown1")));
		d1.selectByIndex(2);

		// Select training program using Text
		Select d2 = new Select(driver.findElement(By.name("dropdown2")));
		d2.selectByVisibleText("Loadrunner");

		// Select training program using Value
		Select d3 = new Select(driver.findElement(By.id("dropdown3")));
		d3.selectByValue("3");

		// Get the number of dropdown options
		Select d4 = new Select(driver.findElement(By.className("dropdown")));
		List<WebElement> options2 = d4.getOptions();
		System.out.println("The Number of Options are : " + options2.size());

		// You can also use sendKeys to select
		driver.findElement(By.xpath("//div[5]//select[1]")).sendKeys("Selenium");

		// Select your programs - Multiselect

		WebElement s1 = driver.findElement(By.xpath("(//option[@value='2'])[6]"));
		WebElement s2 = driver.findElement(By.xpath("(//option[@value='3'])[6]"));
		WebElement s3 = driver.findElement(By.xpath("(//option[@value='4'])[6]"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(s1).click(s2).click(s3).build().perform();

	}

}
