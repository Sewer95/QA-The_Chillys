package VOM.core;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import VOM.fw.RadioStationHelper;
import VOM.fw.HomeHelper;
import VOM.fw.UserHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;

public class ApplicationManager {
  private final String browser;
  public WebDriver driver;
  public WebDriverWait wait;
  @Getter
  UserHelper userHelper;
  @Getter
  HomeHelper homeHelper;
  @Getter
  RadioStationHelper stationHelper;
  public static Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equalsIgnoreCase("chrome")) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-search-engine-choice-screen");
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    }



    wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    driver.get("https://urchin-app-jq2i7.ondigitalocean.app/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    userHelper = new UserHelper(driver, wait);
    homeHelper = new HomeHelper(driver, wait);
    stationHelper = new RadioStationHelper(driver, wait);
  }

  public void stop() {
    String os = System.getProperty("os.name").toLowerCase();
    try {
      if (os.contains("mac")) {
        //logger.info(os.toString());
        driver.quit();
      } else if (os.contains("win")) {
        //logger.info(os.toString());
        //logger.warn("\033[32m" + "Closing WebDriver: " + driver + "\033[0m");
        driver.quit();
        //logger.warn("\033[31m" + "Driver has been successfully closed." + "\033[0m");
      }
    } catch (Exception e) {
      logger.error("\033[31m" + "Exception while quitting the WebDriver: " + e.getMessage() + "\033[0m");
    } finally {
      driver = null;
      if (os.contains("win")) {
        try {
          new ProcessBuilder("taskkill", "/F", "/IM", "chromedriver.exe", "/T").start();
        } catch (IOException e) {
          logger.warn("IOException while trying to kill chromedriver.exe: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }

}
