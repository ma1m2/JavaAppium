package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
  protected static String
          MY_LISTS_LINK,
          OPEN_NAVIGATION;

//css=#mw-mf-main-menu-button

//<a title="Open main menu" href="/wiki/Special:MobileMenu"
// class="mw-ui-icon mw-ui-icon-element mw-ui-icon-minerva-mainmenu main-menu-button mw-ui-icon-flush-left"
// data-event-name="ui.mainmenu" id="mw-mf-main-menu-button">Open main menu</a>

//<a href="/wiki/Special:Watchlist" class="mw-ui-icon mw-ui-icon-before mw-ui-icon-minerva-watchlist "
// data-event-name="menu.watchlist"><span>Watchlist</span></a>

  //<li class="page-summary with-watchstar" title="Java (programming language)"
// data-id="15881"><a href="/wiki/Java_(programming_language)" class="title"><div
// class="list-thumb list-thumb-placeholder list-thumb-x list-thumb-none"></div>
// <h3>Java (programming language)</h3><div class="info"><span class="last-modified-bar__text">Last edited 4 hours ago by 103.103.209.131</span></div></a>
// <a class="mw-ui-icon mw-ui-icon-wikimedia-unStar-progressive mw-ui-icon-element   watch-this-article watched"
// href="/w/index.php?title=Java_(programming_language)&amp;action=unwatch"></a></li>
  public NavigationUI(RemoteWebDriver driver) {
    super(driver);
  }

  public void openNavigation() {
    if(Platform.getInstance().isMW()){
        this.waitForElementAndClick(OPEN_NAVIGATION,"Cannot find and click navigation button",5);
    }else {
        System.out.println("Method openNavigation does nothing for this platform " + Platform.getInstance().getPlatformVar());
    }
  }

  public void clickMyLists() {
    if (Platform.getInstance().isMW()) {
      this.tryClickElementWithFewAttempts(
              MY_LISTS_LINK,
              "Cannot find navigation button to My list",
              5
      );
    } else {
      this.waitForElementAndClick(
              MY_LISTS_LINK,
              "Cannot find navigation button to My list",
              5
      );
    }
  }
}
