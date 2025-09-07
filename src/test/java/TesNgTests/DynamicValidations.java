package TesNgTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicValidations extends BaseClass {

    static String urlMain = "https://the-internet.herokuapp.com/";

    @Test
    public void validateDynamicLoading() {
        driver.get(urlMain + "dynamic_loading");
        WebElement ele = driver.findElement(By.xpath("//div[@id='content']/div//p/following::a"));
        ele.click();

        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement loading = driver.findElement(By.id("loading"));
        wait.until(ExpectedConditions.visibilityOf(loading));

        wait.until(ExpectedConditions.domAttributeToBe(loading, "style", "display: none;"));

        String textActual = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        Assert.assertEquals(textActual, "Hello World!");
    }
}