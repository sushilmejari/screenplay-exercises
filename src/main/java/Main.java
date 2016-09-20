import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by smejari on 9/21/2016.
 */
public class Main {
public static void main(String args[])
{
    System.setProperty("webdriver.chrome.driver","D:\\software\\ChromeDriver\\chromedriver.exe");
    WebDriver webDriver=new ChromeDriver();
    webDriver.get("https://www.google.co.in/");
}
}
