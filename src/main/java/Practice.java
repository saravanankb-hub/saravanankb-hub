import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class Practice {

    private static final ChromeDriver driver = new ChromeDriver();
    private static final String SELECT_ITEM_DROPDOWN_LOCATOR
            = "//div[@id='nav-search-dropdown-card']//select";
    private static final String SEARCH_CATEGORY = "Books";
    private static final String SEARCH_BOX_LOCATOR
            = "//input[@id='twotabsearchtextbox']";
    private static final String SEARCH_ITEM = "finance books";
    private static final String BOOK_LIST_ITEM_LOCATOR = "//div[@data-cy='title-recipe']//h2/span";
    private static final String BOOK_NAME = "The Psychology of Money [Paperback] Morgan Housel";
    private static final String BOOK_TITLE_LOCATOR = "//span[@id='productTitle']";

    public static void main(String[] args) {

        launchAmazonUrl();
        /* IF REQUIRED
        List<WebElement> options = driver.findElements(By.xpath(SELECT_ITEM_DROPDOWN_LOCATOR));
        options.forEach(option -> {
            System.out.print(option.getText());
        });*/
        selectSearchCategory(SEARCH_CATEGORY);
        searchForItem(SEARCH_ITEM);
        selectItemByName(BOOK_NAME);
        isItemDisplayed();
        tearDown();
    }

    private static void tearDown() {
        driver.quit();
    }

    private static void isItemDisplayed() {
        WebElement bookTitle = driver.findElement(By.xpath(BOOK_TITLE_LOCATOR));
        bookTitle.isDisplayed();
        System.out.println(driver.getTitle());
    }

    private static void selectItemByName(String itemName) {
        List<WebElement> bookList = driver.findElements(By.xpath(BOOK_LIST_ITEM_LOCATOR));
        bookList.stream()
                .filter(book -> book.getText().contains(itemName))

                .findFirst().ifPresent(book -> {
                    jsClick(book);
                    driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
                });
    }

    private static void searchForItem(String item) {
        WebElement searchBox = driver.findElement(By.xpath(SEARCH_BOX_LOCATOR));
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }

    private static void selectSearchCategory(String category) {
        WebElement drpDwnValue = driver.findElement(By.xpath(SELECT_ITEM_DROPDOWN_LOCATOR));
        Select itemToBeSelect = new Select(drpDwnValue);
        itemToBeSelect.selectByVisibleText(category);
    }

    private static void launchAmazonUrl() {
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(ofSeconds(8));
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }

    private static void jsClick(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", ele);
        ele.click();
    }

    private static void streamAPICases() {
        driver.get("https://example.com");
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='myDropdown']/option"));
        // Check if all options are enabled using Stream + allMatch
        boolean allEnabled = options.stream()
                .allMatch(WebElement::isEnabled);
        System.out.println(allEnabled);//True

//       --------------All are even number or not----------------------
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("All numbers are even? " + allEven);//All numbers are even? true

        //-------------------Search word partially and trim on spaces----------
        List<String> words = Arrays.asList(" Automation ", "Selenium", "Serenity BDD", "Cucumber", "Java");
        String wordToCheck = "serenity"; // try "sel", "cumb", "auto", etc.

        boolean isMatch = words.stream()
                .map(String::trim) // remove leading/trailing spaces
                .anyMatch(word -> word.toLowerCase().contains(wordToCheck.toLowerCase()));

        if (isMatch) {
            System.out.println("\"" + wordToCheck + "\" is found (partial match) in the list.");
        } else {
            System.out.println("\"" + wordToCheck + "\" is NOT found.");
        }//Op - "serenity" is found (partial match) in the list.

//        ----------------Links are clickable and visible with link--------------
        List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='text']"));
        boolean allFilled = inputs.stream()
                .allMatch(link -> {
                    String href = link.getDomAttribute("href");
                    return href != null && !href.trim().isEmpty()
                            && link.isDisplayed()
                            && link.isEnabled();
                });
    }
}