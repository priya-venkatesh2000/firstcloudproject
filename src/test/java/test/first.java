package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class first {

	@Test
	public void login() {
WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,50);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	driver.get("http://magento.com");
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("email")).sendKeys("priyans@hotmail.com");
	driver.findElement(By.id("pass")).sendKeys("wugfwghcs");
	driver.findElement(By.id("send2")).click();
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\\\"maincontent\\\"]/div[2]/div[2]/div/div/div")));
	String msg=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();		
	
	System.out.println(msg);
	if(msg.equals("Invalid login or password.")) {
		
		System.out.println("Test case passed");
		
	}
		
			driver.quit();	

		
}

	@Test
	public void Register() {
	WebDriverManager.chromedriver().setup();	
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait= new WebDriverWait(driver,40);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://magento.com");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")));
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.xpath("//*[@id=\"register\"]/span")).click();
	driver.findElement(By.id("firstname")).sendKeys("Priya");
	driver.findElement(By.id("lastname")).sendKeys("Venkatesh");
	driver.findElement(By.id("email_address")).sendKeys("priyans@hotmail.com");

	Select cp=new Select(driver.findElement(By.id("company_type")));
	//cp.selectByIndex(3);
	cp.selectByValue("selling");
	//cp.selectByVisibleText("Is a merchant who sells online");

	Select ir=new Select(driver.findElement(By.id("individual_role")));
	ir.selectByValue("business/sales/marketing/merchandising");

	Select c=new Select(driver.findElement(By.id("country")));
	c.selectByValue("AL");

	driver.findElement(By.id("password")).sendKeys("welcome1234*");
	driver.findElement(By.id("password-confirmation")).sendKeys("welcome1234*");



	if(!driver.findElement(By.id("agree_terms")).isSelected()){

	driver.findElement(By.id("agree_terms")).click();

	//driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div/button")).click();

	driver.quit();
	}
			






}
}

