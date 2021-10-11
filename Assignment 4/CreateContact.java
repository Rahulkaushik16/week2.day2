package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize the browser on open

		// InitiatingChromeBrowser
		WebDriver driver = new ChromeDriver(options);
		
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		String loginWidgetText = driver.findElement(By.tagName("h2")).getText();
		System.out.println("Login Widget Title is : " + loginWidgetText);

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/contactsMain']")).click();

		// Click on Create Contact
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/createContactForm']")).click();

		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Name 1");

		// Enter LastName Field Using id Locator //
		driver.findElement(By.id("lastNameField")).sendKeys("Name 2");

		// Enter FirstName(Local) Field Using id Locator ////
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Local 1");

		// Enter LastName(Local) Field Using id Locator //
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Local 2");

		// Enter Department Field Using any Locator of Your Choice //
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("STU");

		// Enter Description Field Using any Locator of your choice //
		driver.findElement(By.id("createContactForm_description")).sendKeys("Desc Test");

		// Enter your email in the E-mail address Field using the locator of your choice
		// //
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("test@gmail.com");

		// Select State/Province as NewYork Using Visible Text //
		Select state = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		state.selectByVisibleText("New York");

		// Click on Create Contact // name
		driver.findElement(By.name("submitButton")).click();

		// Click on edit button
		driver.findElement(By.linkText("Edit")).click();

		// Clear the Description Field using .clear //
		driver.findElement(By.id("updateContactForm_description")).clear();

		// Fill ImportantNote Field with Any text //
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Imp Test");

		// Click on update button using Xpath locator //
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Get the Title of Resulting Page.
		System.out.println(driver.getTitle());

	}

}
