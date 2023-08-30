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

import TestUtils.ExcelUtilsQA;

public class Add_Contacts {
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
	
	@Test (dataProvider ="TestData",dataProviderClass = ExcelUtilsQA.class , priority = 1)
	public void add_all_fields(String Name, String number, String email) {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys(Name);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys(number);
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys(email);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		String enteredNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		String enteredEmail = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		Assert.assertTrue(enteredName.contains(Name), "Name does not added");
		Assert.assertTrue(enteredNumber.contains(number), "Number does not added");
		Assert.assertTrue(enteredEmail.contains(email), "Email does not added");
		
			
	}
	
	@Test(priority = 2)
	public void adding_Name_And_Phone_Only()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		String enteredNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		
		Assert.assertTrue(enteredName.contains("Tester"), "Name does not added");
		Assert.assertTrue(enteredNumber.contains("978747"), "Number does not added");
	
	}
	
	@Test(priority = 3)
	public void adding_Name_And_Email_Only()  {

		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		String enteredEmail = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		
		Assert.assertTrue(enteredName.contains("Tester"), "Name does not added");
		Assert.assertTrue(enteredEmail.contains("tester@gmail.com"), "Email does not added");
	
	}
	
	@Test(priority = 4)
	public void adding_Phone_And_Email_Only()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		String enteredEmail = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		
		Assert.assertTrue(enteredNumber.contains("978747"), "Number does not added");
		Assert.assertTrue(enteredEmail.contains("tester@gmail.com"), "Email does not added");
	
	}
	
	@Test(priority = 5)
	public void adding_Name_Only()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		
		Assert.assertTrue(enteredName.contains("Tester"), "Name does not added");
	
	}
	
	@Test(priority = 6)
	public void adding_Phone_Only()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		
		Assert.assertTrue(enteredNumber.contains("978747"), "Number does not added");
	
	}
	
	@Test(priority = 7)
	public void adding_Email_Only()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("testrer@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredEmail = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		
		Assert.assertTrue(enteredEmail.contains("testrer@gmail.com"), "Email does not added");
	
	}
	
	@Test(priority = 8)
	public void adding_SpecialCharacters_In_Name_Field()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("$testrer@");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		
		Assert.assertTrue(enteredName.contains("$testrer@"), "Name does not added");
	
	}
	
	@Test(priority = 9)
	public void adding_SpecialCharacters_In_Phone_Field()  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("$978781");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredNumber = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		
		Assert.assertTrue(enteredNumber.contains("$978781"), "Name does not added");
	
	}
	
	@Test(priority = 10)
	public void adding_Multiple_Contacts() throws InterruptedException  {
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester1");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978747");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester1@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[1]")).getText();
		String enteredNumber1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		String enteredEmail1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		
		Assert.assertTrue(enteredName1.contains("Tester1"), "First Name does not added");
		Assert.assertTrue(enteredNumber1.contains("978747"), "First Number does not added");
		Assert.assertTrue(enteredEmail1.contains("tester1@gmail.com"), "First Email does not added");
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("Tester2");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("978748");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/input")).sendKeys("tester2@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String enteredName2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[1]")).getText();
		String enteredNumber2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]")).getText();
		String enteredEmail2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[3]")).getText();
		
		Assert.assertTrue(enteredName2.contains("Tester2"), "Second Name does not added");
		Assert.assertTrue(enteredNumber2.contains("978748"), "Second Number does not added");
		Assert.assertTrue(enteredEmail2.contains("tester2@gmail.com"), "Second Email does not added");
		
		Thread.sleep(5000);
	}
}
