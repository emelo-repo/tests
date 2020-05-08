/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

// Use firefox as the default
// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
driver = { new ChromeDriver() }
//driver = { new FirefoxDriver() }
//driver = { new PhantomJSDriver() }
//driver = { new InternetExplorerDriver()}

environments {

	// run as â€œgradle -Dgeb.env=chrome cucumberâ€�
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	firefox {

		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
        capabilities.setCapability("networkConnectionEnabled", true);
        capabilities.setCapability("browserConnectionEnabled", true);
				capabilities.setJavascriptEnabled(true);
				
  	driver = { new FirefoxDriver(capabilities) }		
	}

	// run as â€œgradle -Dgeb.env=phantomjs cucumberâ€�
	// See: https://github.com/detro/ghostdriver
	phantomjs {
		driver = { new PhantomJSDriver() }
	}

	chrome {
		driver =  { new ChromeDriver() }
  }

	ie {
    driver = {new InternetExplorerDriver()}
  }

	chromeheadless {
	  	//driver =  { new ChromeDriver() }
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	    driver = {new ChromeDriver(chromeOptions)};
  }

}

//baseUrl="http://10.50.11.13/"

//baseUrl="http://10.50.11.21/"

//baseUrl="http://10.50.11.112/"

baseUrl="http://10.50.11.120/"


baseNavigatorWaiting = true
