package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MVSearchPageObject extends SearchPageObject {
  static {
    SEARCH_INIT_ELEMENT = "css:button#searchIcon";
    SEARCH_INPUT = "css:form>input[type='search']";
    //css:form>input.search
    SEARCH_CANCEL_BUTTON = "css:.header-action > .mw-ui-icon";
    //"css:button.cancel" - don't work, ElementNotVisibleException, found 2 element
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
    //<div class="wikidata-description">Object-oriented programming language</div>
    //xpath=//a[contains(@href, '/wiki/Java_(programming_language)')]
    SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
    SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
  }

  public MVSearchPageObject(RemoteWebDriver driver) {
    super(driver);
  }
}
