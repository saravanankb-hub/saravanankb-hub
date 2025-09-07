package TesNgTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.*;

public class Cart extends BaseClass {
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() throws Exception {
        // Set window to 80% of screen
        Dimension screenSize = new Dimension(
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8)
        );

        driver.manage().window().setSize(screenSize);
        driver.get("https://automationexercise.com/products");
        driver.manage().window().maximize();
    }

    @Test
    public void cartDemo() {

        Map<String, Integer> productAndQuantityToAdd = new LinkedHashMap<>();
        productAndQuantityToAdd.put("Men Tshirt", 2);
        productAndQuantityToAdd.put("Stylish Dress", 1);

        int valueToRemove = 1000;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        for (Map.Entry<String, Integer> entry : productAndQuantityToAdd.entrySet()) {
            String productName = entry.getKey();
            Integer quantity = entry.getValue();

            WebElement addToCart = driver.findElement(By.xpath("//div[@class='single-products']/div/p[text()='" + productName + "']/following-sibling::a"));

            for (int i = 0; i < quantity; i++) {
                Actions act = new Actions(driver);
                act.moveToElement(addToCart).scrollToElement(addToCart).click().build().perform();
                WebElement continueToShop = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
                wait.until(ExpectedConditions.elementToBeClickable(continueToShop)).click();
            }
        }

        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']")));
        viewCart.click();

        String cartUrl = driver.getTitle();
        Assert.assertEquals(cartUrl, "Automation Exercise - Checkout");

        List<WebElement> cartItems = driver.findElements(By.xpath("//td[@class='cart_total']/p"));
        List<Integer> cartValues = new ArrayList<>();
        for (WebElement cartItem : cartItems) {
            String cartValue = cartItem.getText();
            cartValues.add(Integer.parseInt(cartValue.split(" ")[1]));
        }

        Optional<String> targetValue = cartValues.stream().filter(value -> value > valueToRemove)
                .map(String::valueOf).findFirst();
        removeFromCart(targetValue, wait);
    }

    private static void removeFromCart(Optional<String> targetValue, WebDriverWait wait) {
        WebElement deleteItem = driver.findElement(By.xpath("//td[@class='cart_total']/p[contains(text(),'" + targetValue.get() + "')]/parent::td/following-sibling::td/a/i"));
        deleteItem.click();
        boolean invisible = wait.until(
                ExpectedConditions.invisibilityOf(deleteItem)
        );
        Assert.assertTrue(invisible, "❌ Item is still visible in UI!");
    }
}