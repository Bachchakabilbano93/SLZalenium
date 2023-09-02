package AutomasiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DockerProject2023.Zalenium.AutomasiPO;

public class StepDefinitions {

    public static WebDriver driver;
    AutomasiPO Obj;
    
    
    @Before
    public void open_browser() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

		caps.setCapability("zal:name", "testaba2 ");
		caps.setCapability("zal:tz", "Europe/Berlin");
		caps.setCapability("zal:recordVideo", "true");
		caps.setCapability("zal:screenResolution", "1920x1058");
//		caps.setCapability("zal:idleTimeout", 180);
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-infobars"); // disabling infobars
//		options.addArguments("--disable-extensions"); // disabling extensions
//		options.addArguments("--disable-gpu"); // applicable to windows os only
//		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//		options.addArguments("--no-sandbox"); // Bypass OS security model
//		options.addArguments("--headless"); // Bypass OS security model
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		
		try {
//			driver = new RemoteWebDriver(new URL("http://3.90.255.127:4444/wd/hub"), options);
			driver = new RemoteWebDriver(new URL("http://50.16.108.19:4444/wd/hub"), caps);
			Obj = new AutomasiPO(driver);
			Thread.sleep(3000);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    
//    @Then("Verify the correct Course {string} is displayed")
//    public void verify_the_correct_course_is_displayed(String expectedCourse) {
////        WebElement courseResult = driver.findElement(By.xpath("//h2[contains(text(),'" + expectedCourse + "')]"));
////        assertTrue(courseResult.isDisplayed());
//    }

//    @When("The user clicks on View More")
//    public void the_user_clicks_on_view_more() {
//
//    }

//    @Then("Verify that the correct Course page is opened")
//    public void verify_correct_course_page_opened() {
////        expectedTitle = "Course Page Title";  // Replace with the expected title
////        actualTitle = driver.getTitle();
////        assertEquals(expectedTitle, actualTitle);
//    }
    
    @Given("^The user is on TestAutomasi Home Page$")
    public void the_user_is_on_testautomasi_home_page() throws Throwable {
    	driver.get(Obj.URL);
    	Thread.sleep(3000);
    }

    @When("^The user clicks on E-Learning$")
    public void the_user_clicks_on_elearning() throws Throwable {
    	driver.findElement(Obj.eLearn).click();
    	Thread.sleep(3000);
//    	java.util.Set<String> windowHandles = driver.getWindowHandles();
//    	String[] windowHandlesArray = windowHandles.toArray(new String[0]);
//    	String newTabHandle = windowHandlesArray[windowHandlesArray.length - 1];
//    	driver.switchTo().window(newTabHandle);
    }

    @When("^The user searches for (.+)$")
    public void the_user_searches_for(String Courses) throws Throwable {
    	Obj.changeHandle();    	
    	driver.findElement(Obj.cText).sendKeys(Courses);
    	Thread.sleep(3000);
    }

    @When("^The user clicks on View More$")
    public void the_user_clicks_on_view_more() throws Throwable {
    	Thread.sleep(3000);
        driver.findElement(Obj.vMore).click();
    }

    @Then("^Verify the correct Course is displayed$")
    public void verify_the_correct_course_is_displayed() throws Throwable {
        String[] courseName = {"Jmeter","Selenium","Appium"};
        Obj.courseFullName();
        String currentCourse = Obj.courseTitle;
        boolean courseFound = false; 
        for (String cName : courseName) {
        	if (currentCourse.contains(cName)) {
				courseFound = true;
				break;
			}
        }
        
        Assert.assertTrue(courseFound);
        
    }


    @Then("^Verify that the correct Course page is opened$")
    public void verify_that_the_correct_course_page_is_opened() throws Throwable {
    	Thread.sleep(3000);
    	Obj.pageTitle();
    	String[] coursePageTitle = {"Performance Engineering Tests Using Jmeter with Groovy","UI Tests Automation Using Selenium & Java","Android Mobile Application Testing Using Appium"};
    	String currentPageTitle = Obj.actualTitle;
    	boolean correctPageTitle = false;
    	for (String title : coursePageTitle) {
			if (currentPageTitle.contains(title)) {
				correctPageTitle = true;
				break;
			}
		}
    	
    	Assert.assertTrue(correctPageTitle);
    	    	
    }

    @After
    public void quit_browser() {
        driver.quit();
    }
}

