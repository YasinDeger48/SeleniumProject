package com.cydeo.myExamples.enisShare;

import static com.applause.auto.util.Helper.getElementRect;

import com.applause.auto.framework.SdkHelper;
import com.applause.auto.pageobjectmodel.elements.BaseElement;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;

/** Class implements work with elements screenshots and comparison */
public class WebElementScreenShooter {

  private static final Logger logger = LogManager.getLogger(WebElementScreenShooter.class);

  private WebElementScreenShooter() {}

  /**
   * Taking element image from current layout depends on element coordinates
   *
   * @param element the element for the snapshot
   * @return return Buffered image of selected element
   */
  public static BufferedImage getElementImage(BaseElement element) {
    BufferedImage image;
    try {
      image =
          ImageIO.read(((TakesScreenshot) SdkHelper.getDriver()).getScreenshotAs(OutputType.FILE));
    } catch (IOException e) {
      throw new RuntimeException("We can't get Element Image", e);
    }

    Rectangle rect = getElementRect(element);

    if ((rect.getX() < 0) && (rect.getY() < 0)) {
      throw new RuntimeException(element + "Element is not visible");
    }
    int x = rect.getX();
    int y = rect.getY();

    if (x == 0 && y == 0) {
      return image;
    }
    return scale(image);
  }

  /**
   * Checking initial element image is equals with current element image
   *
   * @param initialImage image before the action
   * @param elementToTakePicture new image
   * @return return boolean result of image comparison
   */
  public static boolean checkElementHasChanged(
      BufferedImage initialImage, BaseElement elementToTakePicture) {
    if (initialImage == null || elementToTakePicture == null) {
      throw new RuntimeException("InitialImage or ElementToTakePicture should not be null");
    } else {
      BufferedImage img2 = getElementImage(elementToTakePicture);
      return getDifference(initialImage, img2) != 0;
    }
  }

  /**
   * Checking initial element image is equals with current element image
   *
   * @param initialImage base image
   * @param imageToCompare image to compare it with
   * @return return boolean result of image comparison
   */
  public static boolean imagesAreIdentical(
      BufferedImage initialImage, BufferedImage imageToCompare) {
    return getDifference(initialImage, imageToCompare) == 0;
  }

  /**
   * Gets image difference in percent.
   *
   * @param image1 the image 1
   * @param image2 the image 2
   * @return the image difference in percent
   */
  public static double getImageDifferenceInPercent(BufferedImage image1, BufferedImage image2) {
    double onePercent = (image1.getHeight() * image1.getWidth()) / 100;
    long diffInPixels = getDifference(image1, image2);
    double percentage = diffInPixels / onePercent;
    logger.info("Percentage of difference is - " + percentage);
    return percentage;
  }

  /**
   * Gets image difference in percent.
   *
   * @param image1 the image 1
   * @param baseDeviceControl the base device control
   * @return the image difference in percent
   */
  public static double getImageDifferenceInPercent(
      BufferedImage image1, BaseElement baseDeviceControl) {
    double onePercent = (image1.getHeight() * image1.getWidth()) / 100;
    long diffInPixels = getDifference(image1, getElementImage(baseDeviceControl));
    return diffInPixels / onePercent;
  }

  public static long getDifference(BufferedImage img1, BufferedImage img2) {
    if (img1 == null || img2 == null) {
      throw new RuntimeException("img1 or img2 should not be null");
    } else {
      // convert images to pixel arrays...
      final int w = img1.getWidth();
      final int h = img1.getHeight();
      final int[] p1 = img1.getRGB(0, 0, w, h, null, 0, w);
      final int[] p2 = img2.getRGB(0, 0, w, h, null, 0, w);
      long differenceCounter = 0;
      for (int i = 0; i < p1.length; i++) {
        if (p1[i] != p2[i]) {
          differenceCounter++;
        }
      }
      return differenceCounter;
    }
  }

  /**
   * Taking screenshot
   *
   * @return BufferedImage
   */
  public static BufferedImage getScreenshot() {
    try {
      return ImageIO.read(
          ((TakesScreenshot) SdkHelper.getDriver()).getScreenshotAs(OutputType.FILE));
    } catch (IOException e) {
      throw new RuntimeException("We can't get Element Image", e);
    }
  }

  private static BufferedImage scale(BufferedImage image) {
    if ((image.getWidth() / Helper.getJavascriptWindowWidth() == 1)
        && image.getHeight() / Helper.getJavascriptWindowHeight() == 1) {
      return image;
    }
    int dprX = (int) Math.round(((double) image.getWidth()) / Helper.getJavascriptWindowWidth());
    int dprY = (int) Math.round(((double) image.getHeight()) / Helper.getJavascriptWindowHeight());
    int scaledWidth = image.getWidth() / dprX;
    int scaledHeight = image.getHeight() / dprY;

    final BufferedImage bufferedImage =
        new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_3BYTE_BGR);
    final Graphics2D graphics2D = bufferedImage.createGraphics();
    graphics2D.setComposite(AlphaComposite.Src);
    graphics2D.setRenderingHint(
        RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    graphics2D.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
    graphics2D.dispose();
    return bufferedImage;
  }
}
