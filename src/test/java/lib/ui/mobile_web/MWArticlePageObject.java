package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "css:#content h1";//Java (programming language)
    TITLE_2 = "id:Java (software platform)";
    FOOTER_ELEMENT = "css:footer";
    OPTION_ADD_TO_MY_LIST_BUTTON = "css:a#ca-watch";//a#ca-watch
  }

  public MWArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
