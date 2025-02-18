package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {

    public static WebDriver driver;

    public BrowserDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarav\\.m2\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/");
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        driver.quit();
    }
}