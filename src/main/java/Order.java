import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Order {

    //Кнопка заказа сверху
    private By orderUp = By.cssSelector(".Button_Button__ra12g");
    //Кнопка заказа снизу
    private By orderDown = By.cssSelector(".Button_Button__ra12g Button_UltraBig__UU3Lp");

    //input для заявки
    private By name = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private By secondName = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    private By address = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    private By telephone = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");

    private By metro = By.xpath(".//input[@class='select-search__input']");
    // выпадающий список из метро
    private By listMetro = By.xpath(".//div[@class='select-search__select']/ul/li/button[@value='5']");

    //кнопка далее
    private By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");

    //input про аренду

    private By dateCome = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // выбрать дату

    private By dateCalendar = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]");

    private By term = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]");

    private By termDays = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");

    private By color = By.xpath("//*[@id=\"black\"]") ;

    private By comment = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");

    private By orderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");

    private By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    private By statusButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button");



    WebDriver driver;

    Order(WebDriver driver){
        this.driver = driver;
    }

    //нажимаем на заказ сверху
    public void clickUpButton(){

        driver.findElement(orderUp).click();
    }
    //нажимаем на заказ снизу
    public void clickDownButton(){

        driver.findElement(orderDown).click();
    }

    //Получаем положение кнопки заказа сверху
    public By getOrderUp(){
        return orderUp;
    }

    //Получаем положение кнопки заказа снизу
    public By getOrderDown(){
        return orderDown;
    }

    //Получаем положение строки для даты
    public By getDateCome(){
        return dateCome;
    }




    //Запись имени
    public void setName(String name){
        driver.findElement(this.name).clear();
        driver.findElement(this.name).sendKeys(name);
    }

    //Запись фамилии
    public void setSecondName(String secondName){
        driver.findElement(this.secondName).clear();
        driver.findElement(this.secondName).sendKeys(secondName);
    }
    //Запись адреса из списка

    public void setAddress(String address){
        driver.findElement(this.address).clear();
        driver.findElement(this.address).sendKeys(address);
    }

    //Выбор метро из списка
    public void setMetro(){
        driver.findElement(this.metro).click();

        Duration timeout = Duration.ofSeconds(3);
//        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(this.listMetro));

        driver.findElement(this.listMetro).click();
    }


    //Запись номера
    public void setTelephone(String telephone){
        driver.findElement(this.telephone).clear();
        driver.findElement(this.telephone).sendKeys(telephone);
    }

    // Нажимаем на кнопку далее
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    // Объединение в 1 шаг (форма "для кого")
    public void registration(String name, String secondName, String address, String telephone ){
        setName(name);
        setSecondName(secondName);
        setAddress(address);
        setMetro();
        setTelephone(telephone);
        clickNextButton();

    }

    //Заполняем дату для аренды

    public void clickDateCome(){
        driver.findElement(dateCome).click();
        driver.findElement(dateCalendar).click();
    }
    public void clickTerm(){
        driver.findElement(term).click();
        driver.findElement(termDays).click();
    }

    public void clickColor(){
        driver.findElement(color).click();
    }

    public void sendComment(){
        driver.findElement(comment).sendKeys("Жду вас");

    }

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }

    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }

    public void clickStatusButton(){
        driver.findElement(statusButton).click();
    }

    //Объединение в 1 шаг (форма "про аренду")
    public void rent(){
        clickDateCome();
        clickTerm();
        clickColor();
        sendComment();
        clickOrderButton();
        clickYesButton();
        clickStatusButton();
    }




}
