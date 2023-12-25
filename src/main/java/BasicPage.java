import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicPage {


    //Кнопки с вопросами
    private By accordionButton = By.className("accordion__button");
    //Ответы на вопросы
    private By accordionPanel = By.className("accordion__panel");


    WebDriver driver;

    BasicPage(WebDriver driver){
        this.driver = driver;
    }



    public void clickButtonAccordion(){
        driver.findElement(accordionButton).click();
    }

    public String getTextAccordionButton(){

        return driver.findElement(accordionButton).getText(); //тут все кнопки, а не одна
    }

    public String getTextAccordionPanel(){
        return driver.findElement(accordionPanel).getText(); //тут весь список, а не один (как выбрать 1 и сравнить с нужной кнопкой) в конце [] и через цикл
    }



}
