package VOM.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import VOM.core.BaseHelper;
import VOM.model.RadioStation;

import java.util.List;

public class RadioStationHelper extends BaseHelper {
  public static final String CONTACT_NAME = "";
  private static final String BUTTON_REMOVE = "//button[text()='Remove']";
  private static final String CONTACT_LOCATOR = "contact-item_card__2SOIM";

  public RadioStationHelper(WebDriver driver, WebDriverWait wait) {
    super(driver,wait);
  }

  public boolean isContactAdded(String textToFind) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    for(WebElement element : contacts){
      if(element.getText().contains(textToFind))
        return true;
    }
    return false;
  }

  public void addNewContactPositiveData(String name) {
    clickADDLink();

    clickOnSAVEContactButton();
  }

  public void fillAddContactForm(RadioStation contact) {

  }

  public void clickOnSAVEContactButton() {
    click(By.xpath("//b[.='Save']"));
  }

  public void clickADDLink() {
    click(By.xpath("//a[.='ADD']"));
  }

  public int actualSizeOfContacts() {
    if(isElementPresent(By.className(CONTACT_LOCATOR))){
      return driver.findElements(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div")).size();
    }
    return 0;
  }

  public void deleteOneContactOnly() {
    if (isElementPresent(By.className(CONTACT_LOCATOR))) {
      click(By.className(CONTACT_LOCATOR));
      click(By.xpath("//button[text()='Remove']"));
    } else {
      System.out.println("Contact not found.");
    }
  }

//  public void deleteAllContacts() {
//    try {
//      while (hasContacts()) { // Цикл пока контакты не закончатся
//        // Шаг 1: Получить текущее количество контактов
//        int contactsBefore = actualSizeOfContacts();
//        // Шаг 2: Выполнить удаление контакта
//        click(By.className(CONTACT_LOCATOR));
//        click(By.xpath(BUTTON_REMOVE));
//        // Шаг 3: Ожидать, пока количество контактов на странице не станет меньше
//        /*
//         * Лямбда-выражение, которое принимает экземпляр WebDriver и возвращает true или false.
//         * WebDriver d - параметр лямбда-выражения, представляющий текущий экземпляр драйвера.
//         * Условие проверяет, уменьшилось ли количество контактов на странице по сравнению с исходным значением contactsBefore
//         * */
//        wait.until((WebDriver d) -> actualSizeOfContacts() < contactsBefore);
//      }
//    } catch (NoSuchElementException e) {
//      System.out.println("Все контакты были удалены.");
//    }
//  }

  private boolean hasContacts() {
    // Проверьте, нет ли контактов, не дожидаясь долго
    return isElementPresent(By.className(CONTACT_LOCATOR));
  }
}
