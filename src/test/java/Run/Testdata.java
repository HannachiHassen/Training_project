package Run;

import org.testng.annotations.Test;

import Com.pages.Home;
import Common.browsers;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class Testdata extends browsers{
  @Test(dataProvider = "signin")
  public void f(String n, String s) {
	    Home h=new Home(driver);
		h.Emailidfield(n);
		h.psswordfield(s);
		h.loginbt();
		driver.navigate().back();
		h.clearuser();
		Reporter.log("Executed successfully");
  }

  @DataProvider
  public Object[][] signin() {
    return new Object[][] {
      new Object[] { "shabaz@gmail.com", "a" },
      new Object[] { "pitt@gmail.com", "b" },
      new Object[] { "payment@gmail.com", "c" },
    };
  }
}
