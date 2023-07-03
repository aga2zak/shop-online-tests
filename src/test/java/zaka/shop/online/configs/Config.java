package zaka.shop.online.configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

  private static String url;
  private static String remoteUrl;
  private static String browserVersion;
  private static String browser;

  static {
    prepare();
  }

  Config() {}

  public static String getUrl() {
    return url;
  }

  public static String getRemoteUrl() {
    return remoteUrl;
  }

  public static String getBrowserVersion() {
    return browserVersion;
  }

  public static String getBrowser() {
    return browser;
  }

  private static void prepare() {
    url = System.getProperty("url", null);
    remoteUrl = System.getProperty("remoteUrl", null);
    browserVersion = System.getProperty("browserVersion", null);
    browser = System.getProperty("browser", null);
    if (url == null || remoteUrl == null || browserVersion == null) {
      prepareFromProperties();
    }
  }

  private static void prepareFromProperties() {
    Properties loadPropFile = new Properties();
    try (FileInputStream fs = new FileInputStream("src/test/resources/config.properties")) {
      loadPropFile.load(fs);
      if (url == null) {
        url = loadPropFile.getProperty("url");
      }
      if (remoteUrl == null) {
        remoteUrl = loadPropFile.getProperty("remoteUrl");
      }
      if (browserVersion == null) {
        browserVersion = loadPropFile.getProperty("browserVersion");
      }
      if (browser == null) {
        browser = loadPropFile.getProperty("browser");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
