package Test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import OR.LoginPage;
import Utility.Base;
import Utility.PropertiesFile;
import Utility.Screenshot;

public class LoginTest extends Base{
	@Test
	public static void validateLogin() throws IOException, InterruptedException  {
		WebDriver driver=LaunchURL();
		LoginPage l=new LoginPage(driver);
		l.login();
		if(l.checkErrorMessage()) {
			System.out.println("Login test is failled");
		} else {
			System.out.println("Login test is pass");
		}
		Screenshot.getPhoto(driver, "FirstTestCase");
		driver.close();
	}
}
