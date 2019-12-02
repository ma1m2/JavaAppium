package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "css:#content h1";//Java (programming language)
    TITLE_2 = "id:Java (software platform)";
    FOOTER_ELEMENT = "css:footer";
    OPTION_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[contains(text(),'Unwatch')]";//a#ca-watch.mw-ui-icon-wikimedia-star-base20
    OPTION_ADD_TO_MY_LIST_BUTTON = "xpath://a[contains(text(),'Watch')]";//css:a[title=Watch]//xpath://a[contains(text(),'Watch')]//xpath://*[@id='ca-watch']
  }

  public MWArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
