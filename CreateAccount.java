package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize the browser on open

		// InitiatingChromeBrowser
		WebDriver driver = new ChromeDriver(options);

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

		// Click on Accounts Button
		driver.findElement(By.xpath("/html[1]/body[1]/ul[1]/li[4]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();

		// Click on Create Account
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/createAccountForm']")).click();

		// Enter AccountName Field Using Xpath Locator value as Debit Limited Account
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account");

		// Enter DEscriptiion as "Selenium Automation Tester"
		WebElement desc = driver.findElement(By.xpath("//textarea[@name='description']"));
		desc.sendKeys(" \"Selenium Automation Tester\" ");

		// Enter LocalName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Name Local");

		// Enter SiteName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Name site");

		// Enter value for AnnualRevenue Field using Xpath Locator but class as
		// Attribute
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("250000");

		// Select Industry as ComputerSoftware
		driver.findElement(By.xpath("(//select[@class='inputBox'])[2]")).sendKeys("Computer Software");

		// Select OwnerShip as S-Corporation using SelectByVisibletext

		Select owner = new Select(driver.findElement(By.xpath("//select[@name='ownershipEnumId']")));
		owner.selectByVisibleText("S-Corporation");

		// Select Source as Employee using SelectByValue
		Select emp = new Select(driver.findElement(By.xpath("//select[@name='dataSourceId']")));
		emp.selectByValue("LEAD_EMPLOYEE");

		// Select Marketing Campaign as eCommerce Site Internal Campaign using
		// SelectbyIndex
		Select camp = new Select(driver.findElement(By.xpath("//select[@name='marketingCampaignId']")));
		camp.selectByIndex(6);

		// Select State/Province as Texas using SelectByValue
		Select state = new Select(driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']")));
		state.selectByValue("TX");

		// Click on Create Account using Xpath Locator
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();

	}

}
