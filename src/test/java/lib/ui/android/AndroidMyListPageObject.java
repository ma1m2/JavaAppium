package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListPageObject {
  static {
    FOLDER_BY_NAME_TMP = "xpath://*[@text='{FOLDER_NAME}']";
    ARTICLE_BY_TITLE_TMP = "xpath://*[@text='{TITLE}']";//Java (programming language)
  }

  public AndroidMyListPageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
