package OR;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.PropertiesFile;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath ="//*[@placeholder='Username']")
	private static WebElement username;

	@FindBy(xpath = "//*[@placeholder='Password']")
	private static WebElement password;

	@FindBy(id = "login-button")private static WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void login() throws IOException {
		username.sendKeys(PropertiesFile.getData("username"));
		password.sendKeys(PropertiesFile.getData("password"));
		login.click();
	}

	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}

	public void enterPass(String pass) {
		password.sendKeys(pass);
	}

	public void clickLoginBtn() {
		login.click();
	}
	public boolean checkErrorMessage() {
		List<WebElement> errormsge=driver.findElements(By.xpath("//span[@id='spanMessage']"));
		if(errormsge.size()>0) {
			return true;
		}else {
			return false;
		}


	}
}


