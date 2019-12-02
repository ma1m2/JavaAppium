package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
  private static final String
          LOGIN_BUTTON = "css:a.mw-ui-button.mw-ui-progressive",
          LOGIN_INPUT = "css:input#wpName1.loginText.mw-ui-input",
          PASSWORD_INPUT = "css:input#wpPassword1.loginPassword.mw-ui-input",
          SUBMIT_BUTTON = "css:button#wpLoginAttempt";

  public AuthorizationPageObject(RemoteWebDriver driver) {
    super(driver);
  }

  public void clickAuthButton(){
    this.waitForElementPresent(LOGIN_BUTTON,"Cannot find Auth button!", 5);
    this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and Login_Button!", 5);
  }

  public void enterLoginData(String login, String password){
    this.waitForElementAndSendKey(LOGIN_INPUT,login,"Cannot find and put Login in login input!",5);
    this.waitForElementAndSendKey(PASSWORD_INPUT,password,"Cannot find and put Password in password input!",5);
  }

  public void submitForm(){
    this.waitForElementAndClick(SUBMIT_BUTTON,"Cannot find and click Submit button!",5);
  }
}
