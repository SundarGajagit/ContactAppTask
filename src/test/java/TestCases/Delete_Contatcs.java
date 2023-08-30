package TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Delete_Contatcs {
	
	WebDriver driver;
	
	@BeforeMethod
	public void browserLaunch() {
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/nagasundareswaran.g/Downloads/contact_app.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void delete_Single_Contact() {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		
		String contact = driver.findElement(By.id("app")).getText();
		Assert.assertFalse(contact.contains("Tester"), "Contact Deleted Successfully");
	}
		
	@Test(priority = 2)
	public void delete_Multiple_Contact() {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Developer");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("818910");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("developer@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("QA");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("168891");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("qa@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[4]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[4]/button[2]")).click();
		
		String deletedcontact1 = driver.findElement(By.id("app")).getText();
		Assert.assertFalse(deletedcontact1.contains("QA"), "Contact Deleted Successfully");
		
		String deletedcontact2 = driver.findElement(By.id("app")).getText();
		Assert.assertFalse(deletedcontact2.contains("Tester"), "Contact Deleted Successfully");
		
	}
}
