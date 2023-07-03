package zaka.shop.online.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import zaka.shop.online.configs.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {
  @After(order = 0)
  public static void closeWebDriver() {
    WebDriverRunner.closeWebDriver();
  }

  @After(order = 1)
  public static void clearCache() {
    WebDriverRunner.clearBrowserCache();
  }

  @Before(order = 0)
  public void initDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    Configuration.browserCapabilities = capabilities;
    Configuration.baseUrl = Config.getUrl();
    Configuration.remote = Config.getRemoteUrl();
    Configuration.browserVersion = Config.getBrowserVersion();
    Configuration.timeout = 10_000;
    Configuration.browser = Config.getBrowser();
    Configuration.browserPosition = "10x10";
    if (Config.getBrowser().equals("edge")) {
      EdgeOptions edgeOptions = new EdgeOptions();
      edgeOptions.setCapability("acceptInsecureCerts", true);
      capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
      capabilities.setCapability("browserName", "MicrosoftEdge");
    }
    if (Config.getBrowser().equals("chrome")) {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setCapability("acceptInsecureCerts", true);
      capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    }
    if (Config.getBrowser().equals("firefox")) {
      FirefoxOptions firefoxOptions = new FirefoxOptions();
      firefoxOptions.addPreference("security.insecure_field_warning.contextual.enabled", false);
      firefoxOptions.addPreference("security.insecure_password.ui.enabled", false);
      capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
      capabilities.setCapability("browserName", "firefox");
    }
  }
}
