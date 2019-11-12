package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSingleton {
    private static WebDriver driver;

        private DriverSingleton(){ }

        public static WebDriver getDriver(){
            if(driver == null){
                return DriverFactory.getDriverType(driverName);
            }
            return driver;
        }
}
