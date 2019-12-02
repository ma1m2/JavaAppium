package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListPageObject extends MainPageObject {

  protected static String
          FOLDER_BY_NAME_TMP,
          REMOVED_FROM_SAVED_BUTTON,
          ARTICLE_BY_TITLE_TMP;//Java (programming language)

  public MyListPageObject(RemoteWebDriver driver) {
    super(driver);
  }

  /*TEMPLATES*/
  public String getFolderByNameTmp(String nameOfFolder) {
    return FOLDER_BY_NAME_TMP.replace("{FOLDER_NAME}", nameOfFolder);
  }

  public String getArticleTitleByXpath(String articleTitle) {
    return ARTICLE_BY_TITLE_TMP.replace("{TITLE}", articleTitle);
  }
  public String getRemoveButtonByTitle(String articleTitle) {
    return REMOVED_FROM_SAVED_BUTTON.replace("{TITLE}", articleTitle);
  }
  /*TEMPLATES*/

  public void openFolderByName(String nameFolder) {
    String folderNameXpath = getFolderByNameTmp(nameFolder);
    this.waitForElementAndClick(
            //By.id("org.wikipedia:id/item_image_1"),//passed always
            folderNameXpath,//failed sometimes
            "Cannot find folder by name " + nameFolder,
            5
    );
  }
  public void clickFolderByName(String nameFolder) {
    String folderNameXpath = getFolderByNameTmp(nameFolder);
    this.waitForElementAndClick(
            //By.id("org.wikipedia:id/item_image_1"),//passed always
            folderNameXpath,//failed sometimes
            "Cannot find folder by name " + nameFolder,
            5
    );
  }

  public void waitForArticleToAppearByTitle(String articleTitle) {
    String articleXpath = getArticleTitleByXpath(articleTitle);
    this.waitForElementPresent(articleXpath, "Cannot find saved article by title " + articleTitle, 15
    );
  }

  public void waitForArticleToDisappearByTitle(String articleTitle) {
    String articleXpath = getArticleTitleByXpath(articleTitle);
    this.waitForElementNotPresent(articleXpath, "Saved article still disappeared by title " + articleTitle, 15
    );
  }

  public void swipeArticleToDelete(String articleTitle) {
    String articleXpath = getArticleTitleByXpath(articleTitle);
    this.waitForArticleToAppearByTitle(articleTitle);
    if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
      this.swipeElementToLeft(
              articleXpath,//"//*[@text='Java (programming language)']"
              "Cannot find saved article " + articleTitle
      );
    }else {
      String removeLocator = getRemoveButtonByTitle(articleTitle);
      this.waitForElementAndClick(removeLocator,"Cannot click button to remove article",10);
    }
    if(Platform.getInstance().isIOS()){
        this.clickElementToTheRightUpperCorner(articleXpath,"Cannot find Red Bin");
    }
    if(Platform.getInstance().isMW()){
      driver.navigate().refresh();
    }
    this.waitForArticleToDisappearByTitle(articleTitle);
  }

  public void removeOverlay(){
      this.tapAnywhe(150,500);
  }

  public void openSecondArticle(String articleTitle){
    String articleXpath = this.getArticleTitleByXpath(articleTitle);
    this.waitForElementAndClick(articleXpath, "Cannot find a title of the Second article", 15);
  }
}
