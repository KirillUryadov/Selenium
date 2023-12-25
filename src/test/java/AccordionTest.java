import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccordionTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void checkAccordion() {


        BasicPage basicPage = new BasicPage(driver);

        for(int i = 0; i <= 7; i++) {

            WebElement elementButton = driver.findElement(By.xpath(".//div[@id='accordion__heading-" + i + "']"));
            WebElement elementPanel = driver.findElement(By.xpath(".//div[@id='accordion__panel-" + i + "']"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementButton);

            Duration timeout = Duration.ofSeconds(3);
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(elementButton));
            elementButton.click();

            Assert.assertTrue(elementPanel.isDisplayed());

        }
    }

    @Test
    public void checkOrder(){


        Order order = new Order(driver);

        Duration timeout = Duration.ofSeconds(3);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(order.getOrderUp()));

        order.clickUpButton();

        order.registration("Антон","Петров","Москов-сити","89094443322");

//        WebElement element3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]"));
//        Assert.assertTrue(element3.isDisplayed());

        order.rent();


    }

    @After
    public void teardown() {
        // Закрываем сайт
        driver.quit();
    }
}