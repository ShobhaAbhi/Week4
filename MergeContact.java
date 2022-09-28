package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		 //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		//3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//4.Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@id='label']//a[1]")).click();
		//5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//7.Click on Widget of From Contact
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//table//a//img[@src='/images/fieldlookup.gif']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();

		// 8. Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newwindow= new ArrayList<String>(windowHandles);
		driver.switchTo().window(newwindow.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(newwindow.get(0));

		 //9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		 //10.Click on Second Resulting Contact
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> newwindow1= new ArrayList<String>(windowHandles1);
		driver.switchTo().window(newwindow1.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(newwindow1.get(0));

		//11.Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//Simple Alert:switch the control
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();//ctrl+2+l
	    System.out.println(text);
	        //click ok 
	        alert.accept();
		
	}
}
		    
		    
		    
		    
		    
		