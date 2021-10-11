package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		// options.setExperimentalOption("w3c", true);
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

		// Click Leads link
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/leadsMain']")).click();

		// Click Find leads
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();

		// Click on Email //
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[2]/em[1]/span[1]/span[1]"))
				.click();

		// Enter Email //
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("@gmail.com");

		// Click find leads button //
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/em[1]/button[1]"))
				.click();

		// Capture name of First Resulting lead //
		String fName = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/a[1]"))
				.getText();
		System.out.println(fName);
		// Click First Resulting lead//
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/a[1]"))
				.click();

		// Click Duplicate Lead //
		driver.findElement(By.linkText("Duplicate Lead")).click();

		// Verify the title as 'Duplicate Lead' //gettitle
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("DUPLICATE LEAD | OPENTAPS CRM")) {
			System.out.println("Title Matched");
		} else {
			System.err.println("Title Not Matched");
		}

		// Click Create Lead //
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		// Confirm the duplicated lead name is same as captured name // id=
		String lName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(lName);

		if (fName.equals(lName)) {
			System.out.println("Duplicate Lead");
		} else {
			System.err.println("Not Duplicated");
		}

		// Close the browser (Do not log out)
		driver.close();

	}

}
