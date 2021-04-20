import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autotests {
    private Logger logger = LogManager.getLogger(Autotests.class);

    private static WebDriver driver;

    @Test
    public void logChecker() {
        logger.info("Проверяем цвет для инфо");
        logger.error("Проверяем цвет для ошибки");
        logger.fatal("Проверяем цвет для фатальной ошибки");
        logger.trace("Проверяем цвет для трассировки");
        logger.warn("Проверяем цвет для предупреждения");
        logger.debug("Проверяем цвет для дебага");
    }

    @Before
    public void startWebDriver(){
        WebDriverManager.chromedriver().setup();
        if (driver == null)
            driver = new ChromeDriver();

    }



    @Test
    public void webDriverTestAndAssert() {
        logger.info("Драйвер успешно запущен");
        driver.get("https://otus.ru");
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        if (expectedTitle.equals(actualTitle)) {
            logger.info("Название сайта = {}" ,driver.getTitle());
        }
        else logger.warn("Не удалось получить информацию о титульной странице");
    }

    @After
    public void quitWebDriver(){
        driver.quit();
    }
}
