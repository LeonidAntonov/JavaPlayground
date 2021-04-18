import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson3 {

    private Logger logger = LogManager.getLogger(Lesson3.class);
    private static WebDriver driver;

    @Test
    public  void LogExample() {
    logger.info("Тест старт");
    }

    @Test
    public void WebDriverTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
        driver.get("https://otus.ru");
        logger.info("Сайт открыт");
        if (driver!=null)
            driver.quit();
    }

}
