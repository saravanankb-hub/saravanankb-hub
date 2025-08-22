import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxSelection {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qa-practice.com/elements/checkbox/mult_checkbox");

        // Get all checkbox inputs
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='div_id_checkboxes']//input[@type='checkbox']"));

        for (WebElement checkbox : checkBoxes) {
            String id = checkbox.getDomAttribute("id");

            // Find the label with matching "for" attribute
            WebElement label = driver.findElement(By.xpath("//label[@for='" + id + "']"));
            String labelText = label.getText().trim();

            if (!labelText.equalsIgnoreCase("Three")) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        }
//--------------------------------------------------using Stream--------------------
        checkBoxes.stream()
                .filter(c -> {
                    //Next 3 lines should comefrom For and IF block is used for stream
                    String id = c.getDomAttribute("id");
                    WebElement label = driver.findElement(By.xpath("//label[@for='" + id + "']"));
                    return !label.getText().trim().equalsIgnoreCase("Three");
                })
                .filter(cb -> !cb.isSelected())
                .forEach(WebElement::click);
        driver.quit(); // Optional: close browser
    }
}