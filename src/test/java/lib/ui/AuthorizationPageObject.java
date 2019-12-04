package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.plaf.TableHeaderUI;

public class AuthorizationPageObject extends MainPageObject {
  private static final String
          LOGIN_BUTTON = "xpath://body/div/a[text()='Log in']",//xpath://body/div/a[text()='Log in']//css:.mw-ui-button
          LOGIN_INPUT = "css:#wpName1",//input[name='wpName']
          PASSWORD_INPUT = "css:#wpPassword1",//input[name='wpPassword']
          SUBMIT_BUTTON = "css:button#wpLoginAttempt";

  public AuthorizationPageObject(RemoteWebDriver driver) {
    super(driver);
  }

  public void clickAuthButton() throws InterruptedException {
    Thread.sleep(2000);
    this.waitForElementPresent(LOGIN_BUTTON,"Cannot find Auth button!", 5);
    this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and Login_Button!", 5);
  }

  public void enterLoginData(String login, String password){
    this.waitForElementAndSendKey(LOGIN_INPUT,login,"Cannot find and put Login in login input!",15);
    this.waitForElementAndSendKey(PASSWORD_INPUT,password,"Cannot find and put Password in password input!",15);
  }

  public void submitForm(){
    this.waitForElementAndClick(SUBMIT_BUTTON,"Cannot find and click Submit button!",5);
  }
}
