import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;

/**
 * Created by smejari on 9/18/2016.
 */
public class Main {
    public static void main(String args[])
    {
        System.setProperty("webdriver.chrome.driver", "D:\\software\\ChromeDriver\\chromedriver.exe");
        WebDriver wb=new ChromeDriver();
       wb.get("http://www.google.com");



    }
}
