package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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

		// Click on Phone
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[2]/em[1]/span[1]/span[1]"))
				.click();

		// Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("98");

		// Click find leads button
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/em[1]/button[1]"))
				.click();

		// Capture lead ID of First Resulting lead
		WebElement ele = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/a[1]"));
		String no = ele.getText();
		System.out.println(no);

		// Click First Resulting lead
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/a[1]"))
				.click();

		// Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();

		// Click Find leads
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();

		// Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(no);

		// Click find leads button
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion

		String text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();

		if (text.equalsIgnoreCase("NO RECORDS TO DISPLAY")) {
			System.out.println("Record Deleted Successfully");

		} else {
			System.err.println("Record Not Deleted");
		}

		// Close the browser (Do not log out)
		driver.close();

	}

}
