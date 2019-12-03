package lib.ui.ios;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "id:Java (programming language)";
    TITLE_2 = "id:Java";//XCUIElementTypeLink[@name='Java Island of Indonesia']
    LINK_INSTEAD_OF_TITLE_2 = "id:Indonesia";
    FOOTER_ELEMENT = "id:View article in browser";
    OPTION_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
    CLOSE_ARTICLE_BUTTON = "id:Back";
  }

  public iOSArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
