package Automation.MobileWorld;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mobile_application 
{
	@Test
	public void Mobile() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bharath.j\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		//launch chrome
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//launching the website
		driver.get("https://mobileworld.azurewebsites.net/");
		//sign up
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		//sign up entering the details
		driver.findElement(By.className("form-control")).sendKeys("james",Keys.TAB,"bond",Keys.TAB,"jamesbond@gmail.com",Keys.TAB,"james@1234");
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("18041998");
		driver.findElement(By.xpath("//form[@id=\"myForm\"]/div[3]/div[3]/input")).click();
		driver.findElement(By.cssSelector("[type='number']")).sendKeys("9876504321");
		driver.findElement(By.xpath("//textarea[@placeholder='Short Bio']")).sendKeys("hi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		alt.accept();
		//sign in page of mobile
		driver.findElement(By.id("username")).sendKeys("jamesbond@gmail.com",Keys.TAB,"james@1234",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);
		//search mobile
		driver.findElement(By.xpath("(//a[text()='More Details'])[4]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search your Mobile name here']")).sendKeys("apple",Keys.ENTER);
		driver.findElement(By.xpath("(//a[@class='btn btn-primary waves-effect waves-light'])[5]")).click();
		Set<String> allid=driver.getWindowHandles();
		Iterator<String>it=allid.iterator();
		String id=it.next();
		String cid=it.next();
		driver.switchTo().window(cid);
		driver.findElement(By.id("inputFirstName")).sendKeys("james",Keys.TAB,"bond",Keys.TAB,"jamesbond@gmail.com",Keys.TAB,"james@1234");
		Thread.sleep(3000);
		driver.quit();
	}
}