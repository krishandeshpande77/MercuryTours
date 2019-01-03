package MavenProject.MaveenProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MecuryTours 
{
	public WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver","G:\\Software\\Selenium\\Updated\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void OpenUrl()
	{
		driver.get("http://newtours.demoaut.com/");
	}
	
	@Test(priority=3)
	public void MaxBrowser()
	{
		driver.manage().window().maximize();
	}
	
	@Test(priority=4)
	public void loginvalid()
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("suvidyap2");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		List<WebElement> ele=driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));
		AssertJUnit.assertTrue(ele.size()==1);
		driver.findElement(By.xpath("//a[text()='SIGN-OFF']")).click();
	}
	
	@Test(priority=5)
	public void invalidlogin()
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("gaju7577");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("45678910");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		List<WebElement> ele=driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));
		AssertJUnit.assertFalse(ele.size()==1);
	}
	
}
