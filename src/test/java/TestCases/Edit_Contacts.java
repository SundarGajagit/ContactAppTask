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

public class Edit_Contacts {
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
	public void edit_Name() {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]/input")).sendKeys("Tester1");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		String editedName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		Assert.assertTrue(editedName.contains("Tester1"), "Name does not Edited");
		
	}
	
	@Test(priority = 2)
	public void edit_Phone() {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/input")).sendKeys("720010");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		String editedNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		Assert.assertTrue(editedNumber.contains("720010"), "Number does not Edited");
		
	}
	
	@Test(priority = 3)
	public void edit_Email() {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]/input")).clear();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]/input")).sendKeys("qa@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		String editedNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		Assert.assertTrue(editedNumber.contains("qa@gmail.com"), "Email does not Edited");
		
	}
	
	
}
