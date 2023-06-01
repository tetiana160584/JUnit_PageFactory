package Lesson_15;

import configuration.BaseClass;
import configuration.WEBDRIVERS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

  public class FrontEndBasicPageTest extends BaseClass {
      static FrontEndBasicPage frontEndBasicPage = null;

      @BeforeClass
      public static void openSite() {
          driver.get("https://dnipro.ithillel.ua/courses/front-end-basic");
          frontEndBasicPage = new FrontEndBasicPage(driver);

      }

      @Test
      public void testGetCourseTitle() {
          frontEndBasicPage = new FrontEndBasicPage(driver);
          String courseTitle = frontEndBasicPage.getCourseTitle();
          System.out.println("Course Title: " + courseTitle);

      }


      @Test
      public void testGetCourseRate() {
          frontEndBasicPage = new FrontEndBasicPage(driver);
          String courseRate = frontEndBasicPage.getCourseRate();
          System.out.println("Course Rate: " + courseRate);

      }


      @Test
      public void testGetCourseDescription() {
          frontEndBasicPage = new FrontEndBasicPage(driver);
          String courseDescription = frontEndBasicPage.getCourseDescription();
          System.out.println("Course Description: " + courseDescription);


      }

      @Test
      public void clickButtonAllNames() {
          frontEndBasicPage.clickToShowCoachesNames();

      }

      @Test
      public void uploadListName(){
          frontEndBasicPage.getListBlock();
          List<String> coachesNames = frontEndBasicPage.getListCoachesNames();
          System.out.println("Coaches Names: " + coachesNames);
      }

          @AfterClass
          public static void tearDown () {
              // Закрытие браузера
              driver.quit();
          }
      }




