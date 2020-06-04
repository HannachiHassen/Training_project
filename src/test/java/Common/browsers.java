package Common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class browsers {
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
  @BeforeClass
  @Parameters({"url","browser"})
  public void beforeClass(String wbsite, String br) {
	if(br.equalsIgnoreCase("chrome")){
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	}else if(br.equalsIgnoreCase("firefox")) {
	  System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver.exe");
	  driver=new FirefoxDriver();
	}else{
		System.out.println("Incorrect browser value passed! Please check name of the borwser.");
	 }
	  driver.navigate().to(wbsite);
	  driver.manage().window().maximize();
	  System.out.println("The Type of browser used for for this test is: "+br);
	}

  @AfterClass
  public void afterClass() {
  }
  public void screenshots(String source) throws IOException {
		 
	  File shots=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(shots,new File(source+timestamp()+"screenshot.png"));
			}
  public String timestamp() {
      return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
  }
}
