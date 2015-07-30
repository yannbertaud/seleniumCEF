import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Example  {
  public static void main(String[] args) {
	  
	// download chrome driver from https://sites.google.com/a/chromium.org/chromedriver/downloads
	// download cef client from http://www.magpcss.net/cef_downloads/index.php?query=label%3A~Deprecated+label%3ACEF3+label%3Abinary#list
	  
	String OS = System.getProperty("os.name").toLowerCase();  
	System.out.println("operating system: " + OS);
	String cefBinaryLocation;
    // Path to the ChromeDriver executable.	
	if (OS.startsWith("win")) {
	    System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
	    cefBinaryLocation = "c:/temp/cef_binary_3.2171.1979_windows32_client/Release/cefclient.exe";
	} else if (OS.startsWith("mac")) {
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    cefBinaryLocation = "/Users/yannbertaud/Desktop/cefClientMac/cef_binary_3.2171.1979_macosx64_client/Release/cefclient.app/Contents/MacOS";
	}
    
    // from https://sites.google.com/a/chromium.org/chromedriver/capabilities
    // Path to the CEF executable.
    ChromeOptions options = new ChromeOptions();
//    options.setBinary(cefBinaryLocation);

    WebDriver driver = new ChromeDriver(options);
    driver.get("http://www.google.com/xhtml");
    sleep(3000);  // Let the user actually see something!
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    sleep(3000);  // Let the user actually see something!
    driver.quit();
  }

  static void sleep(int time) {
    try { Thread.sleep(time); } catch (InterruptedException e) {}
  }
}