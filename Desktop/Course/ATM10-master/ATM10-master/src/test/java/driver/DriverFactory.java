package driver;

public class DriverFactory
{
	public IDriverFactory getDriverType(String driver){
		if(driver.equals("chrome")){
			return new ChromeCreator();
		}
		else if(driver.equals("firefox")){
			return new FirefoxCreator();
		}
		return null;
	}

}
