import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autotests {
    private Logger logger = LogManager.getLogger(Autotests.class);

    private static WebDriver driver;

    @Test
    public void LogChecker() {
        logger.info("Проверяем цвет для инфо");
        logger.error("Проверяем цвет для ошибки");
        logger.fatal("Проверяем цвет для фатальной ошибки");
        logger.trace("Проверяем цвет для трассировки");
        logger.warn("Проверяем цвет для предупреждения");
        logger.debug("Проверяем цвет для дебага");
    }

    @Test
    public void WebDriverTestAndAssert() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер успешно запущен");
        driver.get("https://otus.ru");
        String title = driver.getTitle();
        if (StringUtils.isEmpty(title) == false) {
            logger.info("Название сайта = " + driver.getTitle());
        }
        else logger.warn("Не удалось получить информацию о титульной странице");

        driver.quit();
    }

}
