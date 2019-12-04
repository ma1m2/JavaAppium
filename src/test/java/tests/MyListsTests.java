package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
  private static final String NAME_OF_FOLDER = "ReadLater";
  private static final String SEARCH_LINE = "Java";
  private static final String LOGIN = "Sveta 2607";
  private static final String PASSWORD = "W1234asdf#";

  @Test//3_03; 4_06
  public void testSaveArticleToMyList() {
    SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

    searchPageObject.initSearchInput();
    searchPageObject.typeSearchLine(SEARCH_LINE);
    searchPageObject.clickArticleBySubstring("bject-oriented programming language");

    ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
    articlePageObject.waitForTitleElement();
    String articleTitle = articlePageObject.getArticleTitle();

    if (Platform.getInstance().isAndroid()) {
      articlePageObject.addArticleToMyList(NAME_OF_FOLDER);
    } else {
      articlePageObject.addArticleToMySaved();
    }
    if (Platform.getInstance().isMW()) {
      AuthorizationPageObject auth = new AuthorizationPageObject(driver);
      auth.clickAuthButton();
      auth.enterLoginData(LOGIN, PASSWORD);
      auth.submitForm();

      articlePageObject.waitForTitleElement();
      assertEquals("We are not on the same page after login", articleTitle, articlePageObject.getArticleTitle());
      articlePageObject.addArticleToMySaved();
    }
    articlePageObject.closeArticle();

    NavigationUI navigationUI = NavigationUIFactory.get(driver);
    navigationUI.openNavigation();
    navigationUI.clickMyLists();

    MyListPageObject myListPageObject = MyListPageObjectFactory.get(driver);
    if (Platform.getInstance().isAndroid()) {
      myListPageObject.openFolderByName(NAME_OF_FOLDER);
    }
    if (Platform.getInstance().isMW()) {
      driver.navigate().refresh();
    }
    if (Platform.getInstance().isIOS()) {
      myListPageObject.removeOverlay();
    }

    myListPageObject.swipeArticleToDelete(articleTitle);

    System.out.println("Well done! The testSaveArticleToMyList has been passed successfully!");
  }

  @Test//8_lesson_HW_Ex17
  public void testSaveTwoArticleIntoOneFolder() {
    SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
    searchPageObject.initSearchInput();
    searchPageObject.typeSearchLine(SEARCH_LINE);
    searchPageObject.clickArticleBySubstring("bject-oriented programming language");

    ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
    articlePageObject.waitForTitleElement();
    String articleTitle= articlePageObject.getArticleTitle();

    if (Platform.getInstance().isAndroid()) {
      articlePageObject.addArticleToMyList(NAME_OF_FOLDER);
    } else {
      articlePageObject.addArticleToMySaved();
    }
    if (Platform.getInstance().isMW()) {
      AuthorizationPageObject auth = new AuthorizationPageObject(driver);
      auth.clickAuthButton();
      auth.enterLoginData(LOGIN, PASSWORD);
      auth.submitForm();

      articlePageObject.waitForTitleElement();
      assertEquals("We are not on the same page after login", articleTitle, articlePageObject.getArticleTitle());
      articlePageObject.addArticleToMySaved();
    }
    articlePageObject.closeArticle();

    //1.Save the second article into the same folder 'ReadLater'
    MyListPageObject myListPageObject = MyListPageObjectFactory.get(driver);
    if (Platform.getInstance().isIOS()) {
      searchPageObject.repeatedSearchInput();
    } else {
      searchPageObject.initSearchInput();
      searchPageObject.typeSearchLine(SEARCH_LINE);
    }
    searchPageObject.clickArticleBySubstring("Island of Indonesia");//Island of Indonesia
    articlePageObject.waitForTitleSecondArticle();//because on iOS TITLE differs TITLE_2
    if (Platform.getInstance().isAndroid()) {
      articlePageObject.addSecondArticleToMyList();
      myListPageObject.clickFolderByName(NAME_OF_FOLDER);
    } else {
      articlePageObject.addArticleToMySaved();
    }
    articlePageObject.closeArticle();

    NavigationUI navigationUI = NavigationUIFactory.get(driver);
    navigationUI.openNavigation();
    navigationUI.clickMyLists();
    if (Platform.getInstance().isAndroid()) {
      myListPageObject.openFolderByName(NAME_OF_FOLDER); //work sometimes
      //myListPageOb.openFolderByImageID(); always work
    }
    if (Platform.getInstance().isMW()) {
      driver.navigate().refresh();
    }
    //2.Delete the first article     //Java (programming language)
    if (Platform.getInstance().isIOS()) {
      myListPageObject.removeOverlay();
    }
    myListPageObject.swipeArticleToDelete(articleTitle);

    //3.To be sure that the second article is present 4.Go into it
    myListPageObject.openSecondArticle(SEARCH_LINE);
    //4.Be sure that we have a special link inside an article
    articlePageObject.waitElementInsideArticle();

    System.out.println("Well done! The testSaveTwoArticleIntoOneFolder has been passed successfully!");
  }

}

