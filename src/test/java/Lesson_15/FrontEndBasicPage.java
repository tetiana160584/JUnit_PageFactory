package Lesson_15;

import configuration.WEBDRIVERS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FrontEndBasicPage {
    private final String buttonShowCoachesNames="//*[@id=\"coachesShowAllButton\"]";
    static WebDriver driverInFrontEndPage;
    private String pageUrl = "https://dnipro.ithillel.ua/courses/front-end-basic";

    public void openPage() {
        driver.get(pageUrl);

    }

    static WebDriver driver;


    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/main/section[1]/div[3]/div/div/div[1]/div/h1/span[1]/strong")
    private WebElement courseTitle;

    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/main/section[1]/div[3]/div/div/div[2]/div/span")
    private WebElement courseRate;

    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/main/section[2]/div/div/div[1]")
    private WebElement courseDescription;

       @FindBy (xpath = "//*[@id=\"coachesSection\"]/div/div/ul")
    private WebElement listBlock;


    @FindBy(xpath = buttonShowCoachesNames )
    private WebElement showCoachesNames;

    @FindBy(css = ".coach-photo_img.lozad[alt] ")
    private List<WebElement> coachesNames;


    public FrontEndBasicPage(WebDriver driver) {
        driverInFrontEndPage = driver;
        PageFactory.initElements(driver, this);

    }



    public String getCourseTitle() {
        return courseTitle.getText();
    }

    public String getCourseRate() {
        return courseRate.getText();
    }


    public String getCourseDescription() {
        return courseDescription.getText();

    }
    public String getListBlock(){
        return listBlock.getText();
    }

    public List<String> getListCoachesNames() {
        List<String> names = new ArrayList<>();
        for (WebElement coachName : coachesNames) {
            names.add(coachName.getAttribute("alt"));
        }
        return names;

    }

    public void clickToShowCoachesNames() {
    scrollToElementVisibilityOf(driverInFrontEndPage,By.xpath(buttonShowCoachesNames));
    showCoachesNames.click();
    }



    private static void scrollToElementVisibilityOf(WebDriver driver, By by) {//метод который скролит до элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;

        boolean bool = false;

        while (!bool) {//цикл проверяет есть ли элемент, если не находит скролит до тех пор пока не найдет этот элемент
            try {
                driver.findElement(by);
                bool = true;
            } catch (Exception ignore) {
                js.executeScript("window.scrollBy(0,1000)");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }





            }
        }
    }

}





