package BabyMd.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test {
     WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeTest
    public void setup(){
        System.out.println("Initializing the driver");
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
                  // Extent Reports configuration
                  report=new ExtentReports("/Users/indianrenters/Documents/BabyMD_Automation/report/index.html",true);
                  test =report.startTest("ElevateNow Test Suite");
       driver.manage().window().maximize();
    }
@org.testng.annotations.Test
public void chatWithExpert() throws InterruptedException {
    driver.get("https://babymd.in/");
    test.log(LogStatus.INFO, "Navigated to the website");
    Thread.sleep(3000);
    System.out.println("Navigated to the website");
    test.log(LogStatus.INFO, "Navigated to the website");
    driver.findElement(By.xpath("//html/body/div[1]/div/main/div/div[1]/div/div/div[1]/div/button[2]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/form/div[2]/div[1]/div/input")).sendKeys("adminTest");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/form/div[2]/div[2]/input")).sendKeys("8899776655");
    Thread.sleep(3000);
    //driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/form/div[2]/div[3]/input")).click();
    Thread.sleep(8000);

    driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/form/div[4]/button")).click();
    Thread.sleep(3000);
    test.log(LogStatus.INFO, "Clicked on submit");
}

    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
        report.endTest(test);
        report.flush();
    
}
}