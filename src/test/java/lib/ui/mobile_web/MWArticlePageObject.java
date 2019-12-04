package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "css:#content h1";//Java (programming language)
    TITLE_2 = "css:#content h1";//Java
    LINK_INSTEAD_OF_TITLE_2 = "css:#mf-section-0 > p:nth-child(2) > a:nth-child(2)";
    FOOTER_ELEMENT = "css:footer";
    OPTION_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[contains(text(),'Unwatch')]";//#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button
    OPTION_ADD_TO_MY_LIST_BUTTON = "xpath://a[contains(text(),'Watch')]";//"css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button
  }

  //OPTION_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch a";
  //        OPTION_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched a";
  //        TITLE_ELEMENT = "css:#mw-content-text .title";

  public MWArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
