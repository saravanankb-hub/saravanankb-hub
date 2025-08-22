import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.IntStream;

public class CheckBoxClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qa-practice.com/elements/checkbox/mult_checkbox");
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[contains(@id,'checkbox')]"));

        IntStream.range(0, checkBoxes.size())
                .filter(c -> c != 2)
                .mapToObj(checkBoxes::get)
                .filter(cb -> !cb.isSelected())
                .forEach(WebElement::click);
    }
    //getting all the checkboxes expect 3rd checkbox others it will check if not checked.
}