package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
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

		// Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("kau");

		// Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// Click on first resulting lead //
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/a[1]"))
				.click();

		// Verify title of the page gettitle
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("VIEW LEAD | OPENTAPS CRM")) {
			System.out.println("Title Matched");
		} else {
			System.err.println("Title Not Matched");
		}
		// Click Edit //
		driver.findElement(By.xpath("(//a[@class='subMenuButton']/following-sibling::a)[2]")).click();

		// Change the company name
		String oldName = driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).getAttribute("value");
		System.out.println(oldName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys(" 1 ");

		// Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Confirm the changed name appears id
		String newName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(newName);

		if (newName != oldName) {
			System.out.println("Company Name changed Successfully");
		} else {
			System.out.println("Comapny Name Not Changed");
		}

		// Close the browser (Do not log out)
		driver.close();
	}

}
