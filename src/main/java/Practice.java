import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.WindowType.TAB;

public class Practice {
    static WebDriver driver1;

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver1 = driver;
        driver.get("https://www.amazon.in/");
        String toSearchItem = "Books";
        String toSearchSubItem = "finance books";
        String bookName = "The Psychology of Money [Paperback] Morgan Housel";
        String selectItemDrpDwn = "//div[@id='nav-search-dropdown-card']//select";
        driver.manage().timeouts().implicitlyWait(ofSeconds(8));
        driver.manage().window().maximize();
        driver.navigate().refresh();
        List<WebElement> options = driver.findElements(By.xpath(selectItemDrpDwn));
        options.forEach(option -> {
            System.out.println(option.getText());
        });
        WebElement drpDwnValue = driver.findElement(By.xpath(selectItemDrpDwn));
        Select itemToBeSelect = new Select(drpDwnValue);
        itemToBeSelect.selectByVisibleText(toSearchItem);
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys(toSearchSubItem);
        searchBox.sendKeys(Keys.ENTER);
        List<WebElement> bookList = driver.findElements(By.xpath("//div[@data-cy='title-recipe']//h2/span"));
        Iterator<WebElement> iterator = bookList.iterator();
        iterator.forEachRemaining(book -> {
            if (book.getText().contains(bookName)) {
                click(book);
                driver.switchTo().newWindow(TAB);
            }
        });
        WebElement bookTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
        bookTitle.isDisplayed();
        driver.quit();
    }


    private static void click(WebElement ele) {
        ((JavascriptExecutor) driver1).executeScript("arguments[0].scrollIntoView(true)", ele);
        ele.click();
    }
}