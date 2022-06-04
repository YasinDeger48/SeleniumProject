package com.cydeo.myExamples.enisShare;

import static com.applause.auto.framework.SdkHelper.getDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

import com.applause.auto.data.Constants.TestData;
import com.applause.auto.data.enums.Attribute;
import com.applause.auto.data.enums.Browser;
import com.applause.auto.data.enums.SwipeDirection;
import com.applause.auto.data.enums.TimeOuts;
import com.applause.auto.framework.ContextManager;
import com.applause.auto.framework.SdkHelper;
import com.applause.auto.helpers.sync.Until;
import com.applause.auto.pageobjectmodel.base.BaseComponent;
import com.applause.auto.pageobjectmodel.elements.BaseElement;
import com.applause.auto.pageobjectmodel.elements.SelectList;
import com.applause.auto.pageobjectmodel.elements.TextBox;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

  private static final Logger logger = LogManager.getLogger(Helper.class);

  /**
   * Switches to tab/new window
   *
   * @param oldWindowHandle
   */
  public static void switchToNewTab(String oldWindowHandle) {
    // TODO: Replace static wait with wait for condition
    SdkHelper.getSyncHelper().sleep(TimeOuts.ONE_SECOND_WAIT_MILLI.getValue());
    List<String> windows = waitForNewWindowToAppear(TimeOuts.TWENTY_SECOND_WAIT_MILLI.getValue());

    // get the valid windows again, to ensure that the correct new window appears
    windows = waitForNewWindowToAppear(TimeOuts.TWENTY_SECOND_WAIT_MILLI.getValue());

    for (String windowHandle : windows) {
      if (!windowHandle.equals(oldWindowHandle)) {
        logger.info(
            "Switching to new window handle ["
                + windowHandle
                + "] from ["
                + oldWindowHandle
                + "].");
        switchToTab(windowHandle);
        return;
      }
    }
  }

  /**
   * Switches to tab/new window
   *
   * @param newUrl
   */
  public static void switchToNewTabThatContainsUrl(String newUrl) {
    // TODO: Replace static wait with wait for condition
    SdkHelper.getSyncHelper().sleep(TimeOuts.ONE_SECOND_WAIT_MILLI.getValue());
    List<String> windows = waitForNewWindowToAppear(TimeOuts.TWENTY_SECOND_WAIT_MILLI.getValue());

    // get the valid windows again, to ensure that the correct new window appears
    windows = waitForNewWindowToAppear(TimeOuts.TWENTY_SECOND_WAIT_MILLI.getValue());
    // reverse windows to start from new one
    Collections.reverse(windows);
    String currentUrl;
    for (String windowHandle : windows) {
      logger.info("Switching to new window handle [" + windowHandle + "].");
      switchToTab(windowHandle);
      currentUrl = getDriver().getCurrentUrl();
      if (currentUrl.contains(newUrl)) {
        return;
      } else {
        logger.info(String.format("Tab URL [%s] didn't contain [%s]", currentUrl, newUrl));
      }
    }
  }

  /**
   * Wait For New Window To Appear
   *
   * @param timeToWaitInMs
   * @return ArrayList
   */
  public static List<String> waitForNewWindowToAppear(long timeToWaitInMs) {
    Set<String> windows = getDriver().getWindowHandles();
    long timeLimit = getCurrentGMT6Time() + timeToWaitInMs;

    while (windows.size() < 2 && timeLimit > getCurrentGMT6Time()) {
      // TODO: Replace static wait with wait for condition
      SdkHelper.getSyncHelper().sleep(TimeOuts.HALF_SECOND_WAIT_MILLI.getValue());
      windows = getDriver().getWindowHandles();
    }

    if (windows.size() < 2) {
      throw new RuntimeException(
          "No new tabs appeared, staying at: "
              + getDriver().getTitle()
              + " ("
              + getDriver().getCurrentUrl()
              + ").");
    }

    return new ArrayList<>(windows);
  }

  /**
   * Switches to tab/new window
   *
   * @param windowToSwitch
   */
  public static void switchToTab(String windowToSwitch) {
    getDriver().switchTo().window(windowToSwitch);

    logger.info("Switching to: " + getDriver().getCurrentUrl());
    try {
      new WebDriverWait(getDriver(), TimeOuts.TEN_SECOND_WAIT_SEC.getValue())
          .until(w -> !getDriver().getCurrentUrl().contains(TestData.EMPTY_TAB_URL));
    } catch (Exception e) {
      throw new RuntimeException("New tab is blank.");
    }
  }

  public static long getCurrentGMT6Time() {
    return getDateInTimeZone(new Date(), "America/Los_Angeles").getTime();
  }

  private static Date getDateInTimeZone(Date currentDate, String timeZoneId) {
    Calendar mbCal = new GregorianCalendar(TimeZone.getTimeZone(timeZoneId));
    mbCal.setTimeInMillis(currentDate.getTime());
    Calendar cal = Calendar.getInstance();
    cal.set(1, mbCal.get(1));
    cal.set(2, mbCal.get(2));
    cal.set(5, mbCal.get(5));
    cal.set(11, mbCal.get(11));
    cal.set(12, mbCal.get(12));
    cal.set(13, mbCal.get(13));
    cal.set(14, mbCal.get(14));
    return cal.getTime();
  }

  /**
   * Wait Till Url Changed
   *
   * @param currentURL
   * @param secondsToWait
   */
  public static boolean waitTillUrlChanged(String currentURL, int secondsToWait) {
    try {
      return new WebDriverWait(getDriver(), secondsToWait)
          .until(w -> !getDriver().getCurrentUrl().contains(currentURL));
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Clicks an element at an accurate point on devices, with native tap. This method is to mitigate
   * issues where the different device sizes cause the element locations to differ.
   *
   * @param element
   */
  public static void clickElementWithNativeTap(WebElement element) {
    int x = getAccuratePointX(element);
    int y = getAccuratePointY(element);
    logger.info("Clicking element with native tap at (" + x + ", " + y + ").");
    new TouchAction((AppiumDriver<?>) getDriver()).tap(PointOption.point(x, y)).release().perform();
  }

  /**
   * Clicks an element at an accurate point on devices, with native tap. This method is to mitigate
   * issues where the different device sizes cause the element locations to differ.
   *
   * @param element
   */
  public static void clickElementWithNativeTapWithOffset(
      WebElement element, int xOffset, int yOffset) {
    int x = getAccuratePointX(element) + xOffset;
    int y = getAccuratePointY(element) + yOffset;
    logger.info("Clicking element with native tap at (" + x + ", " + y + ").");
    new TouchAction((AppiumDriver<?>) getDriver()).tap(PointOption.point(x, y)).release().perform();
  }

  /**
   * Clicks an element at an accurate point on devices, with native tap. This method is to mitigate
   * issues where the different device sizes cause the element locations to differ.
   *
   * @param x coordinate
   * @param y coordinate
   */
  public static void clickOnCoordinatesWithNativeTap(int x, int y) {
    logger.info("Clicking element with native tap at (" + x + ", " + y + ").");
    new TouchAction((AppiumDriver<?>) getDriver()).tap(PointOption.point(x, y)).release().perform();
  }

  /**
   * Gets accurate X point for element
   *
   * @param element
   * @return Accurate X point for element
   */
  public static int getAccuratePointX(WebElement element) {
    double widthRatio =
        (double) getDriver().manage().window().getSize().width
            / (double) getJavascriptWindowWidth();
    return (int) (Helper.getLocation(element).getX() * widthRatio)
        + (element.getSize().getWidth() / 2);
  }

  /**
   * Clicks element with native web tap
   *
   * @param element
   */
  public static void clickElementWithNativeWebTapOnIOS(BaseElement element) {
    logger.info("Clicking element with native web tap.");
    if (!element.isDisplayed()) {
      Helper.scrollElementIntoViewUsingJS(element);
    }
    SdkHelper.getSyncHelper().wait(Until.uiElement(element).clickable());
    IOSDriver iosDriver = (IOSDriver) getDriver();
    iosDriver.nativeWebTap(true);
    element.click();
    iosDriver.nativeWebTap(false);
  }

  /**
   * Tap by element.
   *
   * @param element the element
   */
  public static void tapByElement(BaseElement element) {
    logger.info("Tap by element");
    int startX = Helper.getElementRect(element).getX();
    int addition = (int) (element.getWebElement().getSize().height * 0.5);
    int endX = startX + addition;
    int startY = Helper.getElementRect(element).getY();
    new TouchAction((PerformsTouchActions) getDriver())
        .tap(PointOption.point(endX, startY))
        .perform();
  }

  /**
   * Simulate react click.
   *
   * @param element the element
   */
  public static void simulateReactClick(BaseElement element) {
    logger.info("React click simulation");
    String script =
        "async function simulateMouseClick(el) {\n"
            + "  let opts = {view: window, bubbles: true, cancelable: true, buttons: 1};\n"
            + "  el.dispatchEvent(new MouseEvent(\"mousedown\", opts));\n"
            + "  el.dispatchEvent(new MouseEvent(\"touchstart\", opts));  \n"
            + "  await new Promise(r => setTimeout(r, 50));\n"
            + "  el.dispatchEvent(new MouseEvent(\"touchend\", opts));  \n"
            + "  el.dispatchEvent(new MouseEvent(\"mouseup\", opts));\n"
            + "  el.dispatchEvent(new MouseEvent(\"click\", opts));\n"
            + "};"
            + "await simulateMouseClick(arguments[0]);";
    getJavascriptExecutor().executeScript(script, element.getWebElement());
  }

  /**
   * Gets accurate Y point for element
   *
   * @param element
   * @return Accurate Y point for element
   */
  public static int getAccuratePointY(WebElement element) {
    int windowDiff =
        SdkHelper.getEnvironmentHelper().isTablet()
            ? getWindowHeightDiffBetweenAppiumAndSelenium()
            : (int) (getWindowHeightDiffBetweenAppiumAndSelenium() / 1.5);
    int seleniumWindowHeight = getDriver().manage().window().getSize().getHeight();
    double heightRatio = ((double) seleniumWindowHeight / getJavascriptWindowHeight());
    return (int) ((heightRatio * Helper.getLocation(element).getY()) + windowDiff)
        + element.getSize().getHeight() / 2;
  }

  /**
   * @return JavaScript window width
   */
  public static int getJavascriptWindowWidth() {
    int windowWidth =
        ((Long)
                getJavascriptExecutor()
                    .executeScript("return window.innerWidth || document.body.clientWidth"))
            .intValue();
    logger.info("Current window width is: " + windowWidth);
    return windowWidth;
  }

  /**
   * @return JavaScript window height
   */
  public static int getJavascriptWindowHeight() {
    return ((Long)
            getJavascriptExecutor()
                .executeScript("return window.innerHeight || document.body.clientHeight"))
        .intValue();
  }

  /**
   * @return the window height difference between Appium and Selenium
   */
  public static int getWindowHeightDiffBetweenAppiumAndSelenium() {
    int seleniumWindowHeight = getDriver().manage().window().getSize().getHeight();
    return getAppiumWindowHeight() - seleniumWindowHeight;
  }

  /**
   * @return Appium window height
   */
  public static int getAppiumWindowHeight() {
    AppiumDriver<?> appiumDriver = ((AppiumDriver<?>) getDriver());
    String currentContext = appiumDriver.getContext();
    appiumDriver.context(TestData.NATIVE_APP);
    int appiumHeight = appiumDriver.manage().window().getSize().getHeight();
    appiumDriver.context(currentContext);
    return appiumHeight;
  }

  /**
   * @return Appium window width
   */
  public static int getAppiumWindowWidth() {
    AppiumDriver<?> appiumDriver = ((AppiumDriver<?>) getDriver());
    String currentContext = appiumDriver.getContext();
    appiumDriver.context(TestData.NATIVE_APP);
    int appiumWidth = appiumDriver.manage().window().getSize().getWidth();
    appiumDriver.context(currentContext);
    logger.info("Appium window width: " + appiumWidth);
    return appiumWidth;
  }

  private static JavascriptExecutor getJavascriptExecutor() {
    return (JavascriptExecutor) getDriver();
  }

  private static int getPageHeight() {
    return ((Long) getJavascriptExecutor().executeScript("return document.body.clientHeight"))
        .intValue();
  }

  public static int getPageWidth() {
    int width =
        ((Long) getJavascriptExecutor().executeScript("return document.body.clientWidth"))
            .intValue();
    logger.info("Page Width: " + width);
    return width;
  }

  /**
   * When element not exist on the page until you scroll to it position, and when not possible to
   * determine some container to which we can scroll this method can be used
   *
   * @param element
   * @param pixelStep
   * @param attempts
   */
  public static void scrollPageDownUntilElementAppear(
      BaseElement element, int pixelStep, int attempts) {
    int startPoint = Helper.getCurrentYWindowOffset();
    int endPoint = pixelStep + startPoint;
    int pageHeight;
    if (element.exists()) {
      return;
    }
    for (int i = 0; i < attempts; ++i) {
      logger.info("Scrolling Page Down until element will appear");
      getJavascriptExecutor()
          .executeScript(String.format("window.scrollTo(%d,%d);", startPoint, endPoint));
      if (element.exists()) {
        return;
      }
      pageHeight = getPageHeight();
      if (endPoint > pageHeight) {
        break;
      }
      startPoint = endPoint;
      endPoint = endPoint + pixelStep;
    }
    logger.info("Could not find element after scroll to [{}] pixels.", endPoint);
  }

  /**
   * Scroll page down until the element becomes visible on the screen.
   *
   * @param element the element
   * @param pixelStep the pixel step
   * @param attempts the attempts
   */
  public static void scrollPageDownUntilElementBecomesVisible(
      BaseElement element, int pixelStep, int attempts) {
    scrollPageDownUntilElementBecomesVisible(element, pixelStep, attempts, 0);
  }

  /**
   * Scroll page down until the element becomes visible on the screen.
   *
   * @param element the element
   * @param pixelStep the pixel step
   * @param attempts the attempts
   * @param wait time to wait after each scroll
   */
  public static void scrollPageDownUntilElementBecomesVisible(
      BaseElement element, int pixelStep, int attempts, int wait) {
    int startPoint = 0;
    int endPoint = pixelStep;
    int pageHeight;
    for (int i = 0; i < attempts; ++i) {
      logger.info("Scrolling Page Down until element will appear");
      getJavascriptExecutor()
          .executeScript(String.format("window.scrollTo(%d,%d);", startPoint, endPoint));
      if (wait > 0) {
        SdkHelper.getSyncHelper().sleep(wait);
      }
      if (element.exists() && element.isDisplayed()) {
        return;
      }
      pageHeight = getPageHeight();
      if (endPoint > pageHeight) {
        break;
      }
      startPoint = endPoint;
      endPoint = endPoint + pixelStep;
    }
    throw new NoSuchElementException(
        String.format("Could not find element after scroll to [%s] pixels.", endPoint));
  }

  public static void scrollPageVerticallyToElementPosition(BaseElement element, int offsetFromTop) {
    int startPoint = getJavascriptWindowWidth() / 2;
    int elementY = getCurrentElementYOffset(element);
    String scroll = String.format("window.scrollTo(%d,%d);", startPoint, elementY - offsetFromTop);
    logger.debug(scroll);
    getJavascriptExecutor().executeScript(scroll);
    logger.info("Window offset after scroll " + getCurrentYWindowOffset());
    if (!element.exists()) {
      throw new NoSuchElementException(
          String.format(
              "Could not find element after scroll to [%s] pixels.", elementY - offsetFromTop));
    }
  }

  /**
   * Gets current y window offset.
   *
   * @return the current y window offset
   */
  public static int getCurrentYWindowOffset() {
    int windowOffset =
        (int)
            Double.parseDouble(
                getJavascriptExecutor().executeScript("return window.scrollY").toString());
    logger.info("Current window offset " + windowOffset);
    return windowOffset;
  }

  /**
   * Gets available window height.
   *
   * @return the available window height
   */
  public static int getAvailableWindowHeight() {
    int windowHeight =
        (int)
            Double.parseDouble(
                getJavascriptExecutor()
                    .executeScript("return document.body.clientHeight")
                    .toString());
    logger.info("Current window height " + windowHeight);
    return windowHeight;
  }

  public static int getCurrentElementYOffset(BaseElement element) {
    int offsetY =
        Integer.parseInt(
            getJavascriptExecutor()
                .executeScript("return arguments[0].offsetTop", element.getWebElement())
                .toString());
    logger.info("Current element" + element + " offset y  = " + offsetY);
    return offsetY;
  }

  public static int getCurrentElementYOffsetOnDocument(BaseElement baseElement) {
    String script =
        "function getOffset(el) {\n"
            + "  const rect = el.getBoundingClientRect();\n"
            + "  return {\n"
            + "    left: rect.left + window.scrollX,\n"
            + "    top: rect.top + window.scrollY\n"
            + "  };\n"
            + "}"
            + "return Math.round(getOffset(arguments[0]).top)";
    return Integer.parseInt(
        getJavascriptExecutor().executeScript(script, baseElement.getWebElement()).toString());
  }

  /**
   * Gets current element x offset.
   *
   * @param element the element
   * @return the current element x offset
   */
  public static int getCurrentElementXOffset(BaseElement element) {
    int offsetY =
        Integer.parseInt(
            getJavascriptExecutor()
                .executeScript("return arguments[0].offsetLeft", element.getWebElement())
                .toString());
    logger.info("Current element" + element + " offset x  = " + offsetY);
    return offsetY;
  }

  /**
   * Gets element rect. TODO: remove this when getLocation & getDimension work again in W3C mode.
   *
   * @param element the element
   * @return the element rect
   */
  public static Rectangle getElementRect(BaseElement element) {
    new WebDriverWait(getDriver(), TimeOuts.TEN_SECOND_WAIT_SEC.getValue())
        .until(
            w -> {
              try {
                /**
                 * TODO:
                 *
                 * <p>This code can produce a StackOverflowException. Need to handle that later on.
                 */
                getElementRect(element.getWebElement());
                return true;
              } catch (Exception e) {
                logger.debug(e.getMessage());
                return false;
              }
            });
    return getElementRect(element.getWebElement());
  }

  /**
   * Gets element rect. TODO: remove this when getLocation & getDimension work again in W3C mode.
   *
   * @param element the element
   * @return the element rect
   */
  public static Rectangle getElementRect(WebElement element) {
    Map<?, ?> result =
        (Map<?, ?>)
            ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].getBoundingClientRect()", element);
    logger.info(result.toString());
    return new Rectangle(
        (int) Double.parseDouble(result.get("x").toString()),
        (int) Double.parseDouble(result.get("y").toString()),
        (int) Double.parseDouble(result.get("height").toString()),
        (int) Double.parseDouble(result.get("width").toString()));
  }

  /**
   * Gets the element location on the screen using JS. TODO: We are currently using this as a
   * workaround as the default getLocation is not working in W3C mode.
   *
   * @param element The element to retrieve the location from.
   * @return A point representing the location
   */
  public static Point getLocation(BaseElement element) {
    return getElementRect(element).getPoint();
  }

  /**
   * Gets the element location on the screen using JS. TODO: We are currently using this as a
   * workaround as the default getLocation is not working in W3C mode
   *
   * @param element The element to retrieve the location from.
   * @return A point representing the location
   */
  public static Point getLocation(WebElement element) {
    return getElementRect(element).getPoint();
  }

  /**
   * Gets the element dimension using JS. TODO: We are currently using this as a workaround as the
   * default getDimension is not working in W3C mode.
   *
   * @param element The element to retrieve the dimension from.
   * @return A dimension object
   */
  public static Dimension getDimension(BaseElement element) {
    return getElementRect(element).getDimension();
  }

  /**
   * Tap in center of mobile element.
   *
   * @param element the mobile element
   */
  public static void tapInCenterOfMobileElement(BaseElement element) {
    Point center = element.getMobileElement().getCenter();
    logger.info("Tapping in the center of element x: " + center.getX() + " y: " + center.getY());
    new TouchAction((PerformsTouchActions) getDriver())
        .press(new PointOption().withCoordinates(center))
        .waitAction()
        .release()
        .perform();
  }

  /**
   * @return true if Environment is Desktop Browser
   */
  public static boolean isDesktop() {
    return !SdkHelper.getEnvironmentHelper().isMobileAndroid()
        && !SdkHelper.getEnvironmentHelper().isMobileIOS();
  }

  /**
   * @return true if Mobile Tablet
   */
  public static boolean isTablet() {
    return StringUtils.containsIgnoreCase(
        ContextManager.getInstance().getDriverContext().getDriver().getPlatform().toString(),
        "tablet");
  }

  /**
   * Switch to native context and click on element if exists
   *
   * @param element The element to look for
   * @param waitForPageToFinishLoading Whether or not to wait for the page to finish loading
   */
  public static void switchToNativeContextAndClickElement(
      BaseElement element, boolean waitForPageToFinishLoading) {
    if (isDesktop()) {
      throw new UnsupportedOperationException(
          "Cannot switch to native context if not using a mobile driver.");
    } else {
      AppiumDriver<?> driver = (AppiumDriver<?>) getDriver();
      logger.info("ContextHandles list: " + driver.getContextHandles());
      String oldContext = driver.getContext();
      logger.info("Switch to the Native context");
      driver.context(TestData.NATIVE_APP);
      if (element.exists()) {
        logger.info("clicking on Native element");
        element.initialize();
        if (SdkHelper.getEnvironmentHelper().isMobileDriver()
            && !SdkHelper.getEnvironmentHelper().isAndroid()) {
          iOsTap(element);
        } else {
          logger.info("Performing usual click");
          element.click();
        }
      } else {
        logger.info(
            String.format(
                "Expected element not found in native context. [%s]",
                element.getLocator().getLocatorStringMap().entrySet().toString()));
      }
      driver.context(oldContext);
      if (waitForPageToFinishLoading) {
        // After click some button in NATIVE context page can be refreshed
        waitForPageToFinishLoading();
      }
    }
  }

  /**
   * Os tap.
   *
   * @param baseElement the base element
   */
  public static void iOsTap(BaseElement baseElement) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    Map<String, Object> params = new HashMap<>();
    Point point = baseElement.getMobileElement().getCenter();
    params.put("x", point.getX());
    params.put("y", point.getY());
    logger.info("Performing IOS tap:" + point.toString());
    js.executeScript("mobile: tap", params);
  }

  public static void iOsTap(Point point) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    Map<String, Object> params = new HashMap<>();
    params.put("x", point.getX());
    params.put("y", point.getY());
    logger.info("Performing IOS tap:" + point.toString());
    js.executeScript("mobile: tap", params);
  }

  /** Wait for page to finish loading by checking with JS `document.readyState` */
  public static void waitForPageToFinishLoading(TimeOuts timeout) {
    logger.info("## Waiting for page to finish loading...");
    new WebDriverWait(getDriver(), timeout.getValue())
        .until(
            webDriver ->
                getJavascriptExecutor()
                    .executeScript("return document.readyState")
                    .equals("complete"));
  }

  /** Wait for page to finish loading by checking with JS `document.readyState` */
  public static void waitForPageToFinishLoading() {
    logger.info("## Waiting for page to finish loading...");
    waitForPageToFinishLoading(TimeOuts.SIXTY_SECOND_WAIT_SEC);
  }

  /**
   * Navigate to specific URL
   *
   * @param expectedUrl
   * @param clazz
   * @return AbstractPage
   */
  public static <T extends BaseComponent> T navigateToUrl(String expectedUrl, Class<T> clazz) {
    logger.info(String.format("Navigation to [%s]", expectedUrl));
    getDriver().navigate().to(expectedUrl);
    return SdkHelper.create(clazz);
  }

  /**
   * Clean up text from html attributes string.
   *
   * @param string the string
   * @return the string
   */
  public static String cleanUpTextFromHtmlAttributes(String string) {
    return string.replaceAll("\\<.*?\\>", "");
  }

  /**
   * Click 'Back' browser button and navigate to the previous page
   *
   * @param clazz
   * @return BaseComponent
   */
  public static <T extends BaseComponent> T navigateBack(Class<T> clazz) {
    navigateBack();
    return SdkHelper.create(clazz);
  }

  /**
   * Click 'Back' browser button
   *
   * @return BaseComponent
   */
  public static void navigateBack() {
    logger.info("Clicking 'Back' browser button.");
    getDriver().navigate().back();
  }

  /**
   * Click 'Back' browser button and navigate to the previous page
   *
   * @param clazz
   * @return BaseComponent
   */
  public static <T extends BaseComponent, TopHeaderInterface>
      T navigateBackToTopHeaderContainingPage(Class<T> clazz) {
    logger.info("Clicking 'Back' browser button.");
    getDriver().navigate().back();
    return SdkHelper.create(clazz);
  }

  /** Scrolls to the top of the page */
  public static void scrollToPageTop() {
    getJavascriptExecutor().executeScript("window.scrollTo(0, 0);");
  }

  /**
   * Get element text content string.
   *
   * @return the string
   */
  public static String getElementTextContent(BaseElement element) {
    return getJavascriptExecutor()
        .executeScript(
            "return arguments[0].innerText || arguments[0].textContent", element.getWebElement())
        .toString();
  }

  /** Scrolls to the top of the page */
  public static void scrollPageByCoordinates(int endPoint) {
    logger.info(String.format("Scrolling Page Coordinates - [0, %s]", endPoint));
    getJavascriptExecutor().executeScript(String.format("window.scrollTo(%d,%d);", 0, endPoint));
  }

  public static void clickWithOffset(BaseElement element, int xCoordinate, int yCoordinate) {
    logger.info(
        String.format(
            "Clicking element with offset. X - [%s], Y - [%s]", xCoordinate, yCoordinate));
    Actions builder = new Actions(getDriver());
    builder.moveToElement(element.getWebElement(), xCoordinate, yCoordinate).click().perform();
  }

  /**
   * Handle Safari 13.1 click issue on some elements
   *
   * @param element
   */
  public static void click(BaseElement element) {
    if (isDesktop() && Browser.isSafari()) {
      SdkHelper.getBrowserControl().jsClick(element);
    } else {
      element.click();
    }
  }

  /**
   * Scrolls an element into view using JavaScript
   *
   * @param element the element
   */
  public static void scrollElementIntoViewUsingJS(BaseElement element) {
    logger.info("Scrolling the element into view...");
    ((JavascriptExecutor) getDriver())
        .executeScript("arguments[0].scrollIntoView(true);", element.getWebElement());
  }

  public static void scrollElementIntoViewAtBottomOfPageUsingJS(BaseElement element) {
    logger.info("Scrolling the element into view...");
    ((JavascriptExecutor) getDriver())
        .executeScript("arguments[0].scrollIntoView(false);", element.getWebElement());
  }

  /**
   * Scrolls an element into view using JavaScript
   *
   * @param element the element
   */
  public static void scrollElementIntoViewWithShiftWindowUsingJS(
      BaseElement element, final int shiftToOffset) {
    logger.info("Scrolling the element into view...");
    ((JavascriptExecutor) getDriver())
        .executeScript("arguments[0].scrollIntoView(true);", element.getWebElement());
    jsShiftWindow(shiftToOffset);
  }

  /**
   * Scrolls an element into view using JavaScript smoothly
   *
   * @param element the element
   */
  public static void scrollElementSmoothlyUsingJS(BaseElement element) {
    logger.info("Scrolling the element into view...");
    ((JavascriptExecutor) getDriver())
        .executeScript(
            "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'start' });",
            element.getWebElement());
  }

  /**
   * Type the text slowly into the field
   *
   * @param element
   * @param text
   */
  public static void enterTextSlowly(TextBox element, String text) {
    for (int i = 0; i < text.length(); i++) {
      element.getWebElement().sendKeys(String.valueOf(text.charAt(i)));
    }
  }

  /**
   * Switches to tab/new window
   *
   * @param element
   * @param timeOuts
   */
  public static boolean clickElementWhenItIsClickable(BaseElement element, TimeOuts timeOuts) {
    return new WebDriverWait(getDriver(), timeOuts.getValue())
        .until(
            w -> {
              try {
                logger.info("Wait till element is clickable and then click");
                element.click();
                return true;
              } catch (Exception e) {
                logger.debug(e.getMessage());
                return false;
              }
            });
  }

  /**
   * Click On Element and in case of ElementClickInterceptedException scroll up and then click again
   *
   * @param element
   */
  public static void clickOnElementAndScrollUpIfNeeded(BaseElement element, int shiftWindow) {
    try {
      element.click();
    } catch (ElementClickInterceptedException e) {
      int yCoordinate = getPagePositionY();
      Helper.scrollPageByCoordinates(yCoordinate - shiftWindow);
      logger.info("Clicking again");
      element.click();
    }
  }

  /**
   * @return Y-position of page
   */
  public static int getPagePositionY() {
    String javascript = "return window.scrollY;";
    return (int)
        Float.parseFloat(
            String.valueOf(((JavascriptExecutor) getDriver()).executeScript(javascript)));
  }

  /** Scrolls to the bottom of the page */
  public static void scrollToPageBottom() {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
  }

  /**
   * Gets random value within a specific range
   *
   * @param min
   * @param max
   * @return Random value within range
   */
  public static int getRandomValueWithinRange(int min, int max) {
    return new Random().nextInt((max - min) + 1) + min;
  }

  /**
   * Hover on element
   *
   * @param element
   */
  public static void hoverOnElementJs(BaseElement element) {
    String mouseOverScript =
        "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    executor.executeScript(mouseOverScript, element.getWebElement());
  }

  /**
   * Stop hover on element
   *
   * @param element
   */
  public static void stopHoverOnElementJs(BaseElement element) {
    String mouseOverScript =
        "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseout', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseout');}";
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    executor.executeScript(mouseOverScript, element.getWebElement());
  }

  /**
   * Move to element native.
   *
   * @param element the element
   */
  public static void moveToElement(BaseElement element) {
    logger.debug("Using Action builder");
    new Actions(getDriver())
        .pause(TimeOuts.TWO_SECOND_WAIT_MILLI.getValue())
        .moveToElement(element.getWebElement())
        .pause(TimeOuts.TWO_SECOND_WAIT_MILLI.getValue())
        .build()
        .perform();
  }

  public static void hoverElement(BaseElement element) {
    if (!Browser.isSafari()) {
      Helper.moveToElement(element);
    } else {
      Helper.hoverOnElementJs(element);
    }
  }

  /**
   * Move to element and click.
   *
   * @param element the element
   */
  public static void moveToElementAndClick(BaseElement element) {
    logger.debug("Using Action builder");
    new Actions(getDriver())
        .pause(TimeOuts.TWO_SECOND_WAIT_MILLI.getValue())
        .moveToElement(element.getWebElement())
        .pause(TimeOuts.TWO_SECOND_WAIT_MILLI.getValue())
        .click(element.getWebElement())
        .build()
        .perform();
  }

  /**
   * Dispatch mouse enter event.
   *
   * @param element the element
   * @return
   */
  public static boolean dispatchMouseEnterEvent(BaseElement element) {
    boolean result =
        BooleanUtils.toBoolean(
            ((JavascriptExecutor) getDriver())
                .executeScript(
                    "return arguments[0].dispatchEvent(new Event('mouseenter'))",
                    element.getWebElement())
                .toString());
    logger.info("Dispatch event result " + result);
    return result;
  }

  /**
   * Dispatch mouse leave event.
   *
   * @param element the element
   */
  public static void dispatchMouseLeaveEvent(BaseElement element) {
    ((JavascriptExecutor) getDriver())
        .executeScript(
            "arguments[0].dispatchEvent(new Event('mouseleave'))", element.getWebElement());
  }

  /**
   * Dispatch mouse leave event.
   *
   * @param element the element
   */
  public static void dispatchClickEvent(BaseElement element) {
    ((JavascriptExecutor) getDriver())
        .executeScript(
            "['mousedown', 'click', 'mouseup'].forEach(mouseEventType =>\n"
                + "    arguments[0].dispatchEvent(\n"
                + "      new MouseEvent(mouseEventType, {\n"
                + "          view: window,\n"
                + "          bubbles: true,\n"
                + "          cancelable: true,\n"
                + "          buttons: 1\n"
                + "      })\n"
                + "    )\n"
                + "  );",
            element.getWebElement());
  }

  /**
   * Get element text content with js
   *
   * @param element
   * @return
   */
  public static String getElementTextContentWithJS(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    try {
      String textContent = (String) js.executeScript("return arguments[0].textContent", element);
      logger.info("Text content is: " + textContent);
      return textContent;
    } catch (Exception e) {
      return StringUtils.EMPTY;
    }
  }

  /**
   * Get current page url
   *
   * @return
   */
  public static void waitForUrlToChangeAfterAction(Runnable action) {
    String currentUrl = getDriver().getCurrentUrl();
    logger.info("Current page url is: " + currentUrl);
    action.run();
    logger.info("Wait for new url will appear");
    SdkHelper.getSyncHelper()
        .waitUntil(urlWillBeChangedCondition -> !getDriver().getCurrentUrl().equals(currentUrl));
  }

  /**
   * Get current page url
   *
   * @return
   */
  public static String getCurrentPageUrl() {
    String currentUrl = getDriver().getCurrentUrl();
    logger.info("Current page url is: " + currentUrl);
    return currentUrl;
  }

  /** Closes other tabs */
  public static void closeOtherTabs() {
    logger.info("Closing all other tabs.");
    String currentWindow = getDriver().getWindowHandle();

    for (String windowHandle : getDriver().getWindowHandles()) {
      if (!windowHandle.equals(currentWindow)) {
        getDriver().switchTo().window(windowHandle);
        getDriver().close();
      }
    }

    getDriver().switchTo().window(currentWindow);
  }

  /**
   * Handle basic auth.
   *
   * @param url the url
   */
  public static void handleBasicAuth(String url) {
    getJavascriptExecutor()
        .executeScript(
            "async function wait() {\n"
                + "   await new Promise(r => SdkHelper.setTimeout(window.open('"
                + url
                + "','_self'), 10000));\n"
                + "}"
                + "wait();");
  }

  /**
   * Gets current window location.
   *
   * @return the current window location
   */
  public static String getCurrentWindowLocation() {
    return Helper.getJavascriptExecutor().executeScript("return window.location.href").toString();
  }

  /**
   * Check if element exist and then if isDisplayed
   *
   * @param element
   * @return boolean
   */
  public static boolean isDisplayed(BaseElement element) {
    return element.exists() && element.isDisplayed();
  }

  /**
   * Check if element exist and then if isDisplayed
   *
   * @param element
   * @param timeToWaitInSec
   * @return boolean
   */
  public static boolean isDisplayed(BaseElement element, TimeOuts timeToWaitInSec) {
    try {
      SdkHelper.getSyncHelper()
          .wait(
              Until.uiElement(element)
                  .visible()
                  .setTimeout(Duration.ofSeconds(timeToWaitInSec.getValue())));
      return Helper.isDisplayed(element);
    } catch (Exception e) {
      return Helper.isDisplayed(element);
    }
  }

  /**
   * Get element Text On Mobile devices
   *
   * @param element
   * @return String
   */
  public static String getTextOnMobile(BaseElement element) {
    String text = element.getAttributeValue(Attribute.INNER_HTML.getValue());
    if (text == null) {
      logger.info("innerHTML Attribute for this element is null. Trying to use getText()");
      return element.getMobileElement().getText();
    } else {
      return text;
    }
  }

  /**
   * Get selected option
   *
   * @param selectList
   * @return String
   */
  public static String getSelectedOption(SelectList selectList) {
    String locator = selectList.getLocator().getLocatorStringMap().entrySet().toString();
    if (locator.startsWith("[XPATH=")) {
      logger.info(String.format("Getting selected option by locator: [%s]", locator));
      String xPathLocator =
          selectList
              .getLocator()
              .getLocatorStringMap()
              .entrySet()
              .toString()
              .substring(0, locator.length() - 1)
              .replace("[XPATH=", "");
      return new Select(getDriver().findElement(By.xpath(xPathLocator)))
          .getFirstSelectedOption()
          .getText();
    } else {
      throw new RuntimeException("The method is implemented for XPath only");
    }
  }

  /**
   * Get css attribute
   *
   * @param element
   * @param cssProperty
   * @return String
   */
  public static String getCssValue(BaseElement element, String cssProperty) {
    return element.getWebElement().getCssValue(cssProperty);
  }

  public static String getColorsValue(String color) {
    return color.replaceAll("[^\\d, ]", "");
  }

  /**
   * Check if element (button) contains svg (icon)
   *
   * @param element
   * @return boolean
   */
  public static boolean elementContainsIcon(BaseElement element) {
    return element.getChildren(By.cssSelector("svg")).size() > 0;
  }

  /**
   * Scrolls web view by offset, on the Y-axis
   *
   * @param yOffset
   */
  public static void jsShiftWindow(final int yOffset) {
    final JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    executor.executeScript(String.format("window.scrollBy(0, %s)", yOffset));
    SdkHelper.getSyncHelper().sleep(TimeOuts.TWO_SECOND_WAIT_MILLI.getValue());
  }

  /**
   * Cleans the specified string value - removes any unnecessary white-spaces and line breaks.
   *
   * @param stringValue
   * @return cleaned string
   */
  public static String cleanString(String stringValue) {
    return stringValue
        .trim()
        .replaceAll("\n", "")
        .replaceAll("\r", "")
        .replaceAll("\u00a0", "")
        .replaceAll("\t", "");
  }

  /**
   * Check if this is Local or clientSide Execution
   *
   * @return boolean boolean
   */
  public static boolean isLocalExecution() {
    String execution = System.getProperty("useLocalDrivers");
    logger.info("Current execution is local - [{}]", execution);
    if (execution != null) {
      return Boolean.valueOf(execution);
    } else return false;
  }

  public static void swipeOnTheScreenNative(SwipeDirection direction, int waitTimeInSec) {
    if (isDesktop()) {
      throw new UnsupportedOperationException(
          "Cannot switch to native context if not using a mobile driver.");
    } else {
      AppiumDriver<?> driver = (AppiumDriver<?>) getDriver();
      logger.info("ContextHandles list: " + driver.getContextHandles());
      String oldContext = driver.getContext();
      logger.info("Switching to the Native context");
      driver.context(TestData.NATIVE_APP);

      logger.info("Swiping [{}] on the screen", direction.name());
      SdkHelper.getDeviceControl().swipeAcrossScreenWithDirection(direction);
      SdkHelper.getSyncHelper().sleep(waitTimeInSec);

      logger.info("Switching back to web context");
      driver.context(oldContext);
    }
  }

  /**
   * Move slider with X coordinate offset
   *
   * @param sliderElement
   * @param xCoordinateOffset
   */
  public static void moveSlider(BaseElement sliderElement, double xCoordinateOffset) {
    /** We scroll the whole watches section to view. */
    logger.info("Scrolling the Watch slider to view...");
    Helper.scrollElementIntoViewUsingJS(sliderElement);
    // wait for the action to complete
    SdkHelper.getSyncHelper().sleep(TimeOuts.ONE_SECOND_WAIT_MILLI.getValue());

    int xCoordinate;
    if (Helper.isDesktop()) {
      xCoordinate = (int) (Helper.getDimension(sliderElement).getWidth() * xCoordinateOffset);
      Actions action = new Actions(getDriver());

      action
          .dragAndDropBy(sliderElement.getWebElement(), xCoordinate, 0)
          .release()
          .build()
          .perform();
    } else {
      sliderElement.initialize();
      xCoordinate = (int) (Helper.getDimension(sliderElement).getWidth() * xCoordinateOffset);
      Rectangle rect = Helper.getElementRect(sliderElement);
      int startX = rect.getX() + rect.getWidth() / 2 - 1;
      int startY = rect.getY() + rect.getHeight() / 2 - 1;

      TouchAction action = new TouchAction((AppiumDriver) SdkHelper.getDriver());

      action
          .press(new PointOption().withCoordinates(startX, startY))
          .waitAction(waitOptions(ofSeconds(2)))
          .moveTo(new PointOption().withCoordinates(xCoordinate, startY))
          .release()
          .perform();

      // Sometimes it doesn't work the first time, need to try again
      action
          .press(new PointOption().withCoordinates(startX, startY))
          .waitAction(waitOptions(ofSeconds(2)))
          .moveTo(new PointOption().withCoordinates(xCoordinate, startY))
          .release()
          .perform();
    }
    // wait for the action to complete
    SdkHelper.getSyncHelper().sleep(TimeOuts.ONE_SECOND_WAIT_MILLI.getValue());
  }
}
