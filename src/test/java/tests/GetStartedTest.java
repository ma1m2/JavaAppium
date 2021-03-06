package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
  @Test
  //@EnabledIfEnvironmentVariable(named="PLATFORM", matches="mob_web") - JUnit 5
  public void testPassThroughWelcome() {

    if (Platform.getInstance().isAndroid() || Platform.getInstance().isMW()) {
      return;
    }

    WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

    welcomePageObject.waitForLearnMoreLink();
    welcomePageObject.clickNextButton();

    welcomePageObject.waitForNewWayToExploreText();
    welcomePageObject.clickNextButton();

    welcomePageObject.waitForAddOrEditPreferredLangLink();
    welcomePageObject.clickNextButton();

    welcomePageObject.waitForLearnMoreAboutDataCollectedLink();
    welcomePageObject.clickGetStartedtButton();

    System.out.println("Well done! The testPassThroughWelcome has been passed successfully!");
  }
}
