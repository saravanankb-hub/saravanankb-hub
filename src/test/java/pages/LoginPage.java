package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.BrowserDriver;
import utility.getScreenShotOf;

import java.io.IOException;

public class LoginPage extends BrowserDriver {

    public static getScreenShotOf getScreenShotOf = new getScreenShotOf();
    public static String HAMBURGER_MENU = "//div[@id='menuToggle']/input";
    public static String SIGN_IN_LINK = HAMBURGER_MENU + "/../ul[@id='menu']//li[text()='Sign In Portal']";
    public static String USER_NAME = "//input[@id='usr']";
    public static String PASSWORD = "//input[@id='pwd']";
    public static String LOGIN = "//input[@value='Login']";

    public static void click_hamburger_menu() {
        driver.findElement(By.xpath(HAMBURGER_MENU)).click();
    }

    public static void click_signIn_Link() {
        driver.findElement(By.xpath(SIGN_IN_LINK)).click();
    }

    public static void enter_userName() {
        driver.findElement(By.xpath(USER_NAME)).sendKeys("hello");
    }

    public static void enter_password() {
        driver.findElement(By.xpath(PASSWORD)).sendKeys("hello");
    }

    public static void click_login() {
        driver.findElement(By.xpath(LOGIN)).click();
    }

    public static void view_mainPage() throws IOException {
        String currentUrl = driver.getCurrentUrl();
        boolean isHomePage = false;
        if (currentUrl != null) {
            isHomePage = currentUrl.contains("AceOnlineShoePortal/ShoeTypes");
        }
        getScreenShotOf.takeScreenShot((ChromeDriver) driver);
        System.out.println((isHomePage ? "Your are in Home page!" : "Not a home page ... Wrong URL detected:") + currentUrl);
    }
}