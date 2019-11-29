package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "id:Java (programming language)";
    TITLE_2 = "id:Java (software platform)";
    FOOTER_ELEMENT = "id:View article in browser";
    OPTION_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
    CLOSE_ARTICLE_BUTTON = "id:Back";
  }

  public iOSArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
