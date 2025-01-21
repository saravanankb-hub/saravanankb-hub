import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.apache.commons.io.function.IOConsumer.forEach;

public class makeMyTrip {
    static WebDriver driver1;

    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();
        driver1 = driver;
        driver.get("https://www.makemytrip.com/");
        String startDate = "15-January-2024";
        String endDate = "15-February-2024";
        driver.manage().timeouts().implicitlyWait(ofSeconds(8));
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebElement closePopup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(closePopup)).click();
        driver.findElement(By.xpath("//li[@class='menu_Hotels']/span")).click();
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.click();
        driver.findElement(By.xpath("//input[@title='Where do you want to stay?']")).sendKeys("Andaman");
        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/descendant::li/descendant::p[contains(@class,'makeFlex')]/../span"));
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase("Neil Island")) {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("arguments[0].click();", suggestion);
                File src = driver.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("E:\\Working_directory\\My_Repo\\src\\test\\java\\org\\example\\screenshots.png"));
                break;
            }
        }
        selectDates(startDate, endDate, driver1);
        verifyRoomAndAdultCount("1", "2", driver1);
        driver.quit();
    }

    private static void selectDates(String startDate, String endDate, WebDriver driver) {
        String[] startDateDtl = startDate.split("-");
        String[] endDateDtl = endDate.split("-");
        String monthIndex = "//div[@class='DayPicker-Caption']/div";
        String checkInMonth = startDateDtl[1];
        String checkOutMonth = endDateDtl[1];
        String checkInDate = startDateDtl[0];
        String checkOutDate = endDateDtl[0];
        WebElement inDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][text()='" + checkInDate + "']"));
        WebElement outDate = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]/following::div[@class='DayPicker-Day'][text()='" + checkOutDate + "'][2]"));
        WebElement nextNav = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        List<WebElement> months = driver.findElements(By.xpath(monthIndex));
        Iterator<WebElement> iterator = months.iterator();

        iterator.forEachRemaining(element -> {
            if (element.getText().contains(checkInMonth) | element.getText().contains(checkOutMonth)) {
                getClick(inDate);
                getClick(outDate);
            } else {
                getClick(nextNav);
            }
        });

    }

    private static void getClick(WebElement nextNav) {
        nextNav.click();
    }

    private static void verifyRoomAndAdultCount(String roomCount, String bedCount, WebDriver driver) {
        List<String> checkItems = new ArrayList<>();
        checkItems.add("Room");
        checkItems.add("Bed");
        checkItems.forEach(item -> {
            int i = 0;
            WebElement countEle = driver.findElement(By.xpath("//div/p[text()='" + checkItems.get(i) + "s']/following::span[@data-testid='" + checkItems.get(i) + "_count']"));
            countEle.isDisplayed();
            countEle.getText().equalsIgnoreCase(roomCount);
            countEle.getText().equalsIgnoreCase(bedCount);
            i++;
        });

//        WebElement roomsEle = driver.findElement(By.xpath("//div/p[text()='Rooms']/following::span[@data-testid='room_count']"));

//        roomsEle.isDisplayed();
//        roomsEle.getText().equalsIgnoreCase("1");
    }
}