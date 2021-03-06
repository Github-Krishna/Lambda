package demo;


import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Selenium101 {

	
	public static String username = "mani4malar";
	public static String accessKey ="Exw4ubToj9oTol6CLEDt8cizUL0K7xge9VqltQI7TuISc3srp9";
		public static WebDriver driver;
	public static String status = "failed";

	@BeforeTest(alwaysRun=true)
	@Parameters(value = { "browser", "version", "platform" })
	public void setUp(String browser, String version, String platform) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability(CapabilityType.PLATFORM, platform);
		capabilities.setCapability("build", "Lambdatest selenium 101 certification");
		capabilities.setCapability("name", "Lambdatest selenium 101 certification");
		capabilities.setCapability("network", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("console", true);
		capabilities.setCapability("visual", true);
		capabilities.setCapability("userFiles","jenkins.svg");
		String gridURL = "http://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
		try {
			driver = new RemoteWebDriver(new URL(gridURL), capabilities);
		    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

		} catch (Exception e) {
			System.out.println("driver error");
			System.out.println(e.getMessage());
		}
			
	}

	@Test
	public static void test() throws Exception {
		try {
			
	                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			driver.get("https://www.lambdatest.com/automation-demos/");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElement(By.id("username")).sendKeys("lambda");

			driver.findElement(By.id("password")).sendKeys("lambda123");

			driver.findElement(By.xpath("//a[@class='cbtn btn_accept_ck']")).click();

			driver.findElement(By.xpath("//button[@class='applynow']")).click();

			driver.findElement(By.id("developer-name")).sendKeys("mani4malar@gmail.com");

			driver.findElement(By.id("populate")).click();

			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				// TODO: handle exception
			}

			driver.findElement(By.id("6months")).click();

			driver.findElement(By.id("customer-service")).click();

			driver.findElement(By.id("discounts")).click();

			driver.findElement(By.id("tried-ecom")).click();

			driver.findElement(By.id("comments")).sendKeys("Test user feedback here");

			driver.findElement(By.tagName("body")).click();

			WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
			js.executeScript("arguments[0].style.display='block';", element);
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\mani4\\Downloads\\jenkins.svg");

			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			driver.findElement(By.id("submit-button")).click();

			Assert.assertEquals(driver.findElement(By.id("message")).getText().contains("Thank you!"), true);
			status = "passed";
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status + "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} catch (Error e) {
			System.out.println("Assert failed");
		}
		
		System.out.println("Status :"+status);

	}

	@AfterTest
	public static void afterTest() {
		((JavascriptExecutor) driver).executeScript("lambda-status=" + status + "");
		driver.quit();
	}
}

