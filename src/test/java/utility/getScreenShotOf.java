package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class getScreenShotOf {

    public void takeScreenShot(ChromeDriver driver) throws IOException {
        File src = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("E:\\Working_directory\\My_Repo\\src\\test\\java\\org\\example\\screenshots\\screenshots.png"));
    }
}
