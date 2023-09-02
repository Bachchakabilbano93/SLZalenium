package DockerProject2023.Zalenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomasiPO {
	
	public WebDriver driver;
	
	public AutomasiPO(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public static String URL = "https://testautomasi.com/";
	public static By eLearn = By.xpath("//a[contains(text(),'E-Learning')]");
	public static By cText = By.xpath("//input[@name='c_search']");
	public static By cTitle = By.className("course-title");
	public static By vMore = By.xpath("//a[contains(text(),'View More')]");
	public static By bNow = By.xpath("//button[contains(text(),'Buy Now')]");
	public static String newTabHandle;
	public static Set<String> windowHandles;
	public static String courseTitle;
	public static String actualTitle;
	
	public void changeHandle() {
		
		windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
		    newTabHandle = handle;
		}
		driver.switchTo().window(newTabHandle);
		
	}
	
	public void courseFullName() {
		
		courseTitle = driver.findElement(cTitle).getText();
		
	}
	
	public void pageTitle() {
		
		actualTitle = driver.getTitle();
		
	}
	
}
